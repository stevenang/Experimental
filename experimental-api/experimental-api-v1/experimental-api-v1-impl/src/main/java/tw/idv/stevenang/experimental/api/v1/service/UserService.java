package tw.idv.stevenang.experimental.api.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.stevenang.experimental.api.v1.entity.User;
import tw.idv.stevenang.experimental.api.v1.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserId(String userId) {
        return userRepository.finUserByUserId(userId);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
