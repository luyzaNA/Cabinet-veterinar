package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.UserDto;
import ro.ZYMinds.entitity.User;
import ro.ZYMinds.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService( UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public Long saveUser(UserDto userDto) {
    User user = new User( userDto.getName(), userDto.getEmail(), userDto.getPassword());
    userRepository.save(user);

    return user.getId();
  }

  @Transactional()
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
