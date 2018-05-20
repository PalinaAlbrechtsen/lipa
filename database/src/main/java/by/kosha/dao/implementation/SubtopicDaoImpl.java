package by.kosha.dao.implementation;

import by.kosha.dao.SessionBase;
import by.kosha.dao.logic.SubtopicDao;
import by.kosha.entity.QSubtopic;
import by.kosha.entity.QTheme;
import by.kosha.entity.Subtopic;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class SubtopicDaoImpl extends BaseDaoImpl<Long, Subtopic> implements SubtopicDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final SubtopicDaoImpl INSTANCE = new SubtopicDaoImpl();

    @Override
    public List<Subtopic> getByThemeId(Integer id) {
        try (Session session = FACTORY.openSession()) {
            QSubtopic subtopic = QSubtopic.subtopic;
            QTheme theme = QTheme.theme;

            return new JPAQuery<Subtopic>(session)
                    .select(subtopic)
                    .from(subtopic)
                    .join(subtopic.theme, theme)
                    .on(theme.id.eq(id))
                    .fetch();
        }
    }

    public static SubtopicDaoImpl getInstance() {
        return INSTANCE;
    }

    protected SubtopicDaoImpl() {
        super(Subtopic.class);
    }
}
