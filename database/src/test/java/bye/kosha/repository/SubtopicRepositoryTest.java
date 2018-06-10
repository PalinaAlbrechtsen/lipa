package bye.kosha.repository;

import bye.kosha.config.TestConfiguration;
import bye.kosha.entity.Subtopic;
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
public class SubtopicRepositoryTest {

    @Autowired
    private SubtopicRepository subtopicRepository;

    @Autowired
    private DataUtil dataUtil;

    @Before
    public void init() {
        dataUtil.cleanDatabase();
        dataUtil.prepareData();
    }

    @Test
    public void testFindingByThemeId() {
        List<Subtopic> allByThemeId = subtopicRepository.findAllByThemeId(1);
        assertThat(allByThemeId, hasSize(2));
    }
}
