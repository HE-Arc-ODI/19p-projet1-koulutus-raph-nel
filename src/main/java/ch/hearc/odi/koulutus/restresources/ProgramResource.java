package ch.hearc.odi.koulutus.restresources;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exception.ProgramException;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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
public class ProgramResource implements Serializable {

  @Inject
  PersistenceService persistenceService;

  @GET
  public List<Program> getPrograms() {
    return persistenceService.getPrograms();
  }

  @GET
  @Path("{programId}")
  public Program getProgram(@PathParam("programId") Integer programId) {
    return persistenceService.getProgramById(programId);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Program programPost(
      @FormParam("name") String courseName,
      @FormParam("richdescritpion") String richeDescritpion,
      @FormParam("field") String field,
      @FormParam("price") Integer price) {
    return persistenceService
        .createAndPersistProgram(courseName, richeDescritpion, field, price);
  }

  @DELETE
  @Path("{programId}")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteProgram(@PathParam("programId") Integer programId) throws ProgramException {
    persistenceService.deleteProgram(programId);
  }

  @PUT
  @Path("{programId}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Program updateProgram(@PathParam("programId") Integer programId,
      @FormParam("name") String programName,
      @FormParam("richdescritpion") String richeDescritpion,
      @FormParam("field") String field,
      @FormParam("price") Integer price) throws ProgramException {
    return persistenceService
        .updateProgam(programId, programName, richeDescritpion, field, price);
  }
}
