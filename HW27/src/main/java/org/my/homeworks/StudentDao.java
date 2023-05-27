package org.my.homeworks;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentDao implements Dao<Student, Integer> {


    private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);

    private final SessionFactory sessionFactory;

    public StudentDao() {
        sessionFactory = HibernateSession.getSessionFactory();
    }

    @Override
    public void add(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }


    @Override
    public List<Student> getAllEntities() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            logger.info("Error during getting all entities" + e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student getEntityById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            logger.info("Error during getting entity by ID" + e);
            e.printStackTrace();
            return null;
        }
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            try {
                transaction.rollback();
            } catch (Exception e) {
                logger.info("Error during rolling back transaction " + e);
                e.printStackTrace();
            }
        }
    }
}
