package com.futurehax.chamberlainsdk.models;

import javax.crypto.SecretKey;

public abstract class Encryptor {
        public SecretKey key;

        public abstract SecretKey deriveKey(String passpword, byte[] salt);

        public abstract String encrypt(String plaintext, String password);

        public abstract String decrypt(String ciphertext, String password);

        String getRawKey() {
            if (key == null) {
                return null;
            }

            return Crypto.toHex(key.getEncoded());
        }
    }