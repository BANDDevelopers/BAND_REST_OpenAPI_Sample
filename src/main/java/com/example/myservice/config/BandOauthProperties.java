package com.example.myservice.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:band-oauth.properties")
@ConfigurationProperties(prefix = "band-oauth")
@Getter
@Setter
@ToString
public class BandOauthProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
