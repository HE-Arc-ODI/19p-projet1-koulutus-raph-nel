package ch.hearc.odi.koulutus.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;

public class PersistenceServiceTest {

  private PersistenceService persistenceService;
  private EntityManagerFactory entityManagerFactory;

  @Before
  public void setUp() throws Exception {
    persistenceService = new PersistenceService();
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

}