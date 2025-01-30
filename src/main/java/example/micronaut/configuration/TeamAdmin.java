package example.micronaut.configuration;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class TeamAdmin {

  private String manager;
  private String coach;
  private String president;

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public String getCoach() {
    return coach;
  }

  public void setCoach(String coach) {
    this.coach = coach;
  }

  public String getPresident() {
    return president;
  }

  public void setPresident(String president) {
    this.president = president;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String manager;
    private String coach;
    private String president;


    public Builder withManager(String manager) {
      this.manager = manager;
      return this;
    }

    public Builder withCoach(String coach) {
      this.coach = coach;
      return this;
    }

    public Builder withPresident(String president) {
      this.president = president;
      return this;
    }

    public TeamAdmin build() {
      TeamAdmin teamAdmin = new TeamAdmin();
      teamAdmin.manager = this.manager;
      teamAdmin.coach = this.coach;
      teamAdmin.president = this.president;
      return teamAdmin;
    }

    public String getManager() {
      return manager;
    }

    public String getCoach() {
      return coach;
    }

    public String getPresident() {
      return president;
    }
  }
}
