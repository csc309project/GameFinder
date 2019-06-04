package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGameGet {

    @Test
    public void testGetGiD() {
        Game dummy = new Game("name1", "description1", "steam_url1", "reviews1", 1.0);
        assertNotNull(dummy.getGid());
    }

    @Test
    public void testGetName() {
        Game dummy = new Game("name2", "description2", "steam_url2", "reviews2", 2.0);
        assertEquals(dummy.getName(), "name2");
    }

    @Test
    public void testGetDescription() {
        Game dummy = new Game("name3", "description3", "steam_url3", "reviews3", 3.0);
        assertEquals(dummy.getDescription(), "description3");
    }

    @Test
    public void testGetSteamURL() {
        Game dummy = new Game("name4", "description4", "steam_url4", "reviews4", 4.0);
        assertEquals(dummy.getSteamURL(), "steam_url4");
    }

    @Test
    public void testGetReviews() {
        Game dummy = new Game("name5", "description5", "steam_url5", "reviews5", 5.0);
        assertEquals(dummy.getReviews(), "reviews5");
    }

    @Test
    public void testGetPrice() {
        Game dummy = new Game("name6", "description6", "steam_url6", "reviews6", 6.0);
        assertEquals(dummy.getPrice(), 6.0);
    }
}