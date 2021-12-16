package com.springProject.factorysystem.service.whatsappService;

public interface messageSender {
    void sendStatusMessage(String phoneNumber, String orderStatus);
}
