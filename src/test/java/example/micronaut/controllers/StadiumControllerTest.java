package example.micronaut.controllers;

import example.micronaut.configuration.StadiumConfiguration;
import example.micronaut.configuration.TeamAdmin;
import example.micronaut.configuration.TeamConfiguration2;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class StadiumControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void testMyStadium() {
    StadiumConfiguration conf = client.toBlocking()
      .retrieve(HttpRequest.GET("/stadium/stadium"), StadiumConfiguration.class);
    assertEquals("Pittsburgh", conf.getCity());
    assertEquals(35000, conf.getSize());
  }

  @Test
  void testMyTeam() {
    TeamConfiguration2 teamConfiguration = client.toBlocking()
      .retrieve(HttpRequest.GET("/stadium/team"), TeamConfiguration2.class);
    assertEquals("Steelers", teamConfiguration.getName());
    assertEquals("Black", teamConfiguration.getColor());
    List<String> expectedPlayers = Arrays.asList("Mason Rudolph", "James Connor");
    assertEquals(expectedPlayers.size(), teamConfiguration.getPlayerNames().size());
    expectedPlayers.forEach(name -> assertTrue(teamConfiguration.getPlayerNames().contains(name)));
  }

  @Test
  void testMyTeamAdmin() {
    TeamAdmin conf = client.toBlocking()
      .retrieve(HttpRequest.GET("/stadium/team/admin"), TeamAdmin.class);
    assertEquals("Nirav Assar", conf.getManager());
    assertEquals("Mike Tomlin", conf.getCoach());
    assertEquals("Dan Rooney", conf.getPresident());
  }
}
