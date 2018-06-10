package bye.kosha.repository;

import bye.kosha.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findBySubscriberId(Long id);

    User findByEmail(String email);
}
