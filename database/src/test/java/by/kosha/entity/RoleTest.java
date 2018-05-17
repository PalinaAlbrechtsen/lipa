package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

public class RoleTest extends SessionBase {

    private Role role = new Role("Admin");

    @Before
    public void clean() {
        cleanBefore("delete from Role");
    }

    @Test
    public void savingTest() {
        checkSaving(role);
    }

    @Test
    public void findingTest() {
        checkFinding(role);
    }
}
