package bo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Ecran extends Article{
	
	private boolean HDMI;
	private boolean VGA;
	private String frequence;
	
	public Ecran() {}
	
	public boolean isHDMI() {
		return HDMI;
	}
	public void setHDMI(boolean hDMI) {
		HDMI = hDMI;
	}
	public boolean isVGA() {
		return VGA;
	}
	public void setVGA(boolean vGA) {
		VGA = vGA;
	}
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	@Override
	public String toString() {
		return "Ecran [HDMI=" + HDMI + ", VGA=" + VGA + ", frequence=" + frequence + "]";
	}

	@Override
	public String getDetails() {
		return "Ecran [HDMI=" + HDMI + ", VGA=" + VGA + ", frequence=" + frequence + "]";
	}

}
