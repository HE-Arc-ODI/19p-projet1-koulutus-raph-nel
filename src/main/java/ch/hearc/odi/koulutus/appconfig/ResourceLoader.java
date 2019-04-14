/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.appconfig;

import ch.hearc.odi.koulutus.injection.ServiceBinder;
import ch.hearc.odi.koulutus.injection.ServiceFeature;
import ch.hearc.odi.koulutus.restresources.CourseResources;
import ch.hearc.odi.koulutus.restresources.ParticipantResources;
import ch.hearc.odi.koulutus.restresources.ProgramResources;
import ch.hearc.odi.koulutus.restresources.SessionResources;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers all resources with Jersey
 */
public class ResourceLoader extends ResourceConfig {

  public ResourceLoader() {
    register(CourseResources.class);
    register(ParticipantResources.class);
    register(ProgramResources.class);
    register(SessionResources.class);
    register(ServiceFeature.class);
    registerInstances(new ServiceBinder());
  }

}