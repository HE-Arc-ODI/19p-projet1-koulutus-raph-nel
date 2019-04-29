package ch.hearc.odi.koulutus.business;

<<<<<<< HEAD
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
=======
import static org.hamcrest.CoreMatchers.is;

import ch.hearc.odi.koulutus.restresources.SessionResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;

>>>>>>> dev_nel_2

public class SessionTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
<<<<<<< HEAD
=======
  private final DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
>>>>>>> dev_nel_2
  private Session session;

  @Before
  public void init() {session = new Session();}

<<<<<<< HEAD

}
=======
   /* @Test
    public void addOneParticipant()
        throws ParseException {
      Participant participant = new Participant("Rayan", "Frutiger", "20/11/2014");
      Session session = new Session(format.parse("2019-01-01"), format.parse("2019-01-25"), 20.33, "ours");
      session.addParticipant(participant);
      Assert.assertThat(session, is());
    }*/
  }
>>>>>>> dev_nel_2
