package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exceptions.ProgramException;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramResource {

  @Inject private PersistenceService persistenceService;

  @GET
  public List<Program> getPrograms() {
    return persistenceService.getPrograms();
  }

  @GET
  @Path("{programId}")
  public Program getProgram(@PathParam("programId") Long programId) {
    return persistenceService.getProgrambyId(programId);
  }

  @POST
  public Program postProgram(Program program) {
    return persistenceService.createAndPersistProgram(program);
  }

  @DELETE
  @Path("{programId}")
  public void deletProgram(@PathParam("programId") long programId) throws ProgramException {
    persistenceService.deleteProgram(programId);
  }

  @PUT
  @Path("{programId}")
  public Program updateProgram(@PathParam("programId") Long programId, Program program) {
    return persistenceService.updateProgram(
        programId,
        program.getName(),
        program.getRichDescription(),
        program.getField(),
        program.getPrice());
  }

  @GET
  @Path("{programId}/course")
  public List<Course> getCourses(@PathParam("programId") Long programId) throws ProgramException {
    return persistenceService.getCoursesByProgramId(programId);
  }

  @GET
  @Path("{programId}/course/{courseId}")
  public Course getCourseById(
      @PathParam("programId") Long programId, @PathParam("courseId") Long courseId)
      throws ProgramException {
    return persistenceService.getCourseByIdProgramId(programId, courseId);
  }

  @POST
  @Path("{programId}")
  public void postCourse(@PathParam("programId") Long programId, Course newCourse)
      throws ProgramException {
    persistenceService.addCourseToProgram(programId, newCourse);
  }

  @DELETE
  @Path("{programId}/course/{courseId}")
  public void deleteCourse(
      @PathParam("programId") Long programId, @PathParam("courseId") Long courseId)
      throws ProgramException {
    persistenceService.getCourseByIdProgramId(programId, courseId);
  }

  @PUT
  @Path("{programId}/course/{courseId}")
  public Course updateCourse(
      @PathParam("programId") Long programId, @PathParam("courseId") Long courseId, Course course)
      throws ProgramException {
    return persistenceService.updateCourse(programId, courseId, course);
  }
 /* @GET
  @Path("{programId}/course/{courseId}")
  public List<Participant> getCourseById(
      @PathParam("programId") Long programId, @PathParam("courseId") Long courseId, Course course){
  }*/
}
