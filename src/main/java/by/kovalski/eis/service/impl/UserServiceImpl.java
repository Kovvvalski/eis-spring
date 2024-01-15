package by.kovalski.eis.service.impl;

import by.kovalski.eis.model.Role;
import by.kovalski.eis.model.User;
import by.kovalski.eis.repository.UserRepository;
import by.kovalski.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean save(User user) {
    if (userRepository.findUserByLogin(user.getLogin()) == null) {
      userRepository.save(user);
      return true;
    }
    return false;
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public List<User> findAllByName(String firstName, String lastName) {
    return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  public List<User> findAllByRole(Role role) {
    return userRepository.findAllByRole(role);
  }
}
