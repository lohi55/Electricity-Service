package com.powerx.renpower.utilitywebservice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class is used to create a session.
 * @author Lohith Thota
 */
@SuppressWarnings("deprecation")
public class HIbernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
