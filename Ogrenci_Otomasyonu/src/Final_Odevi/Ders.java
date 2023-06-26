//Sevde Nur TOSUNER / 20010011044

package Final_Odevi;

public class Ders {
	private int dersId;
    private String dersAd;
    public static int sayac=1000;
    
	public Ders(String dersAd) {
		super();
		this.dersId = sayac;
		sayac +=10;
		this.dersAd = dersAd;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
	
}
