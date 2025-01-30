package example.micronaut.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import java.util.List;

@ConfigurationProperties("team")
public class TeamConfiguration {
  private String name;
  private String color;
  private List<String> playerNames;

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
