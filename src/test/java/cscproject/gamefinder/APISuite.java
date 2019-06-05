package cscproject.gamefinder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestGamesAPI.class,
        TestUserAPI.class
})

public class APISuite {
}