package ro.ZYMinds.dto;

public class UserDto {

  private String name;
  private String password;
  private String email;

  public UserDto() {
  }

  public UserDto(String name, String password, String email) {
    this.name = name;
    this.password = password;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setUsername(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }
}
