package cscproject.gamefinder;

import org.junit.Assert;
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
	public void testGameResponseBody() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game/DOTA%202";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGameFindFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/game/DoesNotExist";
		URI uri = new URI(baseUrl);

		try {
			restTemplate.getForEntity(uri, String.class);
			Assert.fail();
		}
		catch (HttpClientErrorException err) {
			assertEquals(404, err.getRawStatusCode());
			assertEquals(true, err.getResponseBodyAsString().contains("Could not be found"));
		}
	}


}
