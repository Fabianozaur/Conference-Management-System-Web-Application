package sdi.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.config.CustomAuthenticationProvider;
import sdi.cms.dto.AuthenticatedUserDto;
import sdi.cms.model.participant.User;
import sdi.cms.security.AuthRequest;
import sdi.cms.service.EmailService;
import sdi.cms.service.UserService;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private CustomAuthenticationProvider customAuthProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    private void sendRegisterConfirmationEmail(final User user) {
        final String subject = "Thank you for joining us!";

        String body = "" +
            "Hello there!\n" +
            "We really appreciate that you have chosen to use our platform. Hope you're gonna have a great time here!";

        emailService.sendMessage(user.getEmail(), subject, body);
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> signup(@RequestBody final AuthRequest authRequest) {
        try {
            final User savedUser = userService.registerUser(authRequest);
            sendRegisterConfirmationEmail(savedUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (final Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody final AuthRequest authRequest) {
        try {
            final UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
            );

            final AuthenticatedUserDto authenticatedUser = customAuthProvider.doAuthenticate(user);

            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (final BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}