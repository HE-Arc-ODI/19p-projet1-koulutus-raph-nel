package ch.hearc.odi.koulutus.restresources;

import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.exception.ProgramException;
import ch.hearc.odi.koulutus.services.PersistenceService;

import java.text.ParseException;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("session")
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {
  @Inject
  private PersistenceService persistenceService;

  @GET
  public Session getSession(){
    return getSession(); //persistenceService.createAndPersistSession(getSession());
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Session addParticipant(@FormParam ("programId") Integer programId, @FormParam("courseId")
      Integer courseId, @FormParam("startDateTime") Date startDateTime,  @FormParam("endDateTime")
      Date endDateTime, @FormParam("price") Double price, @FormParam("room") String room){
    try{
      //Date birthdateConverted = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
      return persistenceService.createAndPersistSession(programId, courseId, startDateTime, endDateTime, price, room);
    }catch (ProgramException ex){
      throw new WebApplicationException("Error with program");
    }
  }

}
