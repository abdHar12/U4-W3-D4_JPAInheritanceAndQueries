package harouane.Entities.Eventi;

import harouane.Entities.Event;
import harouane.Entities.Location;
import harouane.enums.EventType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "football_matches")
public class FootballMatch extends Event {
    String homeTeam;
    String awayTeam;
    String winnerTeam;
    int homeTeamGoals;
    int awayTeamGoals;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate date, String description, EventType eventType, Integer maxNumberParticipants, Location location, String homeTeam, String awayTeam, String winnerTeam, int homeTeamGoals, int awayTeamGoals) {
        super(title, date, description, eventType, maxNumberParticipants, location);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winnerTeam = winnerTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }
}
