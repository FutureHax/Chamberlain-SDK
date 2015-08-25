package com.futurehax.chamberlainsdk.models;

/**
 * Created by Ken Kyger on 8/21/15.
 * Github - r2DoesInc
 * Email - r2DoesInc@futurehax.com
 */
public class SecretToken {

    String key;

    public void setKey(String key) {
        this.key = key;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getKey() {

        return key;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    long updatedAt;

    public SecretToken(String key, long updatedAt) {
        this.key = key;
        this.updatedAt = updatedAt;
    }
}
