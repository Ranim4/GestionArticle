package bo;

import javax.persistence.*;

@Entity @Table(name="asso_entrepot_article")
public class Stock {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_entrepot",
				foreignKey = @ForeignKey(name="FK_stock_entrepot"))
	private Entrepot entrepot;
	
	@ManyToOne
	@JoinColumn(name="id_article",
				foreignKey = @ForeignKey(name="FK_stock_article"))
	private Article article;
	
	@Column(name="quantite")
	private int quantite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Entrepot getEntrepot() {
		return entrepot;
	}

	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
