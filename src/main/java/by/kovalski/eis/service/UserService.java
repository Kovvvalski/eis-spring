package by.kovalski.eis.service;

import by.kovalski.eis.model.Role;
import by.kovalski.eis.model.User;

import java.util.List;

public interface UserService {
  boolean save(User user);

  List<User> findAll();

  List<User> findAllByName(String firstName, String lastName);

  List<User> findAllByRole(Role role);

}
