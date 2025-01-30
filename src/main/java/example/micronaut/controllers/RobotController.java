package example.micronaut.controllers;

import example.micronaut.singleton.RobotFather;
import example.micronaut.singleton.RobotMother;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.List;

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
