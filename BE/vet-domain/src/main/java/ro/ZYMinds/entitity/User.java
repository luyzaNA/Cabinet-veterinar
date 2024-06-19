package ro.ZYMinds.entitity;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;

  @Transient
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "email", length = 100, nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  public User() {
  }

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }


  public Long getId() {

    return id;
  }

  public String getEmail() {

    return email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = passwordEncoder.encode(password);
  }

  public boolean isTransient() {
    return version == null;
  }
}
