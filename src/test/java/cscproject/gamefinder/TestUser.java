package cscproject.gamefinder;

import cscproject.gamefinder.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUser {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testGetUser() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user/henlo";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    public void testGetUserFail() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user/doesnotexist";
        URI uri = new URI(baseUrl);

        try {
            restTemplate.getForEntity(uri, String.class);
        }
        catch (HttpClientErrorException err) {
            assertEquals(404, err.getRawStatusCode());
        }

    }

    @Test
    public void testUserPost() throws URISyntaxException{
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI uri = new URI(baseUrl);
        User dummy = new User("user", "password");
        ResponseEntity<String> result = restTemplate.postForEntity(uri, dummy, String.class);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testUserPostAdvanced() throws URISyntaxException{
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI uri = new URI(baseUrl);
        User dummy = new User("user", "password");
        restTemplate.postForEntity(uri, dummy, String.class);
        ResponseEntity<String> result = restTemplate.getForEntity(new URI(baseUrl + "user"), String.class);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testUserPostFail() throws URISyntaxException{
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI uri = new URI(baseUrl);
        User dummy = new User("user", "password");
        User dummy2 = new User("user", "password");

        try {
            restTemplate.postForEntity(uri, dummy, String.class);
            restTemplate.postForEntity(uri, dummy2, String.class);
        }
        catch (HttpClientErrorException err) {
            assertEquals(409, err.getRawStatusCode());
        }
    }

    @Test
    public void testUserDelete() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String Url = "http://localhost:" + randomServerPort + "/api/user/";
        final String deleteUrl = "http://localhost:" + randomServerPort + "/api/user/dummy";
        URI uri = new URI(Url);
        URI deleteUri = new URI(deleteUrl);
        User dummy = new User("dummy", "password");
        restTemplate.postForEntity(uri, dummy, String.class);
        restTemplate.delete(deleteUri);

        try {
            restTemplate.getForEntity(deleteUri, String.class);
        }
        catch (HttpClientErrorException err) {
            assertEquals(404, err.getRawStatusCode());
        }
    }

    @Test
    public void testUserDeleteFail() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String deleteUrl = "http://localhost:" + randomServerPort + "/api/user/DoesNotWork";
        URI deleteUri = new URI(deleteUrl);

        try {
            restTemplate.delete(deleteUri);
        }
        catch (HttpClientErrorException err) {
            assertEquals(404, err.getRawStatusCode());
        }
    }

    @Test
    public void testUserPut() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String putUrl = "http://localhost:" + randomServerPort + "/api/user";
        URI putUri = new URI(putUrl);
        User dummy = new User("dummy", "password");
        restTemplate.put(putUri, dummy);

        try {
            final String testUrl = "http://localhost:" + randomServerPort + "/api/game/dummy";
            URI testUri = new URI(testUrl);
            restTemplate.getForEntity(testUri, String.class);
        }
        catch (HttpClientErrorException err) {
            assertEquals(404, err.getRawStatusCode());
        }
    }
}
