package by.kosha.dao.logic;

import by.kosha.entity.Subtopic;

import java.util.List;

public interface SubtopicDao extends GeneralDao<Long, Subtopic> {

    List<Subtopic> getByThemeId(Integer id);
}
