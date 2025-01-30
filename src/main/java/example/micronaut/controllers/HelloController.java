package example.micronaut.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {

  @Get("world")
  public String World() {
    return "Hello World";
  }

  @Get("{name}")
  public String ByName(String name) {
    return String.format("Hello %s", name);
  }
}
