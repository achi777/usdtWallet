package com.cryptowallet.crypto.controller;

import com.cryptowallet.crypto.util.CryptoUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @GetMapping("/generate")
    public Map<String, String> generateWallet() {
        try {
            KeyPair keyPair = CryptoUtils.generateKeyPair();
            byte[] publicKey = keyPair.getPublic().getEncoded();
            byte[] privateKey = keyPair.getPrivate().getEncoded();

            Map<String, String> response = new HashMap<>();
            response.put("address", CryptoUtils.getTronAddress(publicKey));
            response.put("privateKey", Base64.getEncoder().encodeToString(privateKey));

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error generating wallet", e);
        }
    }
}
