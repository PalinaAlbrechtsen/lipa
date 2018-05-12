package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ParamTest extends SessionBaseClass<Param> {

    Param param = new Param(new BigDecimal(59.2));

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Param").executeUpdate();
            session.getTransaction().commit();
        }
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
