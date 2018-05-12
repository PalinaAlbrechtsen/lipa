package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProgramTest extends SessionBaseClass<Program> {

    Program program = new Program("Blow mind", new BigDecimal("20.00"), "The best program");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Program").executeUpdate();
            session.getTransaction().commit();
        }
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
