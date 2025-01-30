package example.micronaut.controllers;

import example.micronaut.singleton.Robot;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

@Controller("/injection")
@Produces(MediaType.TEXT_PLAIN)
public class InjectionController {

  @Inject
  Robot robotByField;

  private final Robot robotByConstructor;

  public InjectionController(Robot robot) {
    robotByConstructor = robot;
  }

  private Robot robotByMethod;

  @Inject
  void populateRobot(Robot robot) {
    this.robotByMethod = robot;
  }

  @Get("field")
  String byField() {
    return robotByField.getSerialNumber();
  }

  @Get("constructor")
  String byConstructor() {
    return robotByConstructor.getSerialNumber();
  }

  @Get("method")
  String byMethod() {
    return robotByMethod.getSerialNumber();
  }

}
