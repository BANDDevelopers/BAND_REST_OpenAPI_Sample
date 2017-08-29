package com.example.myservice.band;

import com.example.myservice.band.model.ProfileResponse;
import com.example.myservice.band.model.TokenResponse;
import com.example.myservice.band.rest.BandApiRest;
import com.example.myservice.config.BandOauthProperties;
import com.example.myservice.config.BandUrlsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class BandConnectionService {

    @Autowired
    private BandApiRest bandApiRest;

    @Autowired
    private BandOauthProperties bandOauthProperties;

    @Autowired
    private BandUrlsProperties bandUrlsProperties;

    public String makeAuthorizeUrl() {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("client_id", bandOauthProperties.getClientId());
        urlVariables.put("redirect_uri", bandOauthProperties.getRedirectUri()); // URLEncoding required ('=', '+', '&', '#', ... not permitted)

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(bandUrlsProperties.getAuthorize()).build().expand(urlVariables).encode();
        return uri.toString();
    }

    public String issueAccessToken(String code) {
        TokenResponse tokenResponse = bandApiRest.token(code, bandOauthProperties.getClientId(), bandOauthProperties.getClientSecret());
        return tokenResponse.getAccessToken();
    }

    public ProfileResponse.BandProfile profile(String accessToken) {
        ProfileResponse response = bandApiRest.profile(accessToken);
        return response.getProfile();
    }

}
