package edu.project.intern.user;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return user.get();
  }

  public User register(String firstName, String lastName, String email, String password) {
    User user = User.builder()
        .firstName(firstName)
        .lastName(lastName)
        .username(email)
        .password(passwordEncoder.encode(password))
        .authorities(List.of("ROLE_STUDENT"))
        .build();
    return userRepository.save(user);
  }
}
