package impl;

import dao.AbstractDao;
import entity.User;
import jakarta.persistence.*;

import java.util.List;

public class UserDaoImpl {

    //JPQL
    public List<User> getAll(String name, String surname, Integer nationalityID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        String jpql = "select u from User u";

        if(name != null && !name.trim().isEmpty()) {
            jpql += " and u.name= :name ";
        }
        if(surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname= :surname ";
        }
        if(nationalityID != null) {
            jpql += " and u.nationality.id= :nid ";
        }

        Query q = entityManager.createQuery(jpql, User.class);

        if(name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if(surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if(nationalityID != null) {
            q.setParameter("nid", nationalityID);
        }

        return q.getResultList();
    }



    public User getById(int userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        User u = entityManager.find(User.class, userId);

        abs.closeEmf(entityManager);
        return u;
    }

    //JPQL
    public User findByEmailAndPassword(String email, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        Query q = entityManager.createQuery("select u from User u where u.email= :e and u.password= :p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);

        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //JPQL
    public User findByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        Query q = entityManager.createQuery("select u from User u where u.email= :e", User.class);
        q.setParameter("e", email);

        List<User> list = q.getResultList();
        if(list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    AbstractDao abs = new AbstractDao();

    public boolean removeUser(int userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        User u = entityManager.find(User.class, userId);

        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();

        abs.closeEmf(entityManager);
        return true;
    }

    public boolean updateUser(User u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(u);
        entityManager.getTransaction().commit();

        abs.closeEmf(entityManager);
        return true;
    }

    public boolean addUser(User u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();

        abs.closeEmf(entityManager);
        return true;
    }

}
