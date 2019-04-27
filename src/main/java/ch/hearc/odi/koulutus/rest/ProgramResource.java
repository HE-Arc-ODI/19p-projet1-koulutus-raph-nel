package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramResource {
  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Program> getPrograms(){
    return persistenceService.getPrograms();
  }

  @GET
  @Path("{programId}")
  public Program getProgram(@PathParam("programId") Long programId){
    return persistenceService.getProgrambyId(programId);
  }

  @POST
  public Program programPost(Program program ){
    return persistenceService.createAndPersistProgram(program.getName(),program.getRichDescription(),program.getField(),program.getPrice());
  }
}
