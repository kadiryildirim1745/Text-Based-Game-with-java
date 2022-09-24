package Oyun;
import java.util.*;

public class OyunVerisi {

	private ArrayList<Sovalye> sovalyeler = new ArrayList<>();
	private ArrayList<Sovalye> AktifSovalyeler = new ArrayList<>();
	private	ArrayList<Dusman> dusmanlar = new ArrayList<>();//ArrayList'ten nesne olusturdum.
	private	ArrayList<Dusman> AktifDusmanlar = new ArrayList<>();

	public OyunVerisi() {
		
		GucluSovalye sovalye1 = new GucluSovalye("Ali",1); 
		sovalyeler.add(sovalye1);
		GucluSovalye sovalye2 = new GucluSovalye("Ahmet",1); 
		sovalyeler.add(sovalye2);
		ZayifSovalye sovalye3 = new ZayifSovalye("Murat",2); //Sovalyeleri olusturdum ve "sovalyeler" listesine ekledim.
		sovalyeler.add(sovalye3);
		ZayifSovalye sovalye4 = new ZayifSovalye("Suat",2); 
		sovalyeler.add(sovalye4);
		ZayifSovalye sovalye5 = new ZayifSovalye("Fýrat",2); 
		sovalyeler.add(sovalye5);
		ZayifSovalye sovalye6 = new ZayifSovalye("Vedat",2); 
		sovalyeler.add(sovalye6);
		ZayifSovalye sovalye7 = new ZayifSovalye("Levent",2);
		sovalyeler.add(sovalye7);
		ZayifSovalye sovalye8 = new ZayifSovalye("Veli",2);
		sovalyeler.add(sovalye8);
		
		
		GucluDusman dusman1 = new GucluDusman("John",1); 
		dusmanlar.add(dusman1);
		GucluDusman dusman2 = new GucluDusman("William",1); 
		dusmanlar.add(dusman2);
		ZayifDusman dusman3 = new ZayifDusman("Lewis",2);//Dusmanlarý olusturdum ve "Dusmanlar" listesine ekledim. 
		dusmanlar.add(dusman3);
		ZayifDusman dusman4 = new ZayifDusman("Max",2);
		dusmanlar.add(dusman4);
		ZayifDusman dusman5 = new ZayifDusman("Sebastian",2);
		dusmanlar.add(dusman5);
		ZayifDusman dusman6 = new ZayifDusman("Luca",2);
		dusmanlar.add(dusman6);

	}

	public Sovalye getSovalye(String ad) {//Kullanýcýdan alýnan veriye gore sovalye dondurme metodu.
		
		int sayac = 0;
		
		for(int i=0;i<sovalyeler.size();i++) {
			if (sovalyeler.get(i).getAd().equals(ad))
				sayac= i;
		}
		
		return sovalyeler.get(sayac);
				
	}
	
	public ArrayList<Sovalye> getSovalyeler() {
		return sovalyeler;//sovalye listesi döndürür.
	}
	
	public ArrayList<Sovalye> getAktifSovalyeler() {
		return AktifSovalyeler;//aktif sovalye listesi döndürür.
	}
	
	public ArrayList<Dusman> getDusmanlar() {
		return dusmanlar;//dusman listesi döndürür.
	}

	public ArrayList<Dusman> getAktifDusmanlar() {
		return AktifDusmanlar;//aktif dusman listesi döndürür.
	}
	

	
}