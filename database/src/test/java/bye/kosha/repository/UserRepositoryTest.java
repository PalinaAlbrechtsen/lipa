package bye.kosha.repository;

import bye.kosha.config.TestConfiguration;
import bye.kosha.entity.User;
import bye.kosha.util.DataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private DataUtil dataUtil;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        dataUtil.cleanDatabase();
        dataUtil.prepareData();
    }

    @Test
    public void testFindingBySubId() {
        User bySubscriberId = userRepository.findBySubscriberId(1L);
        assertNotNull("not found", bySubscriberId);
    }

    @Test
    public void testFindingByEmail() {
        User byEmail = userRepository.findByEmail("phil@mail");
        assertNotNull("not found with this email", byEmail);
    }
}
