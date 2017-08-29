package com.example.myservice.band.rest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.myservice.band.model.ProfileResponse;
import com.example.myservice.band.model.TokenResponse;
import com.example.myservice.config.BandOauthProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BandApiRestTest {

    @Autowired
    private BandApiRest rest;

    @Autowired
    private BandOauthProperties oauthProperties;

    @Ignore
    @Test
    public void testToken() throws Exception {
        final String code = "ZQAAAQ4I4qyva_bw63vcV0mKFMXQSlkk2umH5nA0Dm0pqrtis2Zw013m01TOgINPYUd40HGwvk1HDj7GcNTjIa6xIbDfumJ8g5yRDmpXdOIIEM77";
        TokenResponse actual = rest.token(code, oauthProperties.getClientId(), oauthProperties.getClientSecret());

        System.out.println(actual);
    }

    @Ignore
    @Test
    public void testProfile() {
        String accessToken = "ZQAAAQFOzrceIWCSrYj1g_ondlXpHyjuOO3Jmm9u_g0PSz6A-tUZn9JQEcL1kZ3jjoJC5TCDnWn4SwVcFGjWOcTffCQlb_GbAIy0ICKRtaDI0hCB";
        ProfileResponse actual = rest.profile(accessToken);

        System.out.println(actual);
    }
}    