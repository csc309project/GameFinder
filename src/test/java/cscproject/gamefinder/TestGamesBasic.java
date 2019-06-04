package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
import cscproject.gamefinder.game.GameService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGamesBasic {

    @Autowired
    private GameService gameService;

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

    @Test
    public void testGetAllGames() {
        assertEquals(26, gameService.getAllGames().size());
    }

    // Find ID fails
    @Test
    public void testFindID() {
        Game dummy = new Game("name", "description", "steam_url", "reviews", 0.0);
        gameService.insert(dummy);
        Game find = gameService.gameById(dummy.getGid());
        assertEquals(find.getName(), dummy.getName());
        assertEquals(find.getPrice(), dummy.getPrice());
        assertEquals(find.getSteamURL(), dummy.getSteamURL());
        assertEquals(find.getReviews(), dummy.getReviews());
    }

    @Test
    public void testFindByName() {
        Game dummy = new Game("name2", "description2", "steam_url2", "reviews2", 0.0);
        gameService.insert(dummy);
        Game find = gameService.gameByName(dummy.getName());
        assertEquals(find.getName(), dummy.getName());
        assertEquals(find.getPrice(), dummy.getPrice());
        assertEquals(find.getSteamURL(), dummy.getSteamURL());
        assertEquals(find.getReviews(), dummy.getReviews());
    }

    // Everything after this fails as well
    @Test
    public void testGetRecommendation() {
        Game test = gameService.getRecommendation("Dota%202");
        assertNotSame(test.getName(), "Dota 2");
        assertNotSame(test.getReviews(), "Very Positive");
        assertNotSame(test.getSteamURL(), "https://store.steampowered.com/app/570/Dota_2/");
        assertNotSame(test.getDescription(), "Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover.");
    }

    @Test
    public void testInsertGameList() {
        ArrayList<Game> dummyList = new ArrayList<>();
        Game dummy3 = new Game("name3", "description3", "steam_url3", "reviews3", 3.0);
        Game dummy4 = new Game("name4", "description4", "steam_url4", "reviews4", 4.0);
        dummyList.add(dummy3);
        dummyList.add(dummy4);
        gameService.insertGameList(dummyList);
        Game find3 = gameService.gameByName("name3");
        Game find4 = gameService.gameByName("name4");
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
