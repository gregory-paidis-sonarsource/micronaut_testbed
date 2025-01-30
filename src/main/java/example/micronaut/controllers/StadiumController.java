package example.micronaut.controllers;

import example.micronaut.configuration.StadiumConfiguration;
import example.micronaut.configuration.TeamAdmin;
import example.micronaut.configuration.TeamConfiguration2;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import jakarta.inject.Named;

// Configuration has the following flavors: @ConfigurationProperties, @ConfigurationBuilder, @EachProperty
// ref https://guides.micronaut.io/latest/micronaut-configuration-gradle-java.html
@Controller("/stadium")
public class StadiumController {

  private final TeamConfiguration2 teamConfiguration;
  private final StadiumConfiguration stadiumConfiguration;

  public StadiumController(
    @Nullable TeamConfiguration2 teamConfiguration,
    @Nullable @Named("coors") StadiumConfiguration stadiumConfiguration) {
    this.teamConfiguration = teamConfiguration;
    this.stadiumConfiguration = stadiumConfiguration;
  }

  @Get("/team")
  public TeamConfiguration2 team() {
    return this.teamConfiguration;
  }

  @Get("/team/admin")
  public TeamAdmin teamAdmin() {
    return this.teamConfiguration.getBuilder().build();
  }

  @Get("/stadium")
  public StadiumConfiguration stadium() {
    return this.stadiumConfiguration;
  }
}
