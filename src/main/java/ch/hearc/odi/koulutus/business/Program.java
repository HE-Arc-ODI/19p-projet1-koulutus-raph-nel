package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Program")
@XmlRootElement(name = "Program")
public class Program implements Serializable {

  private Long id;
  private String name;
  private String richDescription;
  private String field;
  private BigDecimal price;
  private List<Course> courses;

  public Program() {
    courses = new ArrayList<>();
  }

  public Program(String name, String richDescription, String field, BigDecimal price) {
=======
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import ch.hearc.odi.koulutus.exception.ProgramException;

@Entity
@Table(
    name = "Program"
)
@XmlRootElement(
    name = "Program"
)
public class Program implements Serializable {
  private Integer id;
  private String name;
  private String richDescription;
  private String field;
  private Integer price;
  private List<Course> courses;

  public Program() {
    this.courses = new ArrayList();
  }

  public Program(String name, String richDescription, String field, Integer price) {
>>>>>>> dev_nel_2
    this();
    this.name = name;
    this.richDescription = richDescription;
    this.field = field;
    this.price = price;
  }

<<<<<<< HEAD
  public Program(Long id, String name, String richDescription, String field, BigDecimal price) {
    this();
    this.id = id;
    this.name = name;
    this.richDescription = richDescription;
    this.field = field;
    this.price = price;
  }

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
=======
  public Program(Integer id, String name, String richDescription, String field, Integer price) {
    this(name, richDescription, field, price);
    this.id = id;
  }

  public Program(Program p, Course c) {
    this.id = p.getId();
    this.name = p.getName();
    this.richDescription = p.getRichDescription();
    this.field = p.getField();
    this.price = p.getPrice();
    this.courses = new ArrayList();
    this.courses.add(c);
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

  public String getName() {
<<<<<<< HEAD
    return name;
=======
    return this.name;
>>>>>>> dev_nel_2
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRichDescription() {
<<<<<<< HEAD
    return richDescription;
=======
    return this.richDescription;
>>>>>>> dev_nel_2
  }

  public void setRichDescription(String richDescription) {
    this.richDescription = richDescription;
  }

  public String getField() {
<<<<<<< HEAD
    return field;
=======
    return this.field;
>>>>>>> dev_nel_2
  }

  public void setField(String field) {
    this.field = field;
  }

<<<<<<< HEAD
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @OneToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "courses")
  @OrderColumn(name = "order_courses")
  public List<Course> getCourses() {
    return courses;
=======
  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @XmlElement
  @Transient
  public List<Course> getCourses() {
    return this.courses;
>>>>>>> dev_nel_2
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

<<<<<<< HEAD
  public void addCourse(Course newCourse) {
    this.courses.add(newCourse);
  }

  public Course getCourseById(Long courseId) {
    return courses.get(findIndex(courseId));
  }

  private int findIndex(Long courseId) {
    int index = 0;
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId().equals(courseId)) {
        index = i;
      }
    }
    return index;
  }

  public void deleteCourseById(Long courseId) {
    courses.remove(findIndex(courseId));
  }
}
=======
  public void addCourse(Course course) {
    this.courses.add(course);
  }

  public void update(Program newProgram) {
    this.setCourses(newProgram.getCourses());
    this.setField(newProgram.getField());
    this.setName(newProgram.getName());
    this.setPrice(newProgram.getPrice());
    this.setRichDescription(newProgram.getRichDescription());
  }

  public Integer getIndex(Integer id) throws ProgramException {
    for(int i = 0; i < this.courses.size(); ++i) {
      /* Course c = (Course)this.courses.get(i);
       if (c.getId() == id) {
        return i;
      } */
    }

    throw new ProgramException("Index not found");
  }

  public void removeCourse(Integer id) throws ProgramException {
    this.courses.remove(this.getIndex(id));
  }
}

>>>>>>> dev_nel_2
