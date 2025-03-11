package com.cryptowallet.crypto.controller;

import com.cryptowallet.crypto.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public String transferUSDT(@RequestBody Map<String, String> request) {
        return transactionService.transferUSDT(
                request.get("senderAddress"),
                request.get("receiverAddress"),
                request.get("privateKey"),
                Long.parseLong(request.get("amount"))
        ).block();
    }
}
