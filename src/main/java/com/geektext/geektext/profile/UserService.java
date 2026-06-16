package com.geektext.geektext.profile;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (userRepository.existsById(user.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }

        // TODO: hash password before final submission
        userRepository.save(user);
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }
}
