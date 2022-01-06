package bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ihm.Pays;

@Entity
@Table(name = "Articles") @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Article {

	@Id
	@Column(name = "id_article")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom", length = 30)
	private String nom;

	private float prix;

	@Enumerated(EnumType.STRING)
	@Column(name = "pays", length = 30)
	private Pays paysDeProvenance;

	@Column(name = "date_de_production")
	private LocalDate date;

	/*@ManyToMany
    @JoinTable( name="asso_article_enterpot", 
    			joinColumns=@JoinColumn(name="id_article", referencedColumnName="id_article"),
    			inverseJoinColumns=@JoinColumn(name="id_enterpot", referencedColumnName="id_enterpot"),
    			uniqueConstraints =@UniqueConstraint(columnNames = {"id_article", "id_enterpot"}, name = "id"))
	private List<Enterpot> enterpots = new ArrayList<>();*/
	@OneToMany(mappedBy="article")
	private List<Stock> stocks = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="id_gamme",
				foreignKey = @ForeignKey(name="FK_article_gamme"))
	private Gamme gamme;
	
	public Article() {
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

	public Pays getPaysDeProvenance() {
		return paysDeProvenance;
	}

	public void setPaysDeProvenance(Pays paysDeProvenance) {
		this.paysDeProvenance = paysDeProvenance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public Gamme getGamme() {
		return gamme;
	}

	public void setGamme(Gamme gamme) {
		this.gamme = gamme;
	}

	public abstract String getDetails();

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", prix=" + prix + ", paysDeProvenance=" + paysDeProvenance
				+ ", date=" + date + "]";
	}

}
