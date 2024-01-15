package by.kovalski.eis.model;


import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "hometasks")
public class HomeTask {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String task;

  public HomeTask() {
  }

  public HomeTask(Long id, String task) {
    this.id = id;
    this.task = task;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", HomeTask.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("task='" + task + "'")
            .toString();
  }
}
