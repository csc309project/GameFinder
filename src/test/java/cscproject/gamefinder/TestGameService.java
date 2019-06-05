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
public class TestGameService {

    @Autowired
    private GameService gameService;

    @Test
    public void testGetAllGames() {
        assertEquals(26, gameService.getAllGames().size());
    }


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

    @Test
    public void testGetRecommendation() {
        Game test = gameService.getRecommendation("Dota 2");
        assertEquals("DOTA 2", test.getName());
        assertEquals("Very Positive", test.getReviews());
        assertEquals("https://store.steampowered.com/app/570/Dota_2/", test.getSteamURL());
        assertEquals("Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover.", test.getDescription());
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
        assertEquals(dummy3.getName(), find3.getName());
        assertEquals(dummy3.getPrice(), find3.getPrice());
        assertEquals(dummy3.getSteamURL(), find3.getSteamURL());
        assertEquals(dummy3.getReviews(), find3.getReviews());
        assertEquals(dummy4.getName(), find4.getName());
        assertEquals(dummy4.getPrice(), find4.getPrice());
        assertEquals(dummy4.getSteamURL(), find4.getSteamURL());
        assertEquals(dummy4.getReviews(), find4.getReviews());

    }
}