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

