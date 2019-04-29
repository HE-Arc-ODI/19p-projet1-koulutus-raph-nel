<<<<<<< HEAD
package ch.hearc.odi.koulutus.business;

import com.fasterxml.jackson.annotation.JsonValue;
=======
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.business;

import ch.hearc.odi.koulutus.exception.ProgramException;
import java.io.Serializable;
>>>>>>> dev_nel_2
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
<<<<<<< HEAD
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Course")
public class Course {

  public enum QuarterEnum {
    NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3),
    NUMBER_4(4);
    private Integer value;

    QuarterEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
  }

  public enum StatusEnum {
    OPEN("OPEN"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED");
    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
  }

  private Long id;
  private QuarterEnum quarter;
  private Integer year;
  private Integer maxNumberOfParticipants;
  private StatusEnum status;
  private List<Session> sessions;

  public Course() {
    sessions = new ArrayList<>();
  }

  public Course(Long id) {
    this.id = id;
  }

  public Course(
      Long id,
      QuarterEnum quarter,
      Integer year,
      Integer maxNumberOfParticipants,
      StatusEnum status) {
    this();
    this.id = id;
    this.quarter = quarter;
    this.year = year;
    this.maxNumberOfParticipants = maxNumberOfParticipants;
    this.status = status;
  }

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public QuarterEnum getQuarter() {
    return quarter;
  }

  public void setQuarter(QuarterEnum quarter) {
=======
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
    name = "Course"
)
@XmlRootElement(
    name = "Course"
)
public class Course implements Serializable {
  private Integer id;
  private Integer quarter;
  private Integer year;
  private Integer maxNumberOfParticipants;
  private List<Session> sessions;

  public Course(Integer quarter, Integer year, Integer maxNumberOfParticipants, Enum status) {
    this.sessions = new ArrayList();
    status = Course.status.OPEN;
  }

  public Course(Integer quarter, Integer year, Integer maxNumberOfParticipants) {
    this.quarter = quarter;
    this.year = year;
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

  public Course(Integer id, Integer quarter, Integer year, Integer maxNumberOfParticipants) {
    this(quarter, year, maxNumberOfParticipants);
    this.id = id;
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

  @OneToMany(
      targetEntity = Session.class,
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "session"
  )
  @OrderColumn(
      name = "order_session"
  )
  public List<Session> getSessions() {
    return this.getSessions();
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  public void addSessions(Session session) throws ProgramException {
    this.sessions.add(session);
  }

  public void removeSession(Integer idSession) throws ProgramException {
    this.sessions.remove(this.getIndex(idSession));
  }

  public int getIndex(Integer id) throws ProgramException {
    for(int i = 0; i < this.sessions.size(); ++i) {
      Session session = (Session)this.sessions.get(i);
      if ((long)session.getId() == id.longValue()) {
        return i;
      }
    }

    throw new ProgramException("Index not found");
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuarter() {
    return this.quarter;
  }

  public void setQuarter(Integer quarter) {
>>>>>>> dev_nel_2
    this.quarter = quarter;
  }

  public Integer getYear() {
<<<<<<< HEAD
    return year;
=======
    return this.year;
>>>>>>> dev_nel_2
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMaxNumberOfParticipants() {
<<<<<<< HEAD
    return maxNumberOfParticipants;
=======
    return this.maxNumberOfParticipants;
>>>>>>> dev_nel_2
  }

  public void setMaxNumberOfParticipants(Integer maxNumberOfParticipants) {
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

<<<<<<< HEAD
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @OneToMany(targetEntity = Session.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "sessions")
  @OrderColumn(name = "order_sessions")
  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
=======
  static enum status {
    OPEN,
    CONFIRMED,
    CANCELLED;

    private status() {
    }
>>>>>>> dev_nel_2
  }
}
