package Oyun;

public class Karakterler {
	private String ad;
	private int id;
	private boolean aktif;
	
	public Karakterler(String ad, int id) {
		this.ad=ad;
		this.id=id;		
	}
	public boolean getAktif() {
		return aktif;
	}
	public void setAktif(boolean aktif) {
		this.aktif=aktif;
	}
	public int GetID() {
		return id;
	}
	

}
