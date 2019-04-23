//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.services;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.exception.ParticipantException;
import ch.hearc.odi.koulutus.exception.ProgramException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PersistenceService {
  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");

  public PersistenceService() {
  }

  public ArrayList<Program> getPrograms() {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Program> programs = entityManager.createQuery("from Program", Program.class).getResultList();
    return (ArrayList)programs;
  }

  public Program getProgramById(Integer programId) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = (Program)entityManager.find(Program.class, programId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  public Program createAndPersistProgram(String name, String richDescription, String field, Integer price) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = new Program(name, richDescription, field, price);
    entityManager.persist(program);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  public void deleteProgram(Integer programId) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = (Program)entityManager.find(Program.class, programId);
    if (program == null) {
      throw new ProgramException("Program with id " + programId + " not found");
    } else {
      entityManager.remove(program);
      entityManager.getTransaction().commit();
      entityManager.close();
    }
  }

  public Program updateProgram(Integer programId, Program newProgram) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = (Program)entityManager.find(Program.class, programId);
    if (program == null) {
      throw new ProgramException("Program with id " + programId + " not found");
    } else {
      program.update(newProgram);
      entityManager.getTransaction().commit();
      return program;
    }
  }

  public ArrayList<Course> getCoursesByProgramId(Integer programId) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    TypedQuery<Course> query = entityManager.createQuery("SELECT c from Course c where c.program.id = :programId", Course.class);
    List<Course> courses = query.setParameter("programId", programId).getResultList();
    if (courses == null) {
      throw new ProgramException("Program " + programId + " was not found");
    } else {
      entityManager.getTransaction().commit();
      entityManager.close();
      return (ArrayList)courses;
    }
  }

  public Course getCourseByIdProgramId(Integer programId, Integer courseId) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    TypedQuery<Course> query = entityManager.createQuery("SELECT c from Course c where c.program.id = :programId and c.id = :courseId", Course.class);
    Course courses = (Course)query.setParameter("programId", programId).setParameter("programId", courseId).getSingleResult();
    if (courses == null) {
      throw new ProgramException("Program or course not found");
    } else {
      entityManager.getTransaction().commit();
      entityManager.close();
      return courses;
    }
  }

  public Course createAndPersistCourse(Integer programId, Integer quarter, Integer year, Integer maxNumberOfParticipants) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course courses = new Course(quarter, year, maxNumberOfParticipants);
    Program program = this.getProgramById(programId);
    if (program != null) {
      program.addCourse(courses);
      entityManager.persist(courses);
      entityManager.getTransaction().commit();
      entityManager.close();
      return courses;
    } else {
      throw new ProgramException("Program " + programId + " was not found");
    }
  }

  public ArrayList<Participant> getParticipant() {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Participant> participant = entityManager.createQuery("from Participant", Participant.class).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return (ArrayList)participant;
  }

  public Participant createAndPersistParticipant(String firstName, String lastName, String birthdate) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = new Participant(firstName, lastName, birthdate);
    entityManager.persist(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }

  public Participant getParticipantByID(Integer participantid) throws ParticipantException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    Participant actualParticipant = (Participant)entityManager.find(Participant.class, participantid);
    if (actualParticipant != null) {
      return actualParticipant;
    } else {
      throw new ParticipantException("Participant with id " + participantid + " not found");
    }
  }

  public Session createAndPersistSession(Integer programId, Integer courseId, Date startDateTime, Date endDateTime, Double price, String room) throws ProgramException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course courseFromBD = this.getCourseByIdProgramId(programId, courseId);
    Session session = new Session(startDateTime, endDateTime, price, room);
    if (courseFromBD != null) {
      courseFromBD.addSessions(session);
      entityManager.persist(session);
      entityManager.merge(courseFromBD);
      entityManager.getTransaction().commit();
      entityManager.close();
      return session;
    } else {
      throw new ProgramException("Program or course not found");
    }
  }

  public void registerParticipantToCourse(Integer programId, Integer courseId, Integer participantId) throws ProgramException, ParticipantException {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course courseFromDB = this.getCourseByIdProgramId(programId, courseId);
    Participant participantFromDB = this.getParticipantByID(participantId);
    if (courseFromDB != null && participantFromDB != null) {
      participantFromDB.addCourses(courseFromDB);
      entityManager.merge(participantFromDB);
      entityManager.getTransaction().commit();
      entityManager.close();
    } else {
      throw new ProgramException("Course or participant not found");
    }
  }

  public void finalize() throws Throwable {
    this.entityManagerFactory.close();
    super.finalize();
  }
}
