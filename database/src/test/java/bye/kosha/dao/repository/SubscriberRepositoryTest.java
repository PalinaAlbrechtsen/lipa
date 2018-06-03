package bye.kosha.dao.repository;

import bye.kosha.dao.config.TestConfiguration;
import bye.kosha.dao.entity.Gender;
import bye.kosha.dao.entity.Subscriber;
import bye.kosha.util.DataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class SubscriberRepositoryTest {

    @Autowired
    private DataUtil dataUtil;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Before
    public void init() {
        dataUtil.cleanDatabase();
        dataUtil.prepareData();
    }

    @Test
    public void testFindingByUserId() {
        Subscriber byUserId = subscriberRepository.findByUserId(1L);
        assertNotNull("not found", byUserId);
    }

    @Test
    public void testFindingByBirthDate() {
        List<Subscriber> allByDateOfBirth = subscriberRepository.findAllByDateOfBirth(LocalDate.now());
        assertThat(allByDateOfBirth, hasSize(0));
    }

    @Test
    public void testFindingByGender() {
        List<Subscriber> allByGender = subscriberRepository.findAllByGender(Gender.MALE);
        assertThat(allByGender, hasSize(3));
    }
}
