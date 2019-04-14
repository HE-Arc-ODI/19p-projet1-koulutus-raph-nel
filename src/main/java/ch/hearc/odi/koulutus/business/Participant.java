package ch.hearc.odi.koulutus.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="Participant")
@xmlRootElement(name = "Category")
public class Participant {
  private Integer id;
  private String firstName;
  private String LastName;
  private Date birthdate;
  private List<Course> courses;

  public Participant(){courses = new ArrayList<>(); }

  public Participant(String firstName, String lastName, Date birthdate) {
    this();
    this.firstName = firstName;
    this.LastName = lastName;
    this.birthdate = birthdate;
  }

  public Participant(Integer id, String firstName, String lastName, Date birthdate) {
    this.id = id;
    this.firstName = firstName;
    LastName = lastName;
    this.birthdate = birthdate;
  }
}

