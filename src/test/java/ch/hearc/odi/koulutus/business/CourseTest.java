package ch.hearc.odi.koulutus.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CourseTest {

<<<<<<< HEAD
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Course course;

  @Before
  public void init() {course = new Course();}

}

=======
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Course course;

    @Before
    public void init() {course = new Course(1, 1990, 10);}

  }
>>>>>>> dev_nel_2
