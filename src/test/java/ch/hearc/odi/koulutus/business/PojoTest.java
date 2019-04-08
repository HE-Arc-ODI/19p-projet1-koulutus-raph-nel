package ch.hearc.odi.koulutus.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class PojoTest {

  @Test
  public void dummyTest(){
    String testString = "Hello world!";
    Pojo myPojo = new Pojo();
    myPojo.setSomeProperty(testString);
    assertEquals(testString, myPojo.getSomeProperty());
  }

}