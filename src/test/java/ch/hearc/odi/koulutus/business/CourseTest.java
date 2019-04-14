package ch.hearc.odi.koulutus.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CourseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Course course;

    @Before
    public void init() {course = new Course();}

  }
