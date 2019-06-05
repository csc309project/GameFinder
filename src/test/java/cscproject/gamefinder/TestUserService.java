package cscproject.gamefinder;

import cscproject.gamefinder.user.User;
import cscproject.gamefinder.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserService {

    @Autowired
    private UserService userService;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testFindUserName() {
        User dummy = new User("name1", "password1");
        userService.insert(dummy);
        User find = userService.findUser("name1");
        assertEquals(find.getUsername(), dummy.getUsername());
        assertEquals(find.getPassword(), dummy.getPassword());
    }


    @Test
    public void testFindUserID() {
        User dummy = new User("name2", "password2");
        userService.insert(dummy);
        User find = userService.findUserId(dummy.getUserId());
        assertEquals(find.getUsername(), dummy.getUsername());
        assertEquals(find.getPassword(), dummy.getPassword());
    }

    @Test
    public void testNewUser() {
        User dummy = new User("name3", "password");
        User dummy2 = new User("name4", "new");
        userService.insert(dummy);
        assertFalse(userService.newUser(dummy));
        assertTrue(userService.newUser(dummy2));
    }

    @Test
    public void testInsertGameList() {
        List<User> dummyList = new ArrayList<>();
        User dummy3 = new User("name5", "password5");
        User dummy4 = new User("name6", "password6");
        dummyList.add(dummy3);
        dummyList.add(dummy4);
        userService.insertUserList(dummyList);
        User find3 = userService.findUser("name5");
        User find4 = userService.findUser("name6");
        assertEquals(dummy3.getUsername(), find3.getUsername());
        assertEquals(dummy3.getPassword(), find3.getPassword());
        assertEquals(dummy4.getUsername(), find4.getUsername());
        assertEquals(dummy4.getPassword(), find4.getPassword());
    }

}