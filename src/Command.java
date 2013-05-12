import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Command implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ElementCollection
    List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) {
        Command command = new Command();

        EntityManager em = Persistence
                .createEntityManagerFactory("profileService")
                .createEntityManager();
        em.getTransaction().begin();
        em.persist(command);
        em.getTransaction().commit();
        em.close();

        System.out.println("Persisted with id=" + command.id);
    }
}