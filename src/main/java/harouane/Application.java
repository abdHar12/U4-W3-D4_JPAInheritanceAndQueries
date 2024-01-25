package harouane;

import com.github.javafaker.Faker;
import harouane.DAO.EventDAO;
import harouane.Entities.Eventi.Concert;
import harouane.Entities.Person;
import harouane.enums.EventType;
import harouane.enums.Genre;
import harouane.enums.MusicalGenre;
import harouane.enums.StateParticipation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("gestioneeventi");

    private static final Faker faker =new Faker();

    static Supplier<EventType> getRandomEventType=()->{
        Random num = new Random();
        if(num.nextInt(1, 2)==1) return EventType.PRIVATO;
        return EventType.PUBBLICO;
    };
    static Supplier<Genre> getRandomGenre=()->{
        Random num = new Random();
        if(num.nextInt(1, 2)==1) return Genre.M;
        return Genre.F;
    };
    static Supplier<Integer> getRandomNumberPartecipant=()->{
        Random num = new Random();
        return num.nextInt(50, 250);
    };
    static Supplier<StateParticipation> getRandomPartecipationState=()->{
        Random num = new Random();
        if(num.nextInt(1, 2)==1) return StateParticipation.CONFIRMED;
        return StateParticipation.NOT_CONFIRMED;
    };

    static Supplier<Person> randomPerson=()->{
        return new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),faker.date().birthday(18,50), getRandomGenre.get());
    };
    public static void main(String[] args) {
        EntityManager em= emf.createEntityManager();

        /*Event evToFind = eventDAO.getEventById(5);
        if (evToFind == null) System.out.println("Elemento non trovato!");
        else System.out.println("Elemento trovato: " + evToFind);*/

/*
        PersonDAO personDAO =new PersonDAO(em);
        PartecipationDAO partecipationDAO=new PartecipationDAO(em);
        Person personToFind=personDAO.getPersonById(81);
        Location location= new Location(faker.beer().name(), faker.address().country());
        LocationDAO locationDAO= new LocationDAO(em);
        locationDAO.saveNewLocation(location);
        EventDAO eventDAO= new EventDAO(em);
        Event event= new Event(faker.book().title(), LocalDate.of(new Random().nextInt(2020, 2030), new Random().nextInt(1,12), new Random().nextInt(1,30)), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get(), location);
        System.out.println(event);
        eventDAO.saveNewEvent(event);
        Event evToFind=eventDAO.getEventById(57);
        Participation participation=new Participation(personToFind, evToFind, getRandomPartecipationState.get());
        partecipationDAO.saveNewPartecipation(participation);


        Event evToFind1=eventDAO.getEventById(57);
        Event evToFind2=eventDAO.getEventById(60);
        Event evToFind3=eventDAO.getEventById(64);

        personDAO.saveNewPerson(randomPerson.get());

        List<Event> events=new ArrayList<>();
        events.add(evToFind1);
        events.add(evToFind2);
        events.add(evToFind3);
        personDAO.setNewEventsList(personToFind,events);
        personToFind.getEvents().forEach(ev->System.out.println(ev));
*/

        /*LocationDAO= new LocationDAO(em);
        Location location= new Location(faker.beer().name(), faker.address().country());
        locationDAO.saveNewLocation(location);
        PersonDAO personDAO =new PersonDAO(em);
        EventDAO eventDAO= new EventDAO(em);
        Athlete athlete = new Athlete(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),faker.date().birthday(18,50), getRandomGenre.get(), faker.team().state());
        personDAO.saveNewPerson(athlete);
        AthleticCompetition athleticCompetition=new AthleticCompetition(faker.book().title(), LocalDate.of(new Random().nextInt(2020, 2030), new Random().nextInt(1,12), new Random().nextInt(1,30)), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get(), location);
        eventDAO.saveNewEvent(athleticCompetition);
        personDAO.saveNewPerson(randomPerson.get());

        eventDAO.setEventWinner(29, athlete);*/
        /*LocationDAO locationDAO= new LocationDAO(em);
        Location location= new Location(faker.beer().name(), faker.address().country());
        locationDAO.saveNewLocation(location);
        Concert concert=new Concert(faker.book().title(), LocalDate.of(new Random().nextInt(2020, 2030), new Random().nextInt(1,12), new Random().nextInt(1,30)), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get(), location, false, MusicalGenre.POP);
        Concert concert2=new Concert(faker.book().title(), LocalDate.of(new Random().nextInt(2020, 2030), new Random().nextInt(1,12), new Random().nextInt(1,30)), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get(), location, true, MusicalGenre.CLASSICAL);
        Concert concert3=new Concert(faker.book().title(), LocalDate.of(new Random().nextInt(2020, 2030), new Random().nextInt(1,12), new Random().nextInt(1,30)), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get(), location, false, MusicalGenre.ROCK);

        EventDAO eventDAO= new EventDAO(em);

        eventDAO.saveNewEvent(concert);
        eventDAO.saveNewEvent(concert2);
        eventDAO.saveNewEvent(concert3);*/

        EventDAO eventDAO= new EventDAO(em);
        List<Concert> concerts=new ArrayList<>(eventDAO.findByMusGenre(MusicalGenre.ROCK));
        System.out.println(concerts);
        List<Concert> concerts1=new ArrayList<>(eventDAO.findByStreaming(false));
        System.out.println(concerts1);

        em.close();
        emf.close();

    }


}
