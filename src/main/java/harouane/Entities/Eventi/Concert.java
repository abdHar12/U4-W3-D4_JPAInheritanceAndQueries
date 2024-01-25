package harouane.Entities.Eventi;

import harouane.Entities.Event;
import harouane.Entities.Location;
import harouane.enums.EventType;
import harouane.enums.MusicalGenre;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Event {
boolean streaming;
MusicalGenre musicalGenre;
    public Concert() {
    }

    public Concert(String title, LocalDate date, String description, EventType eventType, Integer maxNumberParticipants, Location location, boolean streaming) {
        super(title, date, description, eventType, maxNumberParticipants, location);
        this.streaming=streaming;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public MusicalGenre getMusicalGenre() {
        return musicalGenre;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    public void setMusicalGenre(MusicalGenre musicalGenre) {
        this.musicalGenre = musicalGenre;
    }
}
