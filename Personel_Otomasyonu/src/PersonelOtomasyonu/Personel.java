package Odev1;

public class Personel {
	private int depNo;
	private int perID=1;
	private String perAd;
	private String perSoyad;
	private int perYas;
	private static int personelSayi=0;
	
	public Personel(int depNo, String perAd, String perSoyad, int perYas) {
		super();
		this.depNo = depNo;
		this.perAd = perAd;
		this.perSoyad = perSoyad;
		this.perYas = perYas;
		this.perID = ++personelSayi;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getPerID() {
		return perID;
	}

	public void setPerID(int perID) {
		this.perID = perID;
	}

	public String getPerAd() {
		return perAd;
	}

	public void setPerAd(String perAd) {
		this.perAd = perAd;
	}

	public String getPerSoyad() {
		return perSoyad;
	}

	public void setPerSoyad(String perSoyad) {
		this.perSoyad = perSoyad;
	}

	public int getPerYas() {
		return perYas;
	}

	public void setPerYas(int perYas) {
		this.perYas = perYas;
	}

	public static int getPersonelSayi() {
		return personelSayi;
	}
	
}

