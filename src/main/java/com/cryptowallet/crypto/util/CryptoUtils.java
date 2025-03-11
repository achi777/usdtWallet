package com.cryptowallet.crypto.util;

import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class CryptoUtils {

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public static String getTronAddress(byte[] publicKey) {
        byte[] hash = new Keccak.Digest256().digest(publicKey);
        byte[] address = new byte[21];
        address[0] = (byte) 0x41;
        System.arraycopy(hash, hash.length - 20, address, 1, 20);
        return Hex.toHexString(address);
    }
}
