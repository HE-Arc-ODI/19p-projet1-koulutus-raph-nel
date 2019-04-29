package ch.hearc.odi.koulutus.business;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

import ch.hearc.odi.koulutus.business.Course.StatusEnum;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProgramTest {
  @Rule public ExpectedException thrown = ExpectedException.none();
  private Program program;

  @Before
  public void init() {
    program = new Program();
  }

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

  @Test
  public void testGetCourseById() {
    // Arrange / Build
    Long testId = 1L;
    Course input = new Course(testId);
    Long expected = testId;
    // Act / Operate
    program.addCourse(input);
    Course actual = program.getCourseById(testId);
    // Assert / Check
    assertEquals(expected, actual.getId());
  }

  @Test
  public void testDeleteCourseById() {
    // Arrange / Build
    Long testId = 1L;
    Long testSecondId = 2L;
    Course input = new Course(testId);
    Course input2 = new Course(testSecondId);
    Long expected = testSecondId;
    // Act / Operate
    program.addCourse(input);
    program.addCourse(input2);
    program.deleteCourseById(testId);
    Long actual = program.getCourses().get(0).getId();
    // Assert / Check
    assertEquals(expected, actual);
  }
=======
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ProgramTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Program program;

  @Before
  public void init() {program = new Program();}


>>>>>>> dev_nel_2
}
