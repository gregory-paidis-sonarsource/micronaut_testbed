package example.micronaut.configuration;

import io.micronaut.context.ApplicationContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamConfigurationTest {
  @Test
  void testTeamConfiguration() {
    List<String> names = Arrays.asList("Nirav Assar", "Lionel Messi");
    Map<String, Object> items = new HashMap<>();
    items.put("team.name", "evolution");
    items.put("team.color", "green");
    items.put("team.player-names", names);

    ApplicationContext ctx = ApplicationContext.run(items);
    TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration.class);

    assertEquals("evolution", teamConfiguration.getName());
    assertEquals("green", teamConfiguration.getColor());
    assertEquals(names.size(), teamConfiguration.getPlayerNames().size());
    names.forEach(name -> assertTrue(teamConfiguration.getPlayerNames().contains(name)));

    ctx.close();
  }
}
