package harouane.Entities.Persons;

import harouane.Entities.Eventi.AthleticCompetition;
import harouane.Entities.Person;
import harouane.enums.Genre;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorColumn(name = "atleta")
public class Athlete extends Person {
    String team;

    public Athlete() {
    }

    public Athlete(String firstName, String lastName, String email, Date dateOfBirthday, Genre genre, String team) {
        super(firstName, lastName, email, dateOfBirthday, genre);
        this.team = team;
    }

    @ManyToMany
    @JoinTable(name="athletes_competitions", joinColumns = @JoinColumn(name = "athletes"), inverseJoinColumns = @JoinColumn(name = "competitions"))
    Set<AthleticCompetition> competitions;

    @OneToOne(mappedBy = "winner")
    AthleticCompetition competitionWon;
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Set<AthleticCompetition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<AthleticCompetition> competitions) {
        this.competitions = competitions;
    }

    public AthleticCompetition getCompetitionWon() {
        return competitionWon;
    }

    public void setCompetitionWon(AthleticCompetition competitionWon) {
        this.competitionWon = competitionWon;
    }

}
