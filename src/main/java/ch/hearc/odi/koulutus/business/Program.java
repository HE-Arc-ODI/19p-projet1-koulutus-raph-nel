package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
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
    this();
    this.name = name;
    this.richDescription = richDescription;
    this.field = field;
    this.price = price;
  }

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
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRichDescription() {
    return this.richDescription;
  }

  public void setRichDescription(String richDescription) {
    this.richDescription = richDescription;
  }

  public String getField() {
    return this.field;
  }

  public void setField(String field) {
    this.field = field;
  }

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
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

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

