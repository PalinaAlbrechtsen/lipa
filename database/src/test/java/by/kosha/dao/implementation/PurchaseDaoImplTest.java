package by.kosha.dao.implementation;

import org.junit.Test;

public class PurchaseDaoImplTest {

    private PurchaseDaoImpl Instance = PurchaseDaoImpl.getInstance();

    @Test
    public void testFindBySubscriberId(){
        Instance.getBySubscriberId(1L);
    }

    @Test
    public void testFindByProgramId(){
        Instance.getByProgramId(1);
    }
}
