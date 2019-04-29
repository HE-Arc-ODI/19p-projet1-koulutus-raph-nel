/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.services;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exceptions.ParticipantException;
import ch.hearc.odi.koulutus.exceptions.ProgramException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenceService {

  private EntityManagerFactory entityManagerFactory;

  private static Logger LOGGER = LogManager.getLogger(PersistenceService.class);

  public PersistenceService() {
    //  an EntityManagerFactory is set up once for an application
    //  IMPORTANT: the name here matches the name of persistence-unit in persistence.xml
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

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
    entityManager.persist(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }

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
    super.finalize();
  }
}
