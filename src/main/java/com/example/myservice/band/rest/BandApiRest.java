package com.example.myservice.band.rest;

import com.example.myservice.band.model.ProfileResponse;
import com.example.myservice.band.model.TokenResponse;
import com.example.myservice.config.BandOauthProperties;
import com.example.myservice.config.BandUrlsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BandApiRest {

    private RestTemplate restTemplate;

    @Autowired
    private BandUrlsProperties bandUrlsProperties;

    public BandApiRest() {
        restTemplate = new RestTemplateBuilder().setConnectTimeout(1000).setReadTimeout(3000).build();
    }

    public TokenResponse token(String code, String clientId, String clientSecret) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", String.format("Basic %s", base64EncodedSecret(clientId, clientSecret)));

        ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(bandUrlsProperties.getToken(),
                HttpMethod.GET, new HttpEntity<Object>(null, headers), TokenResponse.class, uriVariables);

        return responseEntity.getBody();
    }

    public ProfileResponse profile(String accessToken) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("access_token", accessToken);

        ResponseEntity<ProfileResponse> responseEntity = restTemplate.exchange(bandUrlsProperties.getProfile(),
                HttpMethod.GET, new HttpEntity<>(null), ProfileResponse.class, uriVariables);

        return responseEntity.getBody();
    }

    private String base64EncodedSecret(String clientId, String clientSecret) {
        try {
            String rawAuthorization = String.format("%s:%s", clientId, clientSecret);
            return Base64.getEncoder().encodeToString(rawAuthorization.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
