package bye.kosha.repository;

import bye.kosha.entity.Subtopic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtopicRepository extends CrudRepository<Subtopic, Long> {

    List<Subtopic> findAllByThemeId(Integer id);
}
