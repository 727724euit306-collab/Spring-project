package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> opt = userRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            User existing = opt.get();
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            existing.setRole(user.getRole());
            existing.setPhoneNumber(user.getPhoneNumber());
            existing.setDepartment(user.getDepartment());
            return userRepository.save(existing);
        }
        return null;
    }
}
