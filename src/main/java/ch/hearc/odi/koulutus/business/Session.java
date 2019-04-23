//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.business;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
  private Date startDateTime;
  private Date endDateTime;
  private Double price;
  private String room;

  public Session() {
  }

  public Session(Date startDateTime, Date endDateTime, Double price, String room) {
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.price = price;
    this.room = room;
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

  public Date getStartDateTime() {
    return this.startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return this.endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getRoom() {
    return this.room;
  }

  public void setRoom(String room) {
    this.room = room;
  }
}
