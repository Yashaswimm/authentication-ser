package com.auth.authentication.controller;

import com.auth.authentication.entity.UserCredentials;
import com.auth.authentication.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
   //testing jenkins
    @Autowired
    private UserCredentialService userCredentialService;
    //again testing jenkins
    @Autowired
    private AuthenticationManager authenticationManager;
  // 3rd time testing jenkins
    @PostMapping("/register")
    public UserCredentials register(@RequestBody UserCredentials user) {
        return userCredentialService.register(user);
    }

    @GetMapping("/token")
    public boolean validateToken(@RequestParam String token){
        return userCredentialService.verifyToken(token);
    }

    @PostMapping("/validate/user")
    public String getToken(@RequestBody UserCredentials user){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        //System.out.println("user validated: " + authentication.isAuthenticated() );
        if(authentication.isAuthenticated()){
            return userCredentialService.generateToken(user.getName());
        }
        return null;
    }
}
