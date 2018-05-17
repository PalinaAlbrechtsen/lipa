package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

public class UserTest extends SessionBase {

    private User user = new User("email", "password");

    @Before
    public void clean() {
        cleanBefore("delete from User");
    }

    @Test
    public void savingTest() {
        checkSaving(user);
    }

    @Test
    public void findingTest() {
        checkFinding(user);
    }
}
