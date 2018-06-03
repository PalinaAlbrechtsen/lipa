package bye.kosha.dao.repository;

import bye.kosha.dao.entity.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    List<Purchase> findAllBySubscriberId(Long id);

    List<Purchase> findAllByProgramId(Integer id);
}
