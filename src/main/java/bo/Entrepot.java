package bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Entrepots")
public class Entrepot{

	@Id
	@Column(name = "id_entrepot")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom", length = 40)
	private String nom;
	@Column(name = "adresse", length = 150)
	private String adresse;
	private double surface;
	
	@OneToMany(mappedBy="entrepot")
	private List<Stock> stocks = new ArrayList<>();
	
	public Entrepot() {};
	
	public Entrepot(int id, String nom, String adresse, double surface, List<Stock> stocks) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.surface = surface;
		this.stocks = stocks;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Entrepot [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", surface=" + surface + "]";
	}

}
