package cscproject.gamefinder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/user/{username}")
    public ResponseEntity getUser (@PathVariable String username) {
        User user = userRepository.findByUsername(username);

        try {
            user.getUsername();
            return ResponseEntity.status(HttpStatus.OK).body(user.getUsername());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }

    @PostMapping("/user")
    public ResponseEntity create(@Valid @RequestBody User user) throws URISyntaxException{
        if (userService.newUser(user)) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
    }

    @PutMapping("/user")
    public ResponseEntity<User> edit(@Valid @RequestBody User user) {
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity delete(@PathVariable String username) {
        ResponseEntity response = getUser(username);

        if(response.getStatusCode() == HttpStatus.OK) {
            User temp = (User) response.getBody();
            userRepository.deleteById(temp.getUserId());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted " + username);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
