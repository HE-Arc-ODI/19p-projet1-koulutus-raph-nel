/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.services;


import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Pojo;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exceptions.CourseException;
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

  private static final Logger LOGGER = LogManager.getLogger(PersistenceService.class);

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
    List<Program> programs = entityManager.createQuery("from Program", Program.class)
        .getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getProgram; call of all programs");
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
  public Program createAndPersistProgram(String name, String richDescription, String field,
      BigDecimal price) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = new Program(name, richDescription, field, price);
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
  public Participant createAndPersistParticipant(Long id, String firstName, String lastName,
      Date birthdate) {
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
  public Program updateProgram(Long programId, String name, String richDescription, String field,
      BigDecimal price) {
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
   * Return course by ID
   *
   * @return List of Course
   */
  public List<Course> getCoursesByProgramId(Long programId) throws CourseException {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    if (program == null) {
      LOGGER.warn("getCoursesByProgramId; Program with id " + programId + " not found");
      throw new CourseException("Program with id " + programId + " not found");
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    LOGGER.info("getCoursesByProgramId; Program with " + programId + " was found");
    return program.getCourses();
  }

  @Override
  public void finalize() throws Throwable {
    entityManagerFactory.close();
    super.finalize();
  }

  public Pojo createAndPersistAPojo(String myProperty) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Pojo pojo = new Pojo();
    pojo.setSomeProperty(myProperty);
    entityManager.persist(pojo);
    entityManager.getTransaction().commit();
    entityManager.close();
    return pojo;
  }

}





