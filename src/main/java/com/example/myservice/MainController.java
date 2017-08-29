package com.example.myservice;

import com.example.myservice.band.BandConnectionService;
import com.example.myservice.band.model.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    BandConnectionService bandConnectionService;

    @RequestMapping("/")
    public String indexPage(@RequestParam(value = "accessToken", required = false) String accessToken, Model model) {
        model.addAttribute("authorizeUrl", bandConnectionService.makeAuthorizeUrl());

        if(accessToken != null) {
            ProfileResponse.BandProfile profile = bandConnectionService.profile(accessToken);

            model.addAttribute("profile", profile);
            model.addAttribute("accessToken", accessToken);
        }
        return "main";
    }

    @RequestMapping("/login/with_band/result")
    public String bandLoginRedirected(@RequestParam("code") String code) {
        String accessToken = bandConnectionService.issueAccessToken(code);
        return "redirect:/?accessToken=" + accessToken;
    }
}
