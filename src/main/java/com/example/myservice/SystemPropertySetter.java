package com.example.myservice;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SystemPropertySetter {
    @PostConstruct
    public void setProperty() {
        System.setProperty("jsse.enableSNIExtension", "false"); // To avoid javax.net.ssl.SSLProtocolException
    }
}
