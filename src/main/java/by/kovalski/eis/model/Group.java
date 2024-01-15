package by.kovalski.eis.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "groups")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User lecturer;
  @ManyToMany
  @JoinTable(name = "students_groups",
          joinColumns = @JoinColumn(name = "group_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id"))
  private List<User> students;
  @Enumerated(EnumType.STRING)
  private Status status;


  public Group() {

  }

  public Group(Long id, String name, Course course, User lecturer, List<User> students, Status status) {
    this.id = id;
    this.name = name;
    this.course = course;
    this.lecturer = lecturer;
    this.students = students;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public User getLecturer() {
    return lecturer;
  }

  public void setLecturer(User lecturer) {
    this.lecturer = lecturer;
  }

  public List<User> getStudents() {
    return students;
  }

  public void setStudents(List<User> students) {
    this.students = students;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Group.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("course=" + course)
            .add("lecturer=" + lecturer)
            .add("students=" + students)
            .add("status=" + status)
            .toString();
  }
}
