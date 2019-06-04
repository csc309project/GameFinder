package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
import cscproject.gamefinder.game.GameRepository;
import cscproject.gamefinder.game.GameService;
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
public class TestGamesBasic {

    @Autowired
    private GameRepository gameRepo;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testGetGiD() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        // Dunno how to test this one
    }

    @Test
    public void testGetName() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        assertEquals(dummy.getName(), "name");
    }

    @Test
    public void testGetDescription() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        assertEquals(dummy.getDescription(), "description");
    }

    @Test
    public void testGetSteamURL() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        assertEquals(dummy.getSteamURL(), "steam_url");
    }

    @Test
    public void testGetReviews() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        assertEquals(dummy.getReviews(), "reviews");
    }

    @Test
    public void testGetPrice() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        assertEquals(dummy.getPrice(), 0.0);
    }

    // Find ID fails
    @Test
    public void testFindID() throws URISyntaxException {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
        URI uri = new URI(baseUrl);
        restTemplate.postForEntity(uri, dummy, String.class);
        Game find = gameRepo.findGameByGid(dummy.getGid());
        assertEquals(find.getName(), dummy.getName());
        assertEquals(find.getPrice(), dummy.getPrice());
        assertEquals(find.getSteamURL(), dummy.getSteamURL());
        assertEquals(find.getReviews(), dummy.getReviews());
    }

    @Test
    public void testFindName() throws URISyntaxException {
        Game dummy = new Game("name2", "description2", "steam_url2", "reviews2", 0.0);
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/game";
        URI uri = new URI(baseUrl);
        restTemplate.postForEntity(uri, dummy, String.class);
        Game find = gameRepo.findGameByName(dummy.getName());
        assertEquals(find.getName(), dummy.getName());
        assertEquals(find.getPrice(), dummy.getPrice());
        assertEquals(find.getSteamURL(), dummy.getSteamURL());
        assertEquals(find.getReviews(), dummy.getReviews());
    }

    // Everything after this fails as well
    @Test
    public void testGetRecommendation() {
        GameService gameServe = new GameService();
        Game test = gameServe.getRecommendation("Dota%202");
        assertEquals(test.getName(), "Dota 2");
        assertEquals(test.getReviews(), "Very Positive");
        assertEquals(test.getSteamURL(), "https://store.steampowered.com/app/570/Dota_2/");
        assertEquals(test.getDescription(), "Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover.");
    }

    @Test
    public void testGetAllGames() {
        GameService gameServe = new GameService();
        assertEquals(24, gameServe.getAllGames().size());
    }

    @Test
    public void testInsertGameList() {
        GameService gameServe = new GameService();
        ArrayList<Game> dummyList = new ArrayList<Game>();
        Game dummy3 = new Game("name3", "description3", "steam_url3", "reviews3", 3.0);
        Game dummy4 = new Game("name4", "description4", "steam_url4", "reviews4", 4.0);
        dummyList.add(dummy3);
        dummyList.add(dummy4);
        gameServe.insertGameList(dummyList);
        Game find3 = gameRepo.findGameByName("dummy3");
        Game find4 = gameRepo.findGameByName("dummy4");
        assertEquals(find3.getName(), dummy3.getName());
        assertEquals(find3.getPrice(), dummy3.getPrice());
        assertEquals(find3.getSteamURL(), dummy3.getSteamURL());
        assertEquals(find3.getReviews(), dummy3.getReviews());
        assertEquals(find4.getName(), dummy4.getName());
        assertEquals(find4.getPrice(), dummy4.getPrice());
        assertEquals(find4.getSteamURL(), dummy4.getSteamURL());
        assertEquals(find4.getReviews(), dummy4.getReviews());

    }
}
