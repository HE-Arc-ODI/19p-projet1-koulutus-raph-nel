package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.exceptions.ParticipantException;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("participant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipantResource {

  @Inject private PersistenceService persistenceService;

  @GET
  public List<Participant> getParticipants() {
    return persistenceService.getParticipants();
  }

  @POST
  public Participant postParticipant(Participant participant) {
    return persistenceService.createAndPersistParticipant(
        participant.getId(),
        participant.getFirstName(),
        participant.getLastName(),
        participant.getBirthdate());
  }

  @GET
  @Path("{participantId}")
  public Participant getParticipantById(@PathParam("participantId") Long participantId)
      throws ParticipantException {
    return persistenceService.getParticipantById(participantId);
  }

  @DELETE
  @Path("{participantId}")
  public Response participantDelete(@PathParam("participantId") Long participantid) {
    try {
      persistenceService.deleteParticipant(participantid);
      return Response.status(Response.Status.OK).build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Status.NOT_FOUND).build();
    }
  }

  @PUT
  @Path("{participantId}")
  public Participant updateParticipant(
      @PathParam("participantId") Long participantId, Participant participant)
      throws ParticipantException {
    return persistenceService.updateParticipant(participantId, participant);
  }
}
