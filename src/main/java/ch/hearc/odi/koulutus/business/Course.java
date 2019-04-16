package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Course")
@XmlRootElement(name = "Course")
public class Course implements Serializable {
  private Integer id;
  private Integer quarter;
  private Integer year;
  private Integer maxNumberOfParticipants;
  private String status;
  private List<Session> sessions;

  public Course() {
  }

  public Course(Integer quarter, Integer year, Integer maxNumberOfParticipants,
      String status, List<Session> sessions) {
    this.quarter = quarter;
    this.year = year;
    this.maxNumberOfParticipants = maxNumberOfParticipants;
    this.status = status;
    this.sessions = sessions;
  }

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuarter() {
    return quarter;
  }

  public void setQuarter(Integer quarter) {
    this.quarter = quarter;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMaxNumberOfParticipants() {
    return maxNumberOfParticipants;
  }

  public void setMaxNumberOfParticipants(Integer maxNumberOfParticipants) {
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }
}
