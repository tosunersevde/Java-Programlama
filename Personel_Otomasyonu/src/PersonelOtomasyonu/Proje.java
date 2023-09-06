package Odev1;

public class Proje {
	private int depNo;
	private int ProjeID=1;
	private String projeAd;
	private int projeSure;
	private int projeMaaliyet;
	private static int projeSayisi=0;
	
	public Proje(int depNo, String projeAd, int projeSure, int projeMaaliyet) {
		super();
		this.depNo = depNo;
		this.projeAd = projeAd;
		this.projeSure = projeSure;
		this.projeMaaliyet = projeMaaliyet;
		this.ProjeID = ++projeSayisi;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getProjeID() {
		return ProjeID;
	}

	public void setProjeID(int projeID) {
		ProjeID = projeID;
	}

	public String getProjeAd() {
		return projeAd;
	}

	public void setProjeAd(String projeAd) {
		this.projeAd = projeAd;
	}

	public int getProjeSure() {
		return projeSure;
	}

	public void setProjeSure(int projeSure) {
		this.projeSure = projeSure;
	}

	public int getProjeMaaliyet() {
		return projeMaaliyet;
	}

	public void setProjeMaaliyet(int projeMaaliyet) {
		this.projeMaaliyet = projeMaaliyet;
	}

	public static int getProjeSayisi() {
		return projeSayisi;
	}
	
}
