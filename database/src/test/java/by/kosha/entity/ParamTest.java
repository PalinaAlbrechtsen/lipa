package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ParamTest extends SessionBase {

    private Param param = new Param(new BigDecimal(59.2));

    @Before
    public void clean() {
        cleanBefore("delete from Param");
    }

    @Test
    public void savingTest() {
        checkSaving(param);
    }

    @Test
    public void findingTest() {
        checkFinding(param);
    }
}
