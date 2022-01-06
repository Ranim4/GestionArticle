package bll;

import java.util.List;

import bo.Article;
import bo.Stock;
import dal.ArticleDAO;

public class ArticleManager {
	
	private ArticleDAO dao;
	
	public ArticleManager() {
		dao = new ArticleDAO();
	}
	
	public List<Article> selectAll(){
		return ArticleDAO.selectAll();
	}
	
	public void insertArticle(Article article, Stock stock){
		ArticleDAO.insert(article, stock);
	}
	
	public Article selectById(int id){
		return ArticleDAO.selectById(id);
	}
}
