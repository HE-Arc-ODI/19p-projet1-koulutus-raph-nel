//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ch.hearc.odi.koulutus.services;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
<<<<<<< HEAD
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exceptions.ParticipantException;
import ch.hearc.odi.koulutus.exceptions.ProgramException;
import java.math.BigDecimal;
=======
import ch.hearc.odi.koulutus.business.Pojo;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.exception.ParticipantException;
import ch.hearc.odi.koulutus.exception.ProgramException;
>>>>>>> dev_nel_2
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
<<<<<<< HEAD
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import javax.persistence.TypedQuery;
>>>>>>> dev_nel_2

public class PersistenceService {
  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");

  public PersistenceService() {
  }

<<<<<<< HEAD
  private static Logger LOGGER = LogManager.getLogger(PersistenceService.class);
=======
  public ArrayList<Program> getPrograms() {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Program> programs = entityManager.createQuery("from Program", Program.class).getResultList();
    return (ArrayList)programs;
  }
>>>>>>> dev_nel_2

  public Program getProgramById(Integer programId) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = (Program)entityManager.find(Program.class, programId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

<<<<<<< HEAD
  /**
   * Return all existing programs
   *
   * @return a list
   */
  public ArrayList<Program> getPrograms() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Program> programs =
        entityManager.createQuery("from Program", Program.class).getResultList();
    LOGGER.info("getProgram; call of all programs");
    entityManager.getTransaction().commit();
    entityManager.close();

    return (ArrayList<Program>) programs;
  }

  /**
   * Return program by ID
   *
   * @return a program
   */
  public Program getProgrambyId(Long programId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  /**
   * Create a new Program and persist
   *
   * @return the Program object created
   */
  public Program createAndPersistProgram(Program newProgram) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program =
        new Program(
            newProgram.getName(),
            newProgram.getRichDescription(),
            newProgram.getField(),
            newProgram.getPrice());
    entityManager.persist(program);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  /**
   * Create a new Participant and persist
   *
   * @return the Participant object created
   */
  public Participant createAndPersistParticipant(
      Long id, String firstName, String lastName, Date birthdate) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = new Participant(id, firstName, lastName, birthdate);
=======
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
>>>>>>> dev_nel_2
    entityManager.persist(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }
<<<<<<< HEAD

  /**
   * Delete a program
   *
   * @return void
   */
  public void deleteProgram(Long programId) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    entityManager.remove(program);
    if (program == null) {
      LOGGER.warn("deleteProgram; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("deleteProgram; Program with id " + programId + " was deleted");
  }

  /**
   * Update a program
   *
   * @param programId specifies which program to update
   * @param name, richDescription, field, price
   * @return the program updated
   */
  public Program updateProgram(
      Long programId, String name, String richDescription, String field, BigDecimal price) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    program.setName(name);
    program.setRichDescription(richDescription);
    program.setField(field);
    program.setPrice(price);
    entityManager.getTransaction().commit();
    return program;
  }

  /**
   * Update a course
   *
   * @param programId specifies which program to update
   * @param courseId specifies which course to update
   * @return the program updated
   */
  public Course updateCourse(Long programId, Long courseId, Course updatedCourse)
      throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    Course course = program.getCourseById(courseId);
    if (program == null) {
      LOGGER.warn("updateCourse; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    } else if (course == null) {
      LOGGER.warn("updateCourse; Course with id " + courseId + " not found");
      throw new ProgramException("Course with id " + courseId + " not found");
    }
    program.deleteCourseById(course.getId());
    program.addCourse(updatedCourse);
    entityManager.getTransaction().commit();
    return updatedCourse;
  }

  /**
   * Return course by ID
   *
   * @return List of Course
   */
  public List<Course> getCoursesByProgramId(Long programId) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    if (program == null) {
      LOGGER.warn("getCoursesByProgramId; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getCoursesByProgramId; Program with " + programId + " was found");
    return program.getCourses();
  }

  public void addCourseToProgram(Long programId, Course newCourse) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    if (program == null) {
      LOGGER.warn("addCourseToProgram; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    } else {
      program.addCourse(newCourse);
      entityManager.getTransaction().commit();
      entityManager.close();
      LOGGER.info(
          "addCourseToProgram; Program with "
              + programId
              + "received a new course with id "
              + newCourse.getId()
              + " ");
    }
  }

  public Course getCourseByIdProgramId(Long programId, Long courseId) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    Course course = program.getCourseById(courseId);
    if (program == null) {
      LOGGER.warn("getCourseByIdProgramId; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    } else if (course == null) {
      LOGGER.warn("getCourseByIdProgramId; Course with id " + courseId + " not found");
      throw new ProgramException("Course with id " + courseId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getCourseByIdProgramId; Course with " + courseId + " was found");
    return course;
  }

  /* public Course getParticipantByprogramIdCourseId(Long programId, Long courseId) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    Course course = program.getCourseById(courseId);
    if (program == null) {
      LOGGER.warn("getCourseByIdProgramId; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    } else if (course == null) {
      LOGGER.warn("getCourseByIdProgramId; Course with id " + courseId + " not found");
      throw new ProgramException("Course with id " + courseId + " not found");
    }
    Paticipant paticipant = course.get
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getCourseByIdProgramId; Course with " + courseId + " was found");
    return course;
  }*/

  public void deleteCourse(Long programId, Long courseId) throws ProgramException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    Course course = program.getCourseById(courseId);
    if (program == null) {
      LOGGER.warn("deleteCourse; Program with id " + programId + " not found");
      throw new ProgramException("Program with id " + programId + " not found");
    } else if (course == null) {
      LOGGER.warn("deleteCourse; Course with id " + courseId + " not found");
      throw new ProgramException("Course with id " + courseId + " not found");
    }
    program.deleteCourseById(course.getId());
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("deleteCourse; Course with " + courseId + " was deleted");
  }

  /**
   * Return all existing participant
   *
   * @return a list
   */
  public ArrayList<Participant> getParticipants() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Participant> participant =
        entityManager.createQuery("from Participant", Participant.class).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getParticipants; call of all participants");
    return (ArrayList<Participant>) participant;
  }

  /**
   * Return participant by ID
   *
   * @return a participant
   */
  public Participant getParticipantById(Long participantId) throws ParticipantException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);

    if (participant == null) {
      LOGGER.warn("getParticipantById; Participant with id " + participantId + " not found");
      throw new ParticipantException("Participant with id " + participantId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getParticipants; Participant with id " + participantId + " was called");
    return participant;
  }

  /**
   * Delete a participant
   *
   * @return void
   */
  public void deleteParticipant(Long participantId) throws ParticipantException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    entityManager.remove(participant);
    if (participant == null) {
      LOGGER.warn("deleteParticipant; Participant with id " + participantId + " not found");
      throw new ParticipantException("Participant with id " + participantId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("deleteParticipant; Participant with id " + participantId + " was deleted");
  }

  /**
   * Update a participant
   *
   * @return participant
   */
  public Participant updateParticipant(Long participantId, Participant newParticipant)
      throws ParticipantException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    if (participant == null) {
      LOGGER.warn("putParticipant; Participant with id " + participantId + " not found");
      throw new ParticipantException("Participant with id " + participantId + " not found");
    }
    participant.setId(participantId);
    participant.setFirstName(newParticipant.getFirstName());
    participant.setLastName(newParticipant.getLastName());
    participant.setBirthdate(newParticipant.getBirthdate());
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("updateParticipant; Participant with id " + participantId + " was updated");
    return participant;
  }

  @Override
  public void finalize() throws Throwable {
    entityManagerFactory.close();
=======

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

  public Pojo createAndPersistAPojo(String Mess){
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Pojo pojo = new Pojo(Mess);
    entityManager.persist(pojo);
    entityManager.getTransaction().commit();
    entityManager.close();
    return pojo;
  }

  public void finalize() throws Throwable {
    this.entityManagerFactory.close();
>>>>>>> dev_nel_2
    super.finalize();
  }
}
