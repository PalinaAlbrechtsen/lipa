package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProgramTest extends SessionBase {

    private Program program = new Program("Blow mind", new BigDecimal("20.00"), "The best program");

    @Before
    public void clean() {
        cleanBefore("delete from Program");
    }

    @Test
    public void checkSaving() {
        checkSaving(program);
    }

    @Test
    public void checkFinding() {
        checkFinding(program);
    }
}
