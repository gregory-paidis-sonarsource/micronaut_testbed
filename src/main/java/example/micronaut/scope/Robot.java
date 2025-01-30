package example.micronaut.scope;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import java.util.UUID;

@Singleton
public class Robot {
  @NonNull
  private final String serialNumber;

  public Robot() {
    serialNumber = UUID.randomUUID().toString();
  }

  @NonNull
  public String getSerialNumber() {
    return serialNumber;
  }
}
