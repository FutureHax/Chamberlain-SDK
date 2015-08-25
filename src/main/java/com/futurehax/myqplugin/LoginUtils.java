package com.futurehax.myqplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.futurehax.chamberlainsdk.models.Crypto;
import com.futurehax.chamberlainsdk.models.Encryptor;
import com.futurehax.chamberlainsdk.models.SecretToken;

import javax.crypto.SecretKey;

/**
 * Created by Ken Kyger on 8/25/15.
 * Github - r2DoesInc
 * Email - r2DoesInc@futurehax.com
 */
public class LoginUtils {
    SharedPreferences prefs;

    public LoginUtils(Context ctx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);

    }

    public SecretToken getToken() {
        String tokenValue = prefs.getString("token", "null");
        long tokenUpdated = Long.parseLong(prefs.getString("token_updated", "0"));
        return new SecretToken(tokenValue, tokenUpdated);
    }

    private void setToken(SecretToken token) {
        prefs.edit().putString("token", token.getKey()).apply();
        prefs.edit().putString("token_updated", String.valueOf(token.getUpdatedAt())).apply();
    }

    public void setLoginInfo(SecretToken token, String email, String password) {
        setToken(token);
        setEmail(email);
        setPassword(password);
    }

    public String getPassword() {
        String encrypted = prefs.getString("password", null);
        return encryptor.decrypt(encrypted, getEmail());
    }

    private void setPassword(String plaintext) {
        prefs.edit().putString("password", encryptor.encrypt(plaintext, getEmail())).apply();
    }

    public String getEmail() {
        return prefs.getString("email", null);
    }

    private void setEmail(String email) {
        prefs.edit().putString("email", email).apply();
    }

    private final Encryptor encryptor = new Encryptor() {

        @Override
        public SecretKey deriveKey(String password, byte[] salt) {
            return Crypto.deriveKeyPbkdf2(salt, password);
        }

        @Override
        public String encrypt(String plaintext, String password) {
            byte[] salt = Crypto.generateSalt();
            key = deriveKey(password, salt);

            return Crypto.encrypt(plaintext, key, salt);
        }

        @Override
        public String decrypt(String ciphertext, String password) {
            return Crypto.decryptPbkdf2(ciphertext, password);
        }
    };


    public void clearLoginInfo() {
        prefs.edit()
                .putString("password", null)
                .putString("token", null)
                .putString("token_updated", null)
                .putString("email", null)
                .apply();
    }

    public boolean hasLoginCreds() {
        return !(getToken() == null ||
                getEmail() == null ||
                getPassword() == null);
    }
}
