<<<<<<< HEAD
package ch.hearc.odi.koulutus.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Participant")
public class Participant {

  private Long id;
  private String firstName;
  private String lastName;
  private Date birthdate;
  private List<Course> courses;

  public Participant() {
    courses = new ArrayList<>();
  }

  public Participant(Long id, String firstName, String lastName, Date birthdate) {
    this();
    this.id = id;
=======
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
>>>>>>> dev_nel_2
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
  }

<<<<<<< HEAD
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
=======
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
>>>>>>> dev_nel_2
    this.id = id;
  }

  public String getFirstName() {
<<<<<<< HEAD
    return firstName;
=======
    return this.firstName;
>>>>>>> dev_nel_2
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
<<<<<<< HEAD
    return lastName;
=======
    return this.lastName;
>>>>>>> dev_nel_2
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

<<<<<<< HEAD
  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  @OneToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "courses")
  @OrderColumn(name = "order_courses")
  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
=======
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
>>>>>>> dev_nel_2
  }
}
