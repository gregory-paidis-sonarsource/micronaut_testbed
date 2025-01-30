package example.micronaut.controllers;

import example.micronaut.scope.RobotFather;
import example.micronaut.scope.RobotMother;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.List;

// There are many ways to scope a bean.
// ref https://guides.micronaut.io/latest/micronaut-scope-types-gradle-java.html
// Some common ones listed here.
// Prototype:       once per injection point.
// RequestScope:    once per request.
// Singleton:       once every time.
@Controller("/robot")
public class RobotController {

  private final RobotFather father;
  private final RobotMother mother;

  public RobotController(RobotFather father,
    RobotMother mother) {
    this.father = father;
    this.mother = mother;
  }

  @Get
  List<String> children() {
    return Arrays.asList(
      father.child().getSerialNumber(),
      mother.child().getSerialNumber()
    );
  }
}
