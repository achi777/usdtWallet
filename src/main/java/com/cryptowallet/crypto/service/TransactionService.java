package com.cryptowallet.crypto.service;


import com.cryptowallet.crypto.config.TronGridService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    private final WebClient webClient;
    private static final String USDT_CONTRACT_ADDRESS = "TXLAQ63Xg1NAzckPwKHvzw7CSEmLMEqcdj"; // USDT TRC20 ტოკენის კონტრაქტის მისამართი

    public TransactionService(TronGridService tronGridService) {
        this.webClient = tronGridService.getWebClient();
    }

    public Mono<String> transferUSDT(String senderAddress, String receiverAddress, String privateKey, long amount) {
        // JSON მოთხოვნის ფორმირება
        String payload = String.format(
                "{ \"contract_address\": \"%s\", \"function_selector\": \"transfer(address,uint256)\", \"parameter\": \"%s%s\" }",
                USDT_CONTRACT_ADDRESS, formatAddress(receiverAddress), formatAmount(amount)
        );

        return webClient.post()
                .uri("/wallet/triggersmartcontract")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }

    // TRON მისამართის 64-ბიტიან ფორმატში გადაყვანა
    private String formatAddress(String address) {
        return "0000000000000000000000" + address.substring(2);
    }

    // USDT გადაცემული რაოდენობის 64-ბიტიან ფორმატში გადაყვანა
    private String formatAmount(long amount) {
        return String.format("%064x", amount * 1_000_000);
    }
}
