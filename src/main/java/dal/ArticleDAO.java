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

import bo.Article;
import bo.Stock;

public class ArticleDAO {
	
	private static Session session;
	
	public ArticleDAO() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory fatory = meta.getSessionFactoryBuilder().build();
		session = fatory.openSession();
	}
	
	public static List<Article> selectAll() {
		return session.createQuery("from Article", Article.class).list();
	}
	
	public static Article selectById(int id) {
		return session.find(Article.class, id);
	}
	
	public static Article selectByName(String nom) {
		return session.createQuery("from Article where nom = :param_nom", Article.class)
							.setParameter("param_nom", nom)
							.getSingleResult();
	}
	
	public static void insert(Article article, Stock stock) {
		Transaction t = session.beginTransaction();
		try {
			session.save(article);
			session.save(stock);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void update(Article article) {
		Transaction t = session.beginTransaction();
		try {
			session.update(article);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void delete(Article article) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(article);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}

}
