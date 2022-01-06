package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "Articles")
public class Article {

	@Id @Column(name = "id_article")
	private int id;

	private String nom;

	private float prix;

	private String paysDeProvenance;

	public Article () {}
	
	public Article(String nom, float prix, String paysDeProvenance) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.paysDeProvenance = paysDeProvenance;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getPaysDeProvenance() {
		return paysDeProvenance;
	}

	public void setPaysDeProvenance(String paysDeProvenance) {
		this.paysDeProvenance = paysDeProvenance;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", prix=" + prix + ", paysDeProvenance=" + paysDeProvenance + "]";
	}

}
