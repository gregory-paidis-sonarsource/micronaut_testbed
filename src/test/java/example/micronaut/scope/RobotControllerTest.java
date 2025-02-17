package example.micronaut.scope;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class RobotControllerTest {
  @Inject
  @Client("/")
  HttpClient httpClient;

  @ParameterizedTest
  @ValueSource(strings = {"/robot"})
  void onlyOneInstanceOfTheBeanExistsForSingletonBeans(String path) {
    BlockingHttpClient client = httpClient.toBlocking();
    Set<String> responses = new HashSet<>(executeRequest(client, path));
    assertEquals(1, responses.size());
    responses.addAll(executeRequest(client, path));
    assertEquals(1, responses.size());
  }

  List<String> executeRequest(BlockingHttpClient client, String path) {
    return client.retrieve(HttpRequest.GET(path),
      Argument.listOf(String.class));
  }
}
