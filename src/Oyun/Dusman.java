package Oyun;

public class Dusman extends Karakterler {
	private boolean durum=true;
	private String dusmanTipi;
	private String ad;
	
	public Dusman(String ad, int id) {
		super(ad,id);
		this.ad=ad;
		if (id==1)
			dusmanTipi="Guçlu Dusman";//id ile guclu-zayif belirledim
		else if (id==2)
			dusmanTipi="Zayif Dusman";
	}
	public String getIsim() {
		return ad;
	}
	public void setCanlimi(boolean durum) {
		this.durum=durum;
	}
	public boolean getCanlimi() {
		return durum;
	}
	

}
