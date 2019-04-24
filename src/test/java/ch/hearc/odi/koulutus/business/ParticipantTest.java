package ch.hearc.odi.koulutus.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParticipantTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Participant participant;

  @Before
  public void init() {participant = new Participant();}


}
