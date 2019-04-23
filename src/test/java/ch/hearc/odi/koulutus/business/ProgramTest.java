package ch.hearc.odi.koulutus.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ProgramTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Program program;

  @Before
  public void init() {program = new Program();}


}
