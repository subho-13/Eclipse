package com.reyansh.shop.controller.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyansh.shop.util.JwtUtil;

@RestController
@RequestMapping(value = "/")
public class Signin {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "signin")
    public SigninResponse signIn(@RequestBody SigninRequest request) {
        final SigninResponse signinResponse = new SigninResponse();
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()));
        } catch (final BadCredentialsException exception) {
            signinResponse.setSuccess(false);
            return signinResponse;
        }

        final UserDetails userDetails = this.userDetailsService
                        .loadUserByUsername(request.getEmail());

        final String token = this.jwtUtil.generateToken(userDetails.getUsername());

        signinResponse.setSuccess(true);
        signinResponse.setToken(token);

        return signinResponse;

    }
}
