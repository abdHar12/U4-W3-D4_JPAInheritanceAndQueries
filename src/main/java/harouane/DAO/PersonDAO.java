package harouane.DAO;

import harouane.Entities.Event;
import harouane.Entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonDAO {
    EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }
    public void saveNewPerson(Person person){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("Persona "+ person.getFirstName() + " " + person.getLastName()+"salvata correttamente");
    }

    public void setNewEventsList(Person person, List<Event> events){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        person.setEvents(events);
        transaction.commit();
    }
    public Person getPersonById(long id){
        return em.find(Person.class, id);
    }

}
