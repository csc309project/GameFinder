package cscproject.gamefinder.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getUsers(ArrayList<Long> uids){
        ArrayList <User> users = new ArrayList<>();
        for(Long uid: uids) {
            User user = userRepository.findById(uid).get();
            users.add(user);
        }
        return users;
    }

    @ResponseBody
    @GetMapping("/users")
    public ResponseEntity getUser (@RequestParam String username) {
        User user = userRepository.findByName(username);

        try {
            user.getUsername();
            return ResponseEntity.status(HttpStatus.OK).body(user.getUsername());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@Valid @RequestBody User user) throws URISyntaxException{
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/edit")
    public ResponseEntity<User> edit(@Valid @RequestBody User user) {
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody User user) {
        ResponseEntity response = getUser(user.getUsername());

        if(response.getStatusCode() == HttpStatus.OK) {
            User temp = (User) response.getBody();
            userRepository.deleteById(temp.getUserId());
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
