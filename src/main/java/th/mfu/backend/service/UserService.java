package th.mfu.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.backend.model.User;
import th.mfu.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

// CRUD
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();

    }

    public User findUsersByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null); // จะคืนค่า null หากไม่พบผู้ใช้
    }

    public User updateUserByUserId(User userRequest) {
        return userRepository.findById(userRequest.getId())
                .map(existingUser -> {
                    existingUser.setFirstName(userRequest.getFirstName());
                    existingUser.setLastName(userRequest.getLastName());
                    return userRepository.save(existingUser);
                })
                .orElse(null); // หรือโยน Exception ตามที่ต้องการ
    }

    public String deleteUserByUserId(Long userId) {
        userRepository.deleteById(userId);
        return "User id:" + userId + "has been deleted";
    }
}
