package bye.kosha.dao.repository;

import bye.kosha.dao.entity.Gender;
import bye.kosha.dao.entity.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

    Subscriber findByUserId(Long id);

    List<Subscriber> findAllByGender(Gender gender);

    List<Subscriber> findAllByDateOfBirth(LocalDate date);
}
