package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloController {

  @Get("world")
  @Produces(MediaType.APPLICATION_JSON)
  public String World() {
    return "Hello World";
  }

  @Get("{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public String ByName(String name) {
    return String.format("Hello %s", name);
  }
}
