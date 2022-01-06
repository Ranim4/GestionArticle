package bll;

import java.util.List;

import bo.Article;
import dal.ArticleDAO;

public class ArticleManager {
	
	private ArticleDAO dao;
	
	public ArticleManager() {
		dao = new ArticleDAO();
	}
	
	public List<Article> selectAll(){
		return dao.selectAll();
	}
	
	public void insertArticle(Article article){
		dao.insert(article);
	}

}
