package com.crashn.test.grpcito.client;

public class RequestData {
    String message;
    String fromId;
    String requestId;

    public RequestData(String message, String fromId, String requestId) {
        this.message = message;
        this.fromId = fromId;
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "message='" + message + '\'' +
                ", fromId='" + fromId + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
