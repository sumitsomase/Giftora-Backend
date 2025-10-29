package com.example.Giftora.services;



import com.example.Giftora.entities.User;
import com.example.Giftora.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){ this.userRepository=userRepository; }

    public User saveUser(User user){ return userRepository.save(user); }
    public List<User> getAllUsers(){ return userRepository.findAll(); }
    public User getByEmail(String email){ return userRepository.findByEmail(email); }
}
