package bye.kosha.dao.repository;

import bye.kosha.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findBySubscriberId(Long id);

    User findByEmail(String email);
}
