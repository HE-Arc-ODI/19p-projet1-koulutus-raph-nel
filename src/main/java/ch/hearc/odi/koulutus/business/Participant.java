//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.business;

import ch.hearc.odi.koulutus.exception.ParticipantException;
import ch.hearc.odi.koulutus.exception.ProgramException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
    name = "Participant"
)
@XmlRootElement(
    name = "Participant"
)
public class Participant {
  private Integer id;
  private String firstName;
  private String lastName;
  private String birthdate;
  private List<Course> courses;

  public Participant() {
    this.courses = new ArrayList();
  }

  public Participant(String firstName, String lastName, String birthdate) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
  }

  public Participant(Integer id, String firstName, String lastName, String birthdate) {
    this(firstName, lastName, birthdate);
    this.id = id;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Id
  @GeneratedValue(
      generator = "increment"
  )
  @GenericGenerator(
      name = "increment",
      strategy = "increment"
  )
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthdate() {
    return this.birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public List<Course> courses() {
    return this.courses;
  }

  public void addCourses(Course course) throws ProgramException {
    if (!this.courses.contains(course)) {
      this.courses.add(course);
    }

  }

  public Course getCourses(Integer id) throws ParticipantException {
    Iterator var2 = this.courses.iterator();

    Course course;
    do {
      if (!var2.hasNext()) {
        throw new ParticipantException("Course not found: " + id);
      }

      course = (Course)var2.next();
    } while((long)course.getId() != id.longValue());

    return course;
  }

  public void removeFromCourse(Integer idCourse) throws ProgramException {
    this.courses.remove(this.getIndex(idCourse));
  }

  public int getIndex(Integer id) throws ProgramException {
    for(int i = 0; i < this.courses.size(); ++i) {
      Course course = (Course)this.courses.get(i);
      if ((long)course.getId() == id.longValue()) {
        return i;
      }
    }

    throw new ProgramException("Index not found");
  }
}
