package com.crashn.test.grpcito.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CheckAPIService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckAPIService.class);

    String path = "stub";

    public void check(RequestData data) {
        LOGGER.info("Service invoked with data {}", data);
    }

}
