package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramResource {
  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Program> programGet(){
    return persistenceService.getPrograms();
  }

  @POST
  public Program programPost(Program program ){
    return persistenceService.createAndPersistProgram(program.getName(),program.getRichDescription(),program.getField(),program.getPrice());
  }
}
