package cscproject.gamefinder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean newUser(User user) {
        try {
            userRepository.findByUsername(user.getUsername()).getUsername();
        }
        catch (Exception e){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public void insertUserList(List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
    }


}
