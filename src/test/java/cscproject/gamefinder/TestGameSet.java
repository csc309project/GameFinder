package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGameSet {

    Game dummy = new Game("name1", "description1", "steam_url1", "reviews1", 1.0);

    @Test
    public void testSetGiD() {
        dummy.setGid(1);
        assertEquals(1, dummy.getGid());
    }

    @Test
    public void testSetName() {
        dummy.setName("name2");
        assertEquals("name2", dummy.getName());
    }

    @Test
    public void testSetDescription() {
        dummy.setDescription("description2");
        assertEquals("description2", dummy.getDescription());
    }

    @Test
    public void testSetSteamURL() {
        dummy.setSteamURL("steam_url2");
        assertEquals("steam_url2", dummy.getSteamURL());
    }

    @Test
    public void testSetReviews() {
        dummy.setReviews("review2");
        assertEquals("review2", dummy.getReviews());
    }

    @Test
    public void testSetPrice() {
        dummy.setPrice(2.0);
        assertEquals(2.0, dummy.getPrice());
    }

}