package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

public class ThemeTest extends SessionBase {

    private Theme theme = new Theme("Cardio");

    @Before
    public void clean() {
        cleanBefore("delete from Theme");
    }

    @Test
    public void saveTesting() {
        checkSaving(theme);
    }

    @Test
    public void findTesting() {
        checkFinding(theme);
    }
}
