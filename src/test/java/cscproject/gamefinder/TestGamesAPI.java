package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
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
public class TestGamesAPI {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetGameListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGameGet() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game/DOTA%202";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGameGetFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game/DoesNotExist";
		URI uri = new URI(baseUrl);

		try {
			restTemplate.getForEntity(uri, String.class);
		}
		catch (HttpClientErrorException err) {
			assertEquals(404, err.getRawStatusCode());
		}
	}

	@Test
	public void testGamePost() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
		URI uri = new URI(baseUrl);
		Game dummy = new Game("testGame", "description", "steam_url", "Mixed", 0.0);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, dummy, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGameDelete() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String deleteUrl = "http://localhost:" + randomServerPort + "/api/game/DOTA%202";
		URI deleteUri = new URI(deleteUrl);
		restTemplate.delete(deleteUri);

		try {
			restTemplate.getForEntity(deleteUri, String.class);
		}
		catch (HttpClientErrorException err) {
			assertEquals(404, err.getRawStatusCode());
		}
	}

	@Test
	public void testGameDeleteFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String deleteUrl = "http://localhost:" + randomServerPort + "/api/game/DoesNotWork";
		URI deleteUri = new URI(deleteUrl);

		try {
			restTemplate.delete(deleteUri);
		}
		catch (HttpClientErrorException err) {
			assertEquals(404, err.getRawStatusCode());
		}
	}

	@Test
	public void testGamePut() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:" + randomServerPort + "/api/game";
		URI uri = new URI(url);
		Game dummy = new Game("testGame2", "new description", "steam_url", "Positive", 0.0);
		restTemplate.postForEntity(uri, dummy, String.class);
		URI testUri = new URI("http://localhost:" + randomServerPort + "/api/game/testGame2");
		dummy = new Game("testGame2", "new description", "steam_url", "Negative", 9.99);
		restTemplate.put(testUri, dummy);
		ResponseEntity<String> result = restTemplate.getForEntity(testUri, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGamePutFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String putUrl = "http://localhost:" + randomServerPort + "/api/game/noGame";
		URI putUri = new URI(putUrl);
		Game dummy = new Game("noGame", "description", "steam_url", "Negative", 0.0);
		try {
			restTemplate.put(putUri, dummy);
		}
		catch (HttpClientErrorException err) {
			assertEquals(404, err.getRawStatusCode());
		}
	}

}
