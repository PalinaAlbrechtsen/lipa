package bye.kosha.dao.repository;

import bye.kosha.dao.config.TestConfiguration;
import bye.kosha.dao.entity.Purchase;
import bye.kosha.util.DataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class PurchaseRepositoryTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private DataUtil dataUtil;

    @Before
    public void init() {
        dataUtil.cleanDatabase();
        dataUtil.prepareData();
    }

    @Test
    public void testFindingBySubscriberId() {
        List<Purchase> allBySubscriberId = purchaseRepository.findAllBySubscriberId(1L);
        assertThat(allBySubscriberId, hasSize(2));
    }

    @Test
    public void testFindingByProgramId() {
        List<Purchase> allByProgramId = purchaseRepository.findAllByProgramId(1);
        assertThat(allByProgramId, hasSize(1));
    }
}
