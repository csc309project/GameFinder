package cscproject.gamefinder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestGameGet.class,
        TestGameSet.class,
        TestGameService.class,
        TestGamesAPI.class
})

public class GameTest {
}