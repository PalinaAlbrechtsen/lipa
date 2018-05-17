package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

public class SubtopicTest extends SessionBase {

    private Subtopic subtopic = new Subtopic("Name", "Some text about");

    @Before
    public void clean() {
        cleanBefore("delete from Subtopic");
    }

    @Test
    public void checkSaving() {
        checkSaving(subtopic);
    }

    @Test
    public void checkFinding() {
        checkFinding(subtopic);
    }
}
