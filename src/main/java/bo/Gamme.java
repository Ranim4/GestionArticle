package bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Gamme {
	
	@Id @Column(name="id_gamme")
	private int id;
	private String valeurs;
	public int getId() {
		return id;
	}
	
	@OneToMany(mappedBy="gamme")
	private List<Article> articles = new ArrayList<>();
	
	public void setId(int id) {
		this.id = id;
	}
	public String getValeurs() {
		return valeurs;
	}
	public void setValeurs(String valeurs) {
		this.valeurs = valeurs;
	}
	@Override
	public String toString() {
		return "Gamme [id=" + id + ", valeurs=" + valeurs + "]";
	}

}
