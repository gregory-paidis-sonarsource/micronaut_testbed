package example.micronaut.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
@JsonIgnoreProperties("builder")
//tag::teamConfigClassNoBuilder[]
@ConfigurationProperties("team")
public class TeamConfiguration2 {
  private String name;
  private String color;
  private List<String> playerNames;
//end::teamConfigClassNoBuilder[]

  public TeamConfiguration2() {
  }

  @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
  protected TeamAdmin.Builder builder = TeamAdmin.builder();

  public TeamAdmin.Builder getBuilder() {
    return builder;
  }

  public void setBuilder(TeamAdmin.Builder builder) {
    this.builder = builder;
  }

  //tag::gettersandsetters[]
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<String> getPlayerNames() {
    return playerNames;
  }

  public void setPlayerNames(List<String> playerNames) {
    this.playerNames = playerNames;
  }
}
//end::gettersandsetters[]
