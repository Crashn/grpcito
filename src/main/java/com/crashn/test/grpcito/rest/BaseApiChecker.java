package com.crashn.test.grpcito.rest;

import com.crashn.test.grpcito.client.CheckAPIService;
import com.crashn.test.grpcito.client.RequestData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BaseApiChecker {
    private final CheckAPIService service;

    public BaseApiChecker(CheckAPIService apiService) {
        this.service = apiService;
    }

    @GetMapping("/base")
    public String check(@RequestParam(value = "name") String serviceName, @RequestParam(value = "message") String message) {
        RequestData data = new RequestData(message, serviceName, UUID.randomUUID().toString());
        service.check(data);
        return "done";
    }
}
