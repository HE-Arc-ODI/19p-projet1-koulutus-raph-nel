//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.business;

import ch.hearc.odi.koulutus.exception.ProgramException;
import java.io.Serializable;
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
    this.quarter = quarter;
  }

  public Integer getYear() {
    return this.year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMaxNumberOfParticipants() {
    return this.maxNumberOfParticipants;
  }

  public void setMaxNumberOfParticipants(Integer maxNumberOfParticipants) {
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

  static enum status {
    OPEN,
    CONFIRMED,
    CANCELLED;

    private status() {
    }
  }
}
