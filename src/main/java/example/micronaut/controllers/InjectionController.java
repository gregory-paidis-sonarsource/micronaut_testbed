package example.micronaut.controllers;

import example.micronaut.scope.Robot;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

// You can inject an object via constructor, field, or method.
// According to the documentation, you should use the Constructor way.
// ref https://guides.micronaut.io/latest/micronaut-dependency-injection-types-gradle-java.html
//  When possible, we recommend you use Constructor Injection for several reasons:
//    Clear Contract
//      Constructor injection clearly expresses the requirements of the class and requires no additional annotation.
//    Immutability
//      Constructor injection allows you to define final dependencies. Thus, creating immutable objects.
//    Identifying code smells
//      Constructor injection helps you easily identify if your bean depends on too many other objects.
//    Testing
//      Constructor injection simplifies writing both unit and integration tests. The constructor forces us to provide valid objects for all dependencies. Thus, it decreases the chance of a NullPointerException occurrence during testing.
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
