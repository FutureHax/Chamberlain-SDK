package com.futurehax.myqplugin;

import android.content.Context;

import com.futurehax.chamberlainsdk.BuildConfig;

public final class ApiConstants {
    public static final String APP_ID_VALUE = "Vj8pQggXLhLy0WHahglCD4N1nAkkXQtGYpq2HrHD7H1nvmbT55KqtN6RSF4ILB%2fi";
    public static final String APP_ID_PARAM = "?appId=" + APP_ID_VALUE;
    public static final String APP_CULTURE_VALUE = "en";
    public static final String APP_CULTURE_PARAM = "&culture=" + APP_CULTURE_VALUE;
    public static final String URL_BASE = "http://myqexternal.myqdevice.com/";
    public static final String HTTPS_URL_BASE = "https://myqexternal.myqdevice.com/";
    public static final String URL_LOGIN_PATH = "Membership/ValidateUserWithCulture";
    public static final String URL_DEVICES_PATH = "/api/UserDeviceDetails";
    public static final String URL_SET_DEVICES_PATH = "Device/setDeviceAttribute";
    public static final String URL_GET_ATTRIBUTE_PATH = "/Device/getDeviceAttribute";

    public static final String ATTRIBUTE_NAME_PARAM_FIELD = "AttributeName";
    public static final String DEVICE_ID_PARAM_FIELD = "DeviceId";
    public static final String APPLICATION_ID_PARAM_FIELD = "ApplicationId";
    public static final String ATTRIBUTE_VALUE_PARAM_FIELD = "AttributeValue";
    public static final String SECURITY_TOKEN_PARAM_FIELD = "SecurityToken";
    public static final String CONTENT_TYPE_PARAM_FIELD = "Content-Type";

    public static final String LOG_TAG = "MyQ Plugin";
    public static final int LOGIN_REQUEST = 0;
    public static final int DEVICES_REQUEST = 1;
    public static final int SET_DEVICE_REQUEST = 2;
    public static final int GET_DEVICE_REQUEST = 3;


    public static final boolean IS_LOGGABLE = true;

    public static final boolean IS_PARAMETER_CHECKING_ENABLED = BuildConfig.DEBUG;

    public static final boolean IS_CORRECT_THREAD_CHECKING_ENABLED = BuildConfig.DEBUG;

    public static int getVersionCode(final Context context) {
        if (ApiConstants.IS_PARAMETER_CHECKING_ENABLED) {
            if (null == context) {
                throw new IllegalArgumentException("context cannot be null"); //$NON-NLS-1$
            }
        }

        try {
            return context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (final UnsupportedOperationException e) {
            return 1;
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ApiConstants() {
        throw new UnsupportedOperationException(
                "This class is non-instantiable"); //$NON-NLS-1$
    }
}