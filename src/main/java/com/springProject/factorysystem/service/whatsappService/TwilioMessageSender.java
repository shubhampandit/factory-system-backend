package com.springProject.factorysystem.service.whatsappService;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioMessageSender implements messageSender {

    @Autowired
    private TwilioConfiguration twilioConfiguration;

    @Override
    public void sendStatusMessage(String phoneNumber, String orderStatus) {

        String message = "Your order is " + orderStatus;

        MessageCreator creator = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(twilioConfiguration.getPhoneNumber()),
                message
        );
        creator.create();
    }
}
