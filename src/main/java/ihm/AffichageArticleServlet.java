package ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bll.EntrepotManager;
import bo.Article;
import bo.Entrepot;
import bo.Stock;

/**
 * Servlet implementation class AffichageArticleServlet
 */
@WebServlet("/AffichageArticleServlet")
public class AffichageArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String next="WEB-INF/accueil.jsp";
		ArticleManager manager = new ArticleManager();
		List<Article> articles = manager.selectAll();
		
		EntrepotManager managerE = new EntrepotManager();
		List<Entrepot> entrepots = managerE.selectAll();
		
		System.out.println("Articles présents en BDD : ");
		for (Article current : articles) {
			System.out.println(current.getNom());
			System.out.println("------------");
		}
		
		Article premierArticle = articles.get(0);
		
		System.out.println("Informations du premier article :");
		for (Stock currentStock : premierArticle.getStocks()) {
			System.out.println("L'article est présent dans l'entrepot : " + currentStock.getEntrepot());
			System.out.println("En quantité : " + currentStock.getQuantite());
			System.out.println("------------");
		}
		
		if(request.getParameter("detail")!=null) {
			System.out.println("c'est cliqué");
			next="WEB-INF/detail.jsp";
		}
		request.setAttribute("att_articles", articles);
		request.setAttribute("att_entrepots", entrepots);
		request.getRequestDispatcher(next).forward(request, response);
//		request.getRequestDispatcher("WEB-INF/accueil2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Etape 1 : recuperer les infos envoyees par la jsp
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
//		Pays[] paysList = Pays.values();
//		request.setAttribute("att_listPays", paysList);
		Double surface = Double.parseDouble(request.getParameter("surface"));
		// Etape 2 : passer mes parametres dans le bon type
//		Float fPrix = Float.parseFloat(prix);
		// Etape 3 : soumettre les données au dao
//		Article article = new Article();
//		article.setNom(nom);
//		article.setPrix(fPrix);
//		article.setPaysDeProvenance(pays);
		
		Entrepot entrepot = new Entrepot();
		entrepot.setNom(nom);
		entrepot.setAdresse(adresse);
		entrepot.setSurface(surface);
		entrepot.setStocks(null);
		
		EntrepotManager managerE = new EntrepotManager();
		managerE.insertEntrepot(entrepot);
		
		doGet(request, response);
	}

}
