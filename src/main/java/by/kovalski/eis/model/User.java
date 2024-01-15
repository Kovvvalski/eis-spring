package by.kovalski.eis.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  @Column(unique = true)
  private String login;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
  private String email;
  private int telephoneNumber;
  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Parent parent;
  @Enumerated(EnumType.STRING)
  private Status status;

  public User() {
  }

  public User(Long id, String firstName, String lastName, String login, String password, Role role, String email,
              int telephoneNumber, Parent parent, Status status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.password = password;
    this.role = role;
    this.email = email;
    this.telephoneNumber = telephoneNumber;
    this.parent = parent;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getTelephoneNumber() {
    return telephoneNumber;
  }

  public void setTelephoneNumber(int telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  public Parent getParent() {
    return parent;
  }

  public void setParent(Parent parent) {
    this.parent = parent;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .add("login='" + login + "'")
            .add("password='" + password + "'")
            .add("role=" + role)
            .add("email='" + email + "'")
            .add("telephoneNumber=" + telephoneNumber)
            .add("parent=" + parent)
            .add("status=" + status)
            .toString();
  }
}
