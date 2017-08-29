package com.example.myservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:band-urls.properties")
@ConfigurationProperties("band-urls")
@Getter
@Setter
public class BandUrlsProperties {
    private String authorize;
    private String token;
    private String profile;
    private String myBands;
}

