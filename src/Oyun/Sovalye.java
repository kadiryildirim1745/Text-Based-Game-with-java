package Oyun;

public class Sovalye extends Karakterler {
	private boolean durum=true;
	private int vurusHakki=1;
	private String sovalyeTipi;
	private String ad;
	private int id;
	
	public Sovalye(String ad, int id) {
		super(ad,id);
		this.ad=ad;
		this.id=id;
		if (id==1)
			this.sovalyeTipi="Guçlu Sovalye";
		else if (id==2)
			this.sovalyeTipi="Zayif Sovalye";
	}
	public String tipDondur(){
		return sovalyeTipi;
	}
	
	public String getAd() {
		return ad;
	}
	public int getid() {
		return id;
	}
	
	
	public int getVurusHakki() {
		return vurusHakki;
	}
	
	public void setVurusHakki() {
		
		
	}
	public void setCanlimi(boolean durum) {
		this.durum=durum;
	}
	public boolean getCanlimi() {
		return durum;
	}
	
	public void vur(Dusman d,Sovalye s) {//dusman ve sovalyeyi parametre olarak attim
		if(s.getid()==1) {//sovalye guclu ise kazandi
			setCanlimi(false);
			d.setCanlimi(false);
			System.out.println("Guclu Sovalye ile Zayif Dusmana Vurdunuz");
			System.out.println("Hedef Yok Edildi");
			System.out.println("Oyun Devam Ediyor");
			System.out.println("");

		}
		else if(s.getid()==2 &&d.GetID()==2) {
			setCanlimi(false);//ikisi de zayif ise sovalye kazandi
			d.setCanlimi(false);
			System.out.println("Zayif Sovalye ile Zayif Dusmana Vurdunuz");
			System.out.println("Hedef Yok Edildi");
			System.out.println("Oyun Devam Ediyor");
			System.out.println("");

		}
		else if(s.getid()==2 &&d.GetID()==1) {
			setCanlimi(false);
			d.setCanlimi(true);//dusman guclu ise dusman kazandi
			System.out.println("Zayif Sovalye ile Guclu Dusmana Vurdunuz");
			System.out.println("Hedef Hala Hayatta");
			System.out.println("Oyun Devam Ediyor");
			System.out.println("");

		}
		
	}
	public void tipDegistir() {
		sovalyeTipi="zayifSovalye";
	}
	
	public String toString() {
		return "ismi : "+ ad +", Id'si: "+id+"   ";
	}
	
}
