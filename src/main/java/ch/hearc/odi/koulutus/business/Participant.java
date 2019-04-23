package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "Participant")
@XmlRootElement(name = "Participant")
public class Participant implements Serializable {

  private Integer id;
  private String firstName;
  private String LastName;
  private Date birthdate;
  private List<Course> courses;

  public Participant() {
    courses = new ArrayList<>();
  }

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

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

 /* @ManyToAny(targetEntity = Course.class, fetch = FetchType.EAGER, mappedBy = "courses")
  public List<Course> getCours(){return courses};
*/
}

