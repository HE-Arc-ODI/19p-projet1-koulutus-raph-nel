/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.appconfig;

import ch.hearc.odi.koulutus.injection.ServiceBinder;
import ch.hearc.odi.koulutus.injection.ServiceFeature;
<<<<<<< HEAD
import ch.hearc.odi.koulutus.rest.ParticipantResource;
import ch.hearc.odi.koulutus.rest.ProgramResource;
=======
import ch.hearc.odi.koulutus.restresources.CourseResource;
import ch.hearc.odi.koulutus.restresources.ParticipantResource;
import ch.hearc.odi.koulutus.restresources.ProgramResource;
import ch.hearc.odi.koulutus.restresources.SessionResource;
>>>>>>> dev_nel_2
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers all resources with Jersey
 */
public class ResourceLoader extends ResourceConfig {

  public ResourceLoader() {
    register(CourseResource.class);
    register(ParticipantResource.class);
    register(ProgramResource.class);
    register(SessionResource.class);
    register(ServiceFeature.class);
    register(ParticipantResource.class);
    register(ProgramResource.class);
    registerInstances(new ServiceBinder());
  }

}