package harouane.DAO;

import harouane.Entities.Event;
import harouane.Entities.Eventi.AthleticCompetition;
import harouane.Entities.Eventi.Concert;
import harouane.Entities.Persons.Athlete;
import harouane.enums.MusicalGenre;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventDAO {
private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }
    public void saveNewEvent(Event event){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("Evento \'"+ event.getTitle()+"\' salvato correttamente");
    }

    public Event getEventById(long id){
        return em.find(Event.class, id);
    }

    public void setEventWinner(long id, Athlete winner){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        AthleticCompetition event= (AthleticCompetition) this.getEventById(id);
        event.setWinner(winner);
        transaction.commit();
    }

    public void setMusicalGenre(long id, MusicalGenre genre){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Concert event= (Concert) this.getEventById(id);
        event.setMusicalGenre(genre);
        transaction.commit();
    }

    public List<Concert> findByMusGenre(MusicalGenre genre){
        TypedQuery<Concert> getAllQuery= em.createQuery("SELECT c FROM Concert c WHERE c.musicalGenre = :genre", Concert.class);
        getAllQuery.setParameter("genre", genre);
        return getAllQuery.getResultList();
    }

    public List<Concert> findByStreaming(boolean streaming){
        TypedQuery<Concert> getAllQuery= em.createQuery("SELECT c FROM Concert c WHERE c.streaming = :streaming", Concert.class);
        getAllQuery.setParameter("streaming", streaming);
        return getAllQuery.getResultList();
    }

    public void deleteById(long id){
        EntityTransaction transaction=em.getTransaction();
        Event found=getEventById(id);
        if(found!=null){
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Elemento cancellato con successo!");
        }else System.out.println("Elemento non trovato, quindi non cancellato!");
    }

}
