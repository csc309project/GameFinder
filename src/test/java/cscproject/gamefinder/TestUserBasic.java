package cscproject.gamefinder;

import cscproject.gamefinder.user.User;
import cscproject.gamefinder.user.UserRepository;
import cscproject.gamefinder.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserBasic {
    @Autowired
    private UserService userService;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testGetID() {
        User dummy = new User("name", "password");
        assertNotNull(dummy.getUserId());
    }

    @Test
    public void testGetName() {
        User dummy = new User("name", "password");
        assertEquals(dummy.getUsername(), "name");
    }

    @Test
    public void testGetPassword() {
        User dummy = new User("name", "password");
        assertEquals(dummy.getPassword(), "password");
    }

    @Test
    public void testSetPassword() {
        User dummy = new User("name", "password");
        dummy.setPassword("password2");
        assertEquals(dummy.getPassword(), "password2");
    }

    @Test
    public void testFindUserName() {
        User dummy = new User("name", "password");
        userService.insert(dummy);
        User find = userService.findUser("name");
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
        User dummy = new User("name3", "password3");
        User dummy2 = new User("name4", "password4");
        assertTrue(userService.newUser(dummy));
        assertFalse(userService.newUser(dummy2));
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
