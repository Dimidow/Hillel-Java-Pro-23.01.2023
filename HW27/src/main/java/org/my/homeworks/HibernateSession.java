package org.my.homeworks;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSession {

    private static final Logger logger = LoggerFactory.getLogger(HibernateSession.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
 /* HW27. Task text. #3 "...та список класів з анотаціями Entity." This code works without this point.
 So here it`s presented only as commented line - redundant part.
            configuration.addAnnotatedClass(org.my.homeworks.Student.class); */
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            logger.info("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}