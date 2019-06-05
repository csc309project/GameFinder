package cscproject.gamefinder;

import cscproject.gamefinder.user.User;
import cscproject.gamefinder.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserGetSet {

    @Autowired
    private UserService userService;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testGetID() {
        User dummy = new User("name1", "password1");
        assertNotNull(dummy.getUserId());
    }

    @Test
    public void testGetName() {
        User dummy = new User("name2", "password2");
        assertEquals("name2", dummy.getUsername());
    }

    @Test
    public void testGetPassword() {
        User dummy = new User("name3", "password3");
        assertEquals("password3", dummy.getPassword());
    }

    @Test
    public void testSetPassword() {
        User dummy = new User("name4", "password4");
        dummy.setPassword("password5");
        assertEquals("password5", dummy.getPassword());
    }

}