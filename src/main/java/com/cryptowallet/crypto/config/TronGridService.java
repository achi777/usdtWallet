package com.cryptowallet.crypto.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TronGridService {

    private final WebClient webClient;

    public TronGridService(@Value("${tron.node-url}") String tronNodeUrl,
                           @Value("${tron.api-key}") String tronApiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(tronNodeUrl)
                .defaultHeader("TRON-PRO-API-KEY", tronApiKey)
                .build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
