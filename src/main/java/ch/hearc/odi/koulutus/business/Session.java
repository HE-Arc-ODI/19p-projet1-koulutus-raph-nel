<<<<<<< HEAD
=======
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

>>>>>>> dev_nel_2
package ch.hearc.odi.koulutus.business;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Session")
public class Session {

  private Long id;
=======
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
    name = "Session"
)
@XmlRootElement(
    name = "Session"
)
public class Session {
  private Integer id;
>>>>>>> dev_nel_2
  private Date startDateTime;
  private Date endDateTime;
  private Double price;
  private String room;

<<<<<<< HEAD
  public Session() {}

  public Session(Long id, Date startDateTime, Date endDateTime, Double price, String room) {
    this.id = id;
=======
  public Session() {
  }

  public Session(Date startDateTime, Date endDateTime, Double price, String room) {
>>>>>>> dev_nel_2
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.price = price;
    this.room = room;
  }

  @Id
<<<<<<< HEAD
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
=======
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

  public Date getStartDateTime() {
<<<<<<< HEAD
    return startDateTime;
=======
    return this.startDateTime;
>>>>>>> dev_nel_2
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
<<<<<<< HEAD
    return endDateTime;
=======
    return this.endDateTime;
>>>>>>> dev_nel_2
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public Double getPrice() {
<<<<<<< HEAD
    return price;
=======
    return this.price;
>>>>>>> dev_nel_2
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getRoom() {
<<<<<<< HEAD
    return room;
=======
    return this.room;
>>>>>>> dev_nel_2
  }

  public void setRoom(String room) {
    this.room = room;
  }
}
