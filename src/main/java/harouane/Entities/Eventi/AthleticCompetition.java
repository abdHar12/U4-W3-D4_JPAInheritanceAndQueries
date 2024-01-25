package harouane.Entities.Eventi;

import harouane.Entities.Event;
import harouane.Entities.Location;
import harouane.Entities.Person;
import harouane.Entities.Persons.Athlete;
import harouane.enums.EventType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "athletic_competition")
public class AthleticCompetition extends Event {
    @ManyToMany
    @JoinTable(name="athletes_competitions", joinColumns = @JoinColumn(name = "competitions"), inverseJoinColumns = @JoinColumn(name = "athletes"))
    Set<Person> athletes;
    @OneToOne
    @JoinColumn(name = "winner_id", nullable = true)
    Athlete winner;
    public AthleticCompetition() {
    }
    public AthleticCompetition(String title, LocalDate date, String description, EventType eventType, Integer maxNumberParticipants, Location location) {
        super(title, date, description, eventType, maxNumberParticipants, location);
    }
    public Set<Person> getAthletes() {
        return athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setAthletes(Set<Person> athletes) {
        this.athletes = athletes;
    }

    public void setWinner(Athlete winner) {
        this.winner = winner;
    }
}
