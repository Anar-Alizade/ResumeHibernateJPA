package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AbstractDao {

    private static EntityManagerFactory emf;

    public EntityManager em() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void closeEmf(EntityManager em) {
        em.close();
    }

}
