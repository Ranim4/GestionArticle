package bo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Meuble extends Article{
	
	private float largeur;
	private float longueur;
	private float hauteur;
	
	public Meuble() {
	}
	
	public float getLargeur() {
		return largeur;
	}
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}
	public float getLongueur() {
		return longueur;
	}
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}
	public float getHauteur() {
		return hauteur;
	}
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	@Override
	public String toString() {
		return "Meuble [largeur=" + largeur + ", longueur=" + longueur + ", hauteur=" + hauteur + "]";
	}

	@Override
	public String getDetails() {
		String result = "Meuble, Dimensions : "+ largeur+"x"+longueur+"x"+hauteur;
		return result;
	}

}
