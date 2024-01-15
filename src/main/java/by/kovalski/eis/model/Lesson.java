package by.kovalski.eis.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "lessons")
public class Lesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private LocalDateTime begin;
  private LocalDateTime end;
  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
  @ManyToOne
  @JoinColumn(name = "home_task_id")
  private HomeTask homeTask;

  public Lesson() {
  }

  public Lesson(long id, String name, LocalDateTime begin, LocalDateTime end, Group group, HomeTask homeTask) {
    this.id = id;
    this.name = name;
    this.begin = begin;
    this.end = end;
    this.group = group;
    this.homeTask = homeTask;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getBegin() {
    return begin;
  }

  public void setBegin(LocalDateTime begin) {
    this.begin = begin;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public void setEnd(LocalDateTime end) {
    this.end = end;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public HomeTask getHomeTask() {
    return homeTask;
  }

  public void setHomeTask(HomeTask homeTask) {
    this.homeTask = homeTask;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Lesson.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("begin=" + begin)
            .add("end=" + end)
            .add("group=" + group)
            .add("homeTask=" + homeTask)
            .toString();
  }
}
