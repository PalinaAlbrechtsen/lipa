package bye.kosha.util;

import bye.kosha.dao.entity.Address;
import bye.kosha.dao.entity.City;
import bye.kosha.dao.entity.Country;
import bye.kosha.dao.entity.Gender;
import bye.kosha.dao.entity.Param;
import bye.kosha.dao.entity.Program;
import bye.kosha.dao.entity.Purchase;
import bye.kosha.dao.entity.Role;
import bye.kosha.dao.entity.Subscriber;
import bye.kosha.dao.entity.Subtopic;
import bye.kosha.dao.entity.Theme;
import bye.kosha.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataUtil {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DataUtil(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Country").executeUpdate();
        entityManager.createQuery("delete from City").executeUpdate();
        entityManager.createQuery("delete from Subscriber").executeUpdate();
        entityManager.createQuery("delete from Param").executeUpdate();
        entityManager.createQuery("delete from Purchase").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Country belarus = new Country("Belarus");
        Country denmark = new Country("Denmark");
        entityManager.persist(belarus);
        entityManager.persist(denmark);

        City minsk = new City("Minsk", belarus);
        City christianshavn = new City("Christinshavn", denmark);
        entityManager.persist(minsk);
        entityManager.persist(christianshavn);

        Address minBel = new Address(belarus.getId(), minsk.getId());
        Address chrDK = new Address(denmark.getId(), christianshavn.getId());

        Role admin = new Role("Admin");
        entityManager.persist(admin);

        User philUser = new User("phil@mail", "pass");
        User thomasUser = new User("thom@mail", "password");
        entityManager.persist(philUser);
        entityManager.persist(thomasUser);
        Subscriber tsipa = new Subscriber("Tsipa", LocalDate.of(2014, 6, 12), Gender.MALE, minBel);
        entityManager.persist(tsipa);
        entityManager.persist(new User("mail", "1234", admin, tsipa));


        Subscriber phil = new Subscriber(philUser, "Phil", LocalDate.of(1993, 10, 5), Gender.MALE, minBel);
        Subscriber thomas = new Subscriber(thomasUser, "Thomas", LocalDate.of(1987, 5, 23), Gender.MALE, chrDK);
        entityManager.persist(phil);
        entityManager.persist(thomas);

        Param philParam = new Param(phil, LocalDate.now(), 187, new BigDecimal(78.2));
        Param philParam2 = new Param(phil, LocalDate.now().minusMonths(6), 187, new BigDecimal(76.7));
        Param tomParam = new Param(thomas, LocalDate.now(), 185, new BigDecimal(72.4));
        entityManager.persist(philParam);
        entityManager.persist(philParam2);
        entityManager.persist(tomParam);


        Program programOne = new Program("Program One", "Program One Description", new BigDecimal(24.3));
        Program programTwo = new Program("Program Two", "Program Two Description", new BigDecimal(42.1));
        entityManager.persist(programOne);
        entityManager.persist(programTwo);


        Purchase firstPurchase = new Purchase(LocalDate.now(), phil, programOne);
        Purchase secondPurchase = new Purchase(LocalDate.now(), phil, programTwo);
        entityManager.persist(firstPurchase);
        entityManager.persist(secondPurchase);

        Theme themeOne = new Theme("Theme One");
        entityManager.persist(themeOne);

        entityManager.persist(new Subtopic("First subtopic", "First text", themeOne));
        entityManager.persist(new Subtopic("Second subtopic", "Second text", themeOne));
//
//        entityManager.persist(new Movie("Gran Torino", 2008, Genre.DRAMA, eastwoodDirector));
//        entityManager.persist(new Movie("Million Dollar Baby", 2004, Genre.DRAMA, eastwoodDirector));
//        entityManager.persist(new Movie("Mystic River", 2003, Genre.THRILLER, eastwoodDirector));
//
//        entityManager.persist(new Movie("Gladiator", 2000, Genre.ACTION, scottDirector));
//        entityManager.persist(new Movie("Alien", 1979, Genre.HORROR, scottDirector));
//        entityManager.persist(new Movie("The Martian", 2015, Genre.COMEDY, scottDirector));
//        entityManager.persist(new Movie("Blade Runner", 1982, Genre.SCIENCE_FICTION, scottDirector));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
