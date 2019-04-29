/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Just a "plain old java object" to get you started...
 */
@Entity
@Table
public class Pojo implements Serializable {

  private Long id;
  private String someProperty;

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public String getSomeProperty() {
    return someProperty;
  }

  public void setSomeProperty(String someProperty) {
    this.someProperty = someProperty;
  }

  public Pojo(Long id, String someProperty)
  {
    this.id = id;
    this.someProperty = someProperty;
  }

  public Pojo(String someProperty)
  {
    this.someProperty = someProperty;
  }

  public Pojo(){}


  @Override
  public boolean equals(Object o) {
    if(this == o){
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pojo pojo = (Pojo) o;

    return id == pojo.getId() &&
        someProperty.equals(pojo.getSomeProperty());
  }
}
