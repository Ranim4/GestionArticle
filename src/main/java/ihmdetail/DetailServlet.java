package ihmdetail;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bll.EntrepotManager;
import bll.GammeManager;
import bo.Article;
import bo.Ecran;
import bo.Entrepot;
import bo.Gamme;
import bo.Meuble;
import bo.Stock;
import ihm.Pays;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idEntrepot = Integer.valueOf(request.getParameter("id_entrepot"));
		
		EntrepotManager eManager = new EntrepotManager();
		Entrepot entrepot = eManager.selectById(idEntrepot);
		
		GammeManager gManager = new GammeManager();
		
		request.setAttribute("att_entrepot", entrepot);
		request.setAttribute("pays", Pays.values());
		request.setAttribute("gammes", gManager.selectAll());
		request.getRequestDispatcher("WEB-INF/detail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntrepotManager em = new EntrepotManager();
		ArticleManager am = new ArticleManager();
		GammeManager gm = new GammeManager();
		
		int idEntrepot = Integer.parseInt(request.getParameter("id_entrepot"));
		Entrepot e = em.selectById(idEntrepot);
		
		String nom = request.getParameter("nom");
		Float prix = Float.parseFloat(request.getParameter("prix"));
		Pays pays = Pays.valueOf(request.getParameter("pays"));
		Gamme gamme = gm.selectById(Integer.parseInt(request.getParameter("gamme")));
		String type = request.getParameter("type");
		
		Stock s = new Stock();
		s.setEntrepot(e);
		s.setQuantite(1);
		
		switch (type) {
		case "meuble": {
			int longueur = Integer.parseInt(request.getParameter("longueur"));
			int largeur = Integer.parseInt(request.getParameter("largeur"));
			int hauteur = Integer.parseInt(request.getParameter("hauteur"));
			
			Meuble m = new Meuble();
			m.setNom(nom);
			m.setPrix(prix);
			m.setPaysDeProvenance(pays);
			m.setLongueur(longueur);
			m.setLargeur(largeur);
			m.setHauteur(hauteur);	
			m.setDate(LocalDate.now());
			
			m.setGamme(gamme);
			s.setArticle(m);
			
			am.insertArticle(m, s);
			break;
		}
		case "ecran": {
			boolean hdmi = Boolean.parseBoolean(request.getParameter("hdmi"));
			boolean vga = Boolean.parseBoolean(request.getParameter("vga"));
			String frequence = request.getParameter("frequence");
			
			Ecran ecran = new Ecran();
			ecran.setNom(nom);
			ecran.setPrix(prix);
			ecran.setPaysDeProvenance(pays);
			ecran.setHDMI(hdmi);
			ecran.setVGA(vga);
			ecran.setFrequence(frequence);		
			ecran.setGamme(gamme);
			ecran.setDate(LocalDate.now());
			
			s.setArticle(ecran);
			
			am.insertArticle(ecran, s);
			break;
		}
		}
		doGet(request, response);
	}


}
