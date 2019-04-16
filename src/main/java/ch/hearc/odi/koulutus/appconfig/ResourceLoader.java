/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.appconfig;

import ch.hearc.odi.koulutus.injection.ServiceBinder;
import ch.hearc.odi.koulutus.injection.ServiceFeature;
import ch.hearc.odi.koulutus.restresources.CourseResource;
import ch.hearc.odi.koulutus.restresources.ParticipantResource;
import ch.hearc.odi.koulutus.restresources.ProgramResource;
import ch.hearc.odi.koulutus.restresources.SessionResource;
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
    registerInstances(new ServiceBinder());
  }

}