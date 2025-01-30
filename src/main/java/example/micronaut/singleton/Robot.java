package example.micronaut.singleton;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.runtime.http.scope.RequestScope;
import java.util.UUID;


// See https://guides.micronaut.io/latest/micronaut-scope-types-gradle-java.html for more on scopes.
// Prototype:       once per injection point.
// RequestScope:    once per request.
// Singleton:       once forever.
@RequestScope
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
