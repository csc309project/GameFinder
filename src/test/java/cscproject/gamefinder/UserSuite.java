package cscproject.gamefinder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestUserAPI.class,
        TestUserService.class,
        TestUserGetSet.class
})

public class UserSuite {
}
