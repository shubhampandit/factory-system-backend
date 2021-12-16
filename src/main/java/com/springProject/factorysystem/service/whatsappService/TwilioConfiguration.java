package com.springProject.factorysystem.service.whatsappService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("twillo")
public class TwilioConfiguration {
    private String accountSid;
    private String authToken;
    private String phoneNumber;
}
