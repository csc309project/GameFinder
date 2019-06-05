package cscproject.gamefinder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestGameService.class,
        TestUserService.class
})

public class ServiceTest {
}
