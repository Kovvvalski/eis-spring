package by.kovalski.eis.repository;

import by.kovalski.eis.model.Role;
import by.kovalski.eis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findUserByFirstNameAndLastName(String firstName, String lastName);

  User findUserByLogin(String login);

  List<User> findAllByFirstNameAndLastName(String firstName, String lastName);

  List<User> findAllByRole(Role role);
}
