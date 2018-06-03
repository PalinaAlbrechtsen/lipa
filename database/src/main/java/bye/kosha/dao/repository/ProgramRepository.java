package bye.kosha.dao.repository;

import bye.kosha.dao.entity.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Integer> {

    List<Program> findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndPriceBetween(String name,
                                                                                                     String description,
                                                                                                     BigDecimal minPrice,
                                                                                                     BigDecimal maxPrice,
                                                                                                     Pageable pageable);
}
