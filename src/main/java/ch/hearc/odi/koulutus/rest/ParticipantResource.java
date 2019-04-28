package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Participant;
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

@Path("participant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipantResource {

  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Participant> getParticipants(){
    return persistenceService.getParticipants();
  }

  @POST
  public Participant postParticipant(Participant participant){
    return persistenceService.createAndPersistParticipant(participant.getId(),participant.getFirstName(),participant.getLastName(),participant.getBirthdate());
  }
  @GET
  @Path("{participantId}")
  public Participant participantIdGet(@PathParam("participantId") Long participantid){
    return persistenceService.;
  }
}
