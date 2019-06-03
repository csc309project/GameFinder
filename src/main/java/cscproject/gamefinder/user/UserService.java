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
            System.out.println(userRepository.findAll());
            userRepository.findUserByUsername(user.getUsername()).getUsername();
        }
        catch (Exception e){
            // We know the user isn't in the database now
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void insertUserList(List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
    }


}
