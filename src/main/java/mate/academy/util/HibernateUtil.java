package mate.academy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory instance;

    static {
        try {
            instance = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println(" Hibernate SessionFactory init failed: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return instance;
    }
}
