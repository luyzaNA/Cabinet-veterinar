package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.UserDto;
import ro.ZYMinds.entitity.User;
import ro.ZYMinds.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<Long> createUser(@Valid @RequestBody UserDto userDto) {
    Long userId = userService.saveUser(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(userId);
  }

  @GetMapping("/{email}")
  public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
    User user = userService.findUserByEmail(email);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
