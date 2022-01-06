package dal;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Entrepot;

public class EntrepotDAO {
	
	private static Session session;
	
	public EntrepotDAO() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory fatory = meta.getSessionFactoryBuilder().build();
		session = fatory.openSession();
	}
	
	public static List<Entrepot> selectAll() {
		return session.createQuery("from Entrepot", Entrepot.class).list();
	}
	
	public static Entrepot selectById(int id) {
		return session.find(Entrepot.class, id);
	}
	
	public static Entrepot selectByName(String nom) {
		return session.createQuery("from Entrepot where nom = :param_nom", Entrepot.class)
							.setParameter("param_nom", nom)
							.getSingleResult();
	}
	
	public static void insert(Entrepot entrepot) {
		Transaction t = session.beginTransaction();
		try {
			session.save(entrepot);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void update(Entrepot entrepot) {
		Transaction t = session.beginTransaction();
		try {
			session.update(entrepot);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void delete(Entrepot entrepot) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(entrepot);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}


}
