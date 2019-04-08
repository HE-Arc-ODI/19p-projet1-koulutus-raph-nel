/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.appconfig;

import ch.hearc.odi.koulutus.injection.ServiceBinder;
import ch.hearc.odi.koulutus.injection.ServiceFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers all resources with Jersey
 */
public class ResourceLoader extends ResourceConfig {

  public ResourceLoader() {
    //  TODO: register resources
    register(ServiceFeature.class);
    registerInstances(new ServiceBinder());
  }

}