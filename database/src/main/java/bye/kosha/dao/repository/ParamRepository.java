package bye.kosha.dao.repository;

import bye.kosha.dao.entity.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParamRepository extends CrudRepository<Param, Long> {

    List<Param> findAllBySubscriberId(Long id);
}
