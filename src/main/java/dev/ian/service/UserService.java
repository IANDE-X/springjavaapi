package dev.ian.service;

import dev.ian.domain.User;
import dev.ian.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        userRepository.saveAll(users);
    }



    public List<User> listAll() {return (List<User>) userRepository.findAll();}


    public User get(Long id) {return userRepository.findById(id).get();}

    public void delete(Long id) {userRepository.deleteById(id);}
}
