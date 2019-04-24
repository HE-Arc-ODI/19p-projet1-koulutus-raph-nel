package ch.hearc.odi.koulutus.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class SessionTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Session session;

  @Before
  public void init() {session = new Session();}


}
