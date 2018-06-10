package bye.kosha.repository;

import bye.kosha.config.TestConfiguration;
import bye.kosha.entity.Program;
import bye.kosha.util.DataUtil;
import com.google.common.collect.Lists;
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

    @Test
    public void testgetAll(){
        Iterable<Program> all = programRepository.findAll();
        assertThat(Lists.newArrayList(all), hasSize(2));
    }
}
