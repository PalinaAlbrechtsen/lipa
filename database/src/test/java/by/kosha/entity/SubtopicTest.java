package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class SubtopicTest extends SessionBaseClass<Subtopic> {

    Subtopic subtopic = new Subtopic("Name", "Some text about");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Subtopic").executeUpdate();
            session.getTransaction().commit();
        }
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
