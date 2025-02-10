package example.micronaut.controllers;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

@MicronautTest
class HelloControllerTest {

  @Test
  void testHelloEndpoint(RequestSpecification spec) {
    spec
      .when()
      .get("/hello/world")
      .then()
      .statusCode(200)
      .body(is("Hello World"));
  }
}
