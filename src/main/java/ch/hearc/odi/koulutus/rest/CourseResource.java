package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.services.PersistenceService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

  @Inject
  private PersistenceService persistenceService;



}
