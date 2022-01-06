package ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bo.Article;
import dal.ArticleDAO;

/**
 * Servlet implementation class AffichageArticleServlet
 */
@WebServlet("/AffichageArticleServlet")
public class AffichageArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AffichageArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager manager = new ArticleManager();
		List<Article> articles = manager.selectAll();
		Article art = new Article();
		if (request.getParameter("ajouter") != null) {
			art.setId(5);
			String nom = request.getParameter("nom");
			art.setNom(nom);
			String pays = request.getParameter("pays");
			art.setPaysDeProvenance(pays);
			Float prix = Float.parseFloat(request.getParameter("prix"));
			art.setPrix(prix);
			System.out.println(art);
			request.setAttribute("nom", nom);
			request.setAttribute("pays", pays);
			request.setAttribute("prix", prix);
			// ArticleDAO.insert(art);
			manager.insertArticle(art);
		}
		request.setAttribute("att_articles", articles);
		request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
