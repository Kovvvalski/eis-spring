package by.kovalski.eis.controller;

import by.kovalski.eis.model.Role;
import by.kovalski.eis.model.Status;
import by.kovalski.eis.model.User;
import by.kovalski.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/admin")
  public String showAdminMain(){
    return "admin_main";
  }

  @GetMapping("/admin/new_student")
  public String showNewStudentForm(Model model){
    model.addAttribute("student",new User());
    return "new_student";
  }

  @PostMapping("/admin/new_student")
  public String saveNewStudent(@ModelAttribute User user){
    user.setRole(Role.STUDENT);
    user.setStatus(Status.ACTIVE);
    userService.save(user);
    return "redirect:/admin";
  }

  @GetMapping("/admin/new_lecturer")
  public String showNewLecturerForm(Model model){
    model.addAttribute("lecturer", new User());
    return "new_lecturer";
  }

  @PostMapping("/admin/new_lecturer")
  public String saveNewLecturer(@ModelAttribute User user){
    user.setRole(Role.LECTURER);
    user.setStatus(Status.ACTIVE);
    userService.save(user);
    return "redirect:/admin";
  }

  @GetMapping("/admin/students")
  public String showStudents(Model model){
    model.addAttribute("students", userService.findAllByRole(Role.STUDENT));
    return "students";
  }

  @GetMapping("/admin/lecturers")
  public String showLecturers(Model model){
    model.addAttribute("lecturers", userService.findAllByRole(Role.LECTURER));
    return "lecturers";
  }

  @GetMapping("/admin/users")
  public String showUsers(Model model){
    model.addAttribute("users", userService.findAll());
    return "users";
  }
}
