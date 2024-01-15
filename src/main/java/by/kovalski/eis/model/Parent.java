package by.kovalski.eis.model;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "parents")
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private int telephoneNumber;

  public Parent() {
  }

  public Parent(Long id, String firstName, String lastName, String email, int telephoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.telephoneNumber = telephoneNumber;
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


  @Override
  public String toString() {
    return new StringJoiner(", ", Parent.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .add("email='" + email + "'")
            .add("telephoneNumber=" + telephoneNumber)
            .toString();
  }
}
