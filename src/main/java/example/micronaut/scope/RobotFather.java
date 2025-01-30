package example.micronaut.scope;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.core.annotation.NonNull;

@Prototype
public class RobotFather {
  private final Robot robot;

  public RobotFather(Robot robot) {
    this.robot = robot;
  }

  @NonNull
  public Robot child() {
    return this.robot;
  }
}
