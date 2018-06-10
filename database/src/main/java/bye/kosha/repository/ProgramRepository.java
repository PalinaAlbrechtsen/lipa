package bye.kosha.repository;

import bye.kosha.entity.Program;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Integer> {

    List<Program> findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndPriceBetween(String name,
                                                                                                     String description,
                                                                                                     BigDecimal minPrice,
                                                                                                     BigDecimal maxPrice,
                                                                                                     Pageable pageable);

    @Query("select max(p.price) from Program p")
    String findMaxPrice();
}
