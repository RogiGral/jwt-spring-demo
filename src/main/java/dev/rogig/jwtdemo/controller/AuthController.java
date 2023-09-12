package dev.rogig.jwtdemo.controller;

import dev.rogig.jwtdemo.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController<logger> {

    private final TokenService tokenService;
    private final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("authentication: {}", authentication.getName());
        String token = this.tokenService.generateToken(authentication);
        LOG.debug("token granted: {}", token);
        return token;
    }
}
