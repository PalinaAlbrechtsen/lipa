package by.kosha.dao.implementation;

import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void testGettingBySubscriberId(){
        UserDaoImpl.getInstance().getBySubscriberId(1L);
    }

    @Test
    public void testGettingByEmail(){
        UserDaoImpl.getInstance().getByEmail("abcdefgmail");
    }
}
