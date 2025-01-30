package example.micronaut.scope;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.core.annotation.NonNull;

@Prototype
public class RobotMother {
  private final Robot robot;

  public RobotMother(Robot robot) {
    this.robot = robot;
  }

  @NonNull
  public Robot child() {
    return this.robot;
  }
}
