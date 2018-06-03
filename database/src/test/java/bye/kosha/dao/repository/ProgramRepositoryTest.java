package bye.kosha.dao.repository;

import bye.kosha.dao.config.TestConfiguration;
import bye.kosha.dao.entity.Program;
import bye.kosha.util.DataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class ProgramRepositoryTest {

    @Autowired
    private DataUtil dataUtil;

    @Autowired
    private ProgramRepository programRepository;

    @Before
    public void init() {
        dataUtil.cleanDatabase();
        dataUtil.prepareData();
    }

    @Test
    public void testFilter() {
        List<Program> allByNameContainingAndDescriptionContainingAndPriceBetween = programRepository.findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndPriceBetween("One", "one",
                new BigDecimal(20), new BigDecimal(30), PageRequest.of(0, 1));
        assertThat(allByNameContainingAndDescriptionContainingAndPriceBetween, hasSize(1));
    }
}
