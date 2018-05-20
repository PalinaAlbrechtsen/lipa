package by.kosha.dao.implementation;

import by.kosha.entity.SessionBase;
import org.junit.Before;
import org.junit.Test;

public class SubtopicDaoImplTest extends SessionBase {

    @Before
    public void clean() {
        cleanBefore("delete from Subtopic");
    }

    @Test
    public void testFindingByThemeId(){
        SubtopicDaoImpl.getInstance().getByThemeId(1);
    }

}
