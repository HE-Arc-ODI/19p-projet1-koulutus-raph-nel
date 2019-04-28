package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

  @Inject
  private PersistenceService persistenceService;

  @GET
  @Path("{programId}")
  public List<Course>getCourses(@PathParam("programId") Long programId){
    return persistenceService.g
  }




}
