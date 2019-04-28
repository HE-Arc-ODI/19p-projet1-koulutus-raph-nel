package ch.hearc.odi.koulutus.business;

import static org.junit.Assert.assertEquals;

import ch.hearc.odi.koulutus.business.Course.StatusEnum;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProgramTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Program program;

  @Before
  public void init() {program = new Program();}

  @Test
  public void testAddCourses() {
    // Arrange / Build
    Long testId = 1L;
    Course input = new Course(testId);
    Long expected = testId;
    // Act / Operate
     program.addCourse(input);
     List<Course> actual = program.getCourses();
    // Assert / Check
    assertEquals(expected, actual.get(0).getId());
  }


}
