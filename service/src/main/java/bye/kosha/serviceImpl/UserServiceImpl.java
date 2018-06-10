package bye.kosha.serviceImpl;

import bye.kosha.converter.UserDetailConverter;
import bye.kosha.repository.UserRepository;
import bye.kosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailConverter userDetailConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailConverter userDetailConverter) {
        this.userRepository = userRepository;
        this.userDetailConverter = userDetailConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return Optional.of(email)
                .map(userRepository::findByEmail)
                .map(userDetailConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
    }
}
