package com.reyansh.shop.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyansh.shop.model.Gender;
import com.reyansh.shop.model.User;
import com.reyansh.shop.repository.UserRepository;

@RestController
@RequestMapping(value = "/")
public class Signup {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Signup(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    private User convertRequestToUser(SignupRequest request) throws Exception {
        final User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        switch (request.getGender().toLowerCase()) {
        case "male":
            user.setGender(Gender.MALE);
            break;

        case "female":
            user.setGender(Gender.FEMALE);
            break;

        default:
            throw new Exception("Gender unknown");
        }

        return user;
    }

    private void saveUser(User user) throws Exception {
        if (this.userRepository.existsById(user.getEmail())) {
            throw new Exception("User already exists");
        }

        this.userRepository.save(user);
    }

    @PostMapping("signup")
    public SignupResponse signUp(@RequestBody SignupRequest request) {
        final SignupResponse response = new SignupResponse();
        try {
            final User user = this.convertRequestToUser(request);
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            this.saveUser(user);
        } catch (final Exception exception) {
            response.setSuccess(false);
            return response;
        }

        response.setSuccess(true);
        return response;
    }

}