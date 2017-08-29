package com.example.myservice.band;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;

public class BandConnectionServiceTest {

    final static String clientId = "200602490";
    final static String redirectUri ="http://localhost:8080/login/with_band/result?t=12345&m=메시지#2273729";
    final static String authorizeUrl = "https://auth.band.us/oauth2/authorize?response_type=code&client_id={client_id}&redirect_uri={redirect_uri}";
    final static String authorizeUrl2 = "https://auth.band.us/oauth2/authorize";

    @Test
    public void testUri() {

        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("client_id", clientId);
        urlVariables.put("redirect_uri", redirectUri); // URLEncoding required

        System.out.println(UriComponentsBuilder.fromHttpUrl(authorizeUrl).build().expand(urlVariables).encode().toString());
        System.out.println(UriComponentsBuilder.fromHttpUrl(authorizeUrl).build().expand(urlVariables).toString());

        System.out.println(UriComponentsBuilder.fromHttpUrl(authorizeUrl).queryParam("client_id", clientId).queryParam("redirect_uri", redirectUri).build().encode().toString());

        System.out.println(UriComponentsBuilder.fromHttpUrl(authorizeUrl2).queryParam("client_id", clientId).queryParam("redirect_uri", redirectUri).build().encode().toString());

    }

}    