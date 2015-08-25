package com.futurehax.myqplugin;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.futurehax.chamberlainsdk.models.Device;
import com.futurehax.chamberlainsdk.models.Devices;
import com.futurehax.chamberlainsdk.models.SecretToken;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Ken Kyger on 8/20/15.
 * Github - r2DoesInc
 * Email - r2DoesInc@futurehax.com
 */

public class ApiUtils {
    LoginUtils loginUtils;
    boolean ready = false;
    Context ctx;

    Handler delayedTaskHandler = new Handler();

    class RunnableMethod implements Runnable {
        Method method;
        Object[] params;

        public RunnableMethod(Method method, Object[] params) {
            this.method = method;
            this.params = params;
        }

        @Override
        public void run() {
            if (ready) {
                try {
                    method.invoke(ApiUtils.this, params);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                delayedTaskHandler.postDelayed(this, 500);
            }
        }
    }

    public ApiUtils(Context ctx) {
        this.ctx = ctx;
        loginUtils = new LoginUtils(ctx);
        if (loginUtils.hasLoginCreds()) {
            refreshToken(new FutureCallback<SecretToken>() {
                @Override
                public void onCompleted(Exception e, SecretToken result) {
                    if (e == null) {
                        ready = true;
                    } else {
                        Toast.makeText(ApiUtils.this.ctx, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            ready = true;
        }
    }


    public String generateURL(int requestType, String... params) {
        switch (requestType) {
            case ApiConstants.LOGIN_REQUEST:
                return ApiConstants.URL_BASE + ApiConstants.URL_LOGIN_PATH + ApiConstants.APP_ID_PARAM +
                        "&securityToken=" + loginUtils.getToken() + "&username=" + params[0] +
                        "&password=" + params[1] + ApiConstants.APP_CULTURE_PARAM;

            case ApiConstants.DEVICES_REQUEST:
                return ApiConstants.URL_BASE + ApiConstants.URL_DEVICES_PATH + ApiConstants.APP_ID_PARAM + "&securityToken=" + loginUtils.getToken().getKey();

            case ApiConstants.SET_DEVICE_REQUEST:
                return ApiConstants.HTTPS_URL_BASE + ApiConstants.URL_SET_DEVICES_PATH;

            case ApiConstants.GET_DEVICE_REQUEST:
                return ApiConstants.URL_BASE + ApiConstants.URL_GET_ATTRIBUTE_PATH + ApiConstants.APP_ID_PARAM + "&securityToken=" + loginUtils.getToken().getKey();

            default:
                return "";
        }
    }

    public void loginUser(final String email, final String password, final FutureCallback<SecretToken> callback) {


        Ion.with(ctx)
                .load(generateURL(ApiConstants.LOGIN_REQUEST, email, password))
                .asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject res) {
                SecretToken token = null;
                Exception ex = e;
                if (e == null) {
                    String error = res.get("ErrorMessage").getAsString().trim();
                    if (!error.isEmpty()) {
                        ex = new Exception(error);
                    } else {
                        token = new SecretToken(res.get("SecurityToken").getAsString(), System.currentTimeMillis());
                        loginUtils.setLoginInfo(token, email, password);
                    }
                    callback.onCompleted(ex, token);
                }
            }
        });
    }

    public void getDevices(final FutureCallback<Devices> callback) {
        if (ready) {
            Ion.with(ctx)
                    .load(generateURL(ApiConstants.DEVICES_REQUEST))
                    .as(Devices.class)
                    .setCallback(new FutureCallback<Devices>() {
                        @Override
                        public void onCompleted(Exception e, Devices res) {
                            Exception ex = e;
                            if (e == null) {
                                String error = res.getErrorMessage().trim();
                                if (!error.isEmpty()) {
                                    ex = new Exception(error);
                                }
                            }
                            callback.onCompleted(ex, res);
                        }
                    });
        } else {
            RunnableMethod m = new RunnableMethod(new Object(){}.getClass().getEnclosingMethod(), new Object[] {callback});
            delayedTaskHandler.post(m);
        }
    }


    private void refreshToken(final FutureCallback<SecretToken> cb) {
        refreshToken(cb, false);
    }

    private void refreshToken(final FutureCallback<SecretToken> cb, boolean force) {

        if (force || System.currentTimeMillis() - loginUtils.getToken().getUpdatedAt() > 1000 * 60 * 30) {
            Log.d("Updating token!", new Date(System.currentTimeMillis()).toGMTString());
            loginUser(loginUtils.getEmail(), loginUtils.getPassword(), new FutureCallback<SecretToken>() {
                @Override
                public void onCompleted(Exception e, SecretToken result) {
                    if (e == null) {
                        loginUtils.setLoginInfo(result, loginUtils.getEmail(), loginUtils.getPassword());
                        cb.onCompleted(e, result);
                    } else {
                        cb.onCompleted(e, null);
                    }
                }
            });
        } else {
            cb.onCompleted(null, loginUtils.getToken());
        }
    }

    public void getDeviceAttribute(final Device d,
                                   final String attributeName, final FutureCallback<JsonObject> callback) {
        if (ready) {
            Ion.with(ctx).load("GET", generateURL(ApiConstants.GET_DEVICE_REQUEST) +
                    "&devId=" + d.getDeviceId() +
                    "&name=" + attributeName)
                    .asJsonObject().setCallback(callback);
        } else {
            RunnableMethod m = new RunnableMethod(new Object(){}.getClass().getEnclosingMethod(), new Object[] {d, attributeName, callback});
            delayedTaskHandler.post(m);
        }
    }


    public void setDeviceAttribute(String deviceId,
                                   String attributeName, Object attributeValue,
                                   final FutureCallback<String> callback) {
        final JsonObject json = new JsonObject();
        json.addProperty(ApiConstants.ATTRIBUTE_NAME_PARAM_FIELD, attributeName);
        json.addProperty(ApiConstants.DEVICE_ID_PARAM_FIELD, deviceId);
        json.addProperty(ApiConstants.APPLICATION_ID_PARAM_FIELD, ApiConstants.APP_ID_VALUE);
        if (attributeValue instanceof String) {
            json.addProperty(ApiConstants.ATTRIBUTE_VALUE_PARAM_FIELD, (String) attributeValue);
        } else if (attributeValue instanceof Number) {
            json.addProperty(ApiConstants.ATTRIBUTE_VALUE_PARAM_FIELD, (Number) attributeValue);
        }
        json.addProperty(ApiConstants.SECURITY_TOKEN_PARAM_FIELD, loginUtils.getToken().getKey());
        Log.d("THE PAYLOAD", json.toString());
        if (ready) {
            Ion.with(ctx).load("PUT", generateURL(ApiConstants.SET_DEVICE_REQUEST))
                    .setHeader(ApiConstants.CONTENT_TYPE_PARAM_FIELD, "application/json")
                    .setJsonObjectBody(json)
                    .asString().setCallback((callback == null) ? new FutureCallback<String>() {
                @Override
                public void onCompleted(Exception e, String result) {
                    Toast.makeText(ctx, result.toString(), Toast.LENGTH_LONG).show();
                }
            } : callback);
        } else {
            RunnableMethod m = new RunnableMethod(new Object(){}.getClass().getEnclosingMethod(), new Object[] {deviceId, attributeName, attributeValue, callback});
            delayedTaskHandler.post(m);
        }
    }

}
