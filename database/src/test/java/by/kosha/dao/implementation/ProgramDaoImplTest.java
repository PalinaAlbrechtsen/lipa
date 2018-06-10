package by.kosha.dao.implementation;

import by.kosha.entity.Program;
import org.junit.Test;

import java.math.BigDecimal;

public class ProgramDaoImplTest {

    private Program program = new Program("Fourth", "Fourth descr", new BigDecimal(11.00));

    @Test
    public void testFindingByThreeFieldsWithPagination() {
        ProgramDaoImpl.getInstance().findByThreeFields("", "",
                new BigDecimal(20.00), new BigDecimal(40.00), 1, 0);
    }

    @Test
    public void testSaving() {
        ProgramDaoImpl.getInstance().save(program);
    }

    @Test
    public void testFindingAll() {
        ProgramDaoImpl.getInstance().getAll();
    }

    @Test
    public void testFindingById() {
        ProgramDaoImpl.getInstance().getById(2);
    }

    @Test
    public void testDeleting() {
        ProgramDaoImpl.getInstance().delete(program);
    }

    @Test
    public void testUpdating() {
        ProgramDaoImpl.getInstance().save(program);
        ProgramDaoImpl.getInstance().update(program);
    }
}
