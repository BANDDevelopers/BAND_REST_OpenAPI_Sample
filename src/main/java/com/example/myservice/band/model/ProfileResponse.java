package com.example.myservice.band.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProfileResponse {
    @JsonProperty("result_code")
    private int resultCode;

    @JsonProperty("result_data")
    private BandProfile profile;

    @Data
    public static class BandProfile {
        @JsonProperty("user_key")
        private String userKey;

        @JsonProperty("profile_image_url")
        private String profileImageUrl;

        @JsonProperty("name")
        private String name;

        @JsonProperty("is_app_member")
        private boolean appMember;

        @JsonProperty("message_allowed")
        private boolean messageAllowed;
    }
}
