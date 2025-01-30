package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void testHelloWorld() {
    HttpRequest<?> request = HttpRequest.GET("/hello/world").accept(MediaType.APPLICATION_JSON);
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello World", body);
  }

  @ParameterizedTest
  @ValueSource(strings = {"greg", "exploding", "whale"})
  void testHelloByName(String name) {
    HttpRequest<?> request = HttpRequest.GET("/hello/" + name).accept(MediaType.APPLICATION_JSON);
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello " + name, body);
  }
}
