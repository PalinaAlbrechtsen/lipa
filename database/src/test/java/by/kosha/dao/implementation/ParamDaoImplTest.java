package by.kosha.dao.implementation;

import org.junit.Test;

public class ParamDaoImplTest {

    @Test
    public void testGettingBySubscriberId(){
        ParamDaoImpl.getInstance().getBySibscriberId(1L);
    }
}
