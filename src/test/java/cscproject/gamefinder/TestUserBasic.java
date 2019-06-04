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

import org.springframework.web.client.RestTemplate;
import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserBasic {
    @Autowired
    private UserRepository userRepo;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testGetID() {
        User dummy = new User("name", "password");
        // Dunno how to test this one
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
    public void testFindUserName() throws URISyntaxException {
        User dummy = new User("name", "password");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI uri = new URI(baseUrl);
        restTemplate.postForEntity(uri, dummy, String.class);
        User find = userRepo.findUserByUsername("name");
        assertEquals(find.getUsername(), dummy.getUsername());
        assertEquals(find.getPassword(), dummy.getPassword());
    }

    // Test after this fail

    @Test
    public void testFindUserID() throws URISyntaxException {
        User dummy = new User("name2", "password2");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI uri = new URI(baseUrl);
        restTemplate.postForEntity(uri, dummy, String.class);
        User find = userRepo.findUserByUserId(dummy.getUserId());
        assertEquals(find.getUsername(), dummy.getUsername());
        assertEquals(find.getPassword(), dummy.getPassword());
    }

    @Test
    public void testNewUser() throws URISyntaxException {
        UserService userServe = new UserService();
        User dummy = new User("name3", "password3");
        User dummy2 = new User("name4", "password4");
        assertTrue(userServe.newUser(dummy));
        assertFalse(userServe.newUser(dummy2));
    }

    @Test
    public void testInsertGameList() {
        UserService userServe = new UserService();
        ArrayList<User> dummyList = new ArrayList<User>();
        User dummy3 = new User("name5", "password5");
        User dummy4 = new User("name6", "password6");
        dummyList.add(dummy3);
        dummyList.add(dummy4);
        userServe.insertUserList(dummyList);
        User find3 = userRepo.findUserByUsername("dummy3");
        User find4 = userRepo.findUserByUsername("dummy4");
        assertEquals(dummy3.getUsername(), find3.getUsername());
        assertEquals(dummy3.getPassword(), find3.getPassword());
        assertEquals(dummy4.getUsername(), find4.getUsername());
        assertEquals(dummy4.getPassword(), find4.getPassword());
    }


}
