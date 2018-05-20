package by.kosha.dao.implementation;

import by.kosha.entity.Gender;
import org.junit.Test;

public class SubscriberDaoImplTest {

    private SubscriberDaoImpl Instance = SubscriberDaoImpl.getInstance();

    @Test
    public void testFindingByUserId() {
        Instance.getByUserId(1L);
    }

    @Test
    public void testFindingByBirthDate() {
        Instance.getByBirthDate();
    }

    @Test
    public void testFindingByGender() {
        Instance.getByGender(Gender.MALE);
    }
}
