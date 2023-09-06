package Odev1;

public class Departman {
	private int depNo;
	private String depAd;
	public Personel[] personeller;
	public Proje[] projeler;
	private static int departmanSayi=0;
	
	public Departman(int depNo, String depAd) {
		super();
		this.depNo = depNo;
		this.depAd = depAd;
		this.depNo = ++departmanSayi;
	}
	
	public Departman(int depNo, String depAd, Personel[] personeller, Proje[] projeler) {
		super();
		this.depNo = depNo;
		this.depAd = depAd;
		this.personeller = personeller;
		this.projeler = projeler;
	}
	
	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public String getDepAd() {
		return depAd;
	}

	public void setDepAd(String depAd) {
		this.depAd = depAd;
	}

	public Personel[] getPersoneller() {
		return personeller;
	}

	public void setPersoneller(Personel[] personeller) {
		this.personeller = personeller;
	}

	public Proje[] getProjeler() {
		return projeler;
	}

	public void setProjeler(Proje[] projeler) {
		this.projeler = projeler;
	}
		
}
