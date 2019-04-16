package ch.hearc.odi.koulutus.restresources;

import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("program")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class ProgramResource implements Serializable {

  @Inject
  PersistenceService persistenceService;

  @GET
  public List<Program> getPrograms(){
    return persistenceService.getPrograms();
  }

}
