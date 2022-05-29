package dev.ian.controller;

import dev.ian.domain.User;
import dev.ian.exception.ResourceNotFoundException;
import dev.ian.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")//users
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//get
    @GetMapping("/list")
    public Iterable<User> list() {
        return userService.list();
    }

//
//    //gettt
//    @GetMapping("/list/{id}")
//    public ResponseEntity<User> get(@PathVariable Long id) {
//        try {
//            User user = userService.get(id);
//            return new ResponseEntity<User>(user, HttpStatus.OK);
//        } catch (ResourceNotFoundException e) {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//    }
//    //createeeeeee
//    @PostMapping("/list")
//    public void add(@RequestBody User user) {
//        userService.save(user);
//    }
//    //updateeeeeeeeeee
//    @PutMapping("/list/{id}")
//    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
//        try {
//            User existUser = userService.get(id);
//            userService.save(user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (ResourceNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    //deleteeeeeeeeeeee
//    @DeleteMapping("/list/{id}")
//    public void delete(@PathVariable Long id) {
//        userService.delete(id);
//    }
////
    //creating a get mapping that retrieves the detail of a specific user----->working
@GetMapping("/user/{id}")
private User getUser(@PathVariable("id") Long id)
{
    return userService.get(id);
}
    //creating a delete mapping that deletes a specified user---->woking
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") Long id)
    {
        userService.delete(id);
    }
    //creating post mapping that post the user---->woking in the database
    @PostMapping("/user")
    private int saveUser(@RequestBody User user)
    {
        userService.save(user);
        return Math.toIntExact(user.getId());
    }
    //creating put mapping that  updating user---->woking in the database
    @PutMapping("/user")
    private User updateUser(@RequestBody User user)
    {
        userService.save(user);
        return user;
    }
}
//    @DeleteMapping("{/users/id}")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(" the Employe being serached does not exist with id: " + id));
//
//        userRepository.delete(user);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }


//
//    //the create user REST API
//    @PostMapping
//    public User createUser@RequestBody User user) {
//        return userRepository.save(user);
//    }
//
//    //  the get employee by id REST API
//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById(@PathVariable long id) {
//        User user= user.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("user  not exist with id:" + id));
//        return ResponseEntity.ok(user);
//    }
//
//    //  the update employee REST API
//    @PutMapping("{id}")
//    public ResponseEntity<User> updateEmployee(@PathVariable long id, @RequestBody User users) {
//        User updateEmployee = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(" Employee not exist with id: " + id));
//
//
//
//        updateUser.setUsername( users.getUsername());
//        updateUser.setName( users.getName());
//        updateUser.setEmailId( users.getEmailId());
//
//        updateUser.setPhone( users.getPhone());
//        updateUser.setWebsite( users.getWebsite());
//        updateUser.setAddress( users.getAddress());
//        updateUser.setCompany( users.getCompany());
//
//        userRepository.save(updateUser);
//        return ResponseEntity.ok(updateUser);
//    }
//
//    // delete employee REST API
//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(" the Employe being serached does not exist with id: " + id));
//
//        userRepository.delete(user);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }

