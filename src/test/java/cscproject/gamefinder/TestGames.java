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
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestGames {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetGameListSuccess() throws URISyntaxException
	{
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
			assertEquals(true, err.getResponseBodyAsString().contains("Could not be found"));
		}
	}

	@Test
	public void testGamePost() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
		URI uri = new URI(baseUrl);
		Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, dummy, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

/*	@Test
	public void testGamePut() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();

		Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);

		ResponseEntity<String> result = restTemplate.put(uri, dummy);
		ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, null, id);

		assertEquals(200, result.getStatusCodeValue());
	}*/


}
