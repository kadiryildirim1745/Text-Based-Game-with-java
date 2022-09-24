package Oyun;

import java.util.*;

public class OyunGorunumu {
	private OyunVerisi oyunVerisi= new OyunVerisi();
    private SavasMotoru savasMotoru =new SavasMotoru();//nesneleri olusturdum.
    
    
    public OyunGorunumu(){
        
    }
    
    public void baslangicEkrani(){//baslang�c ekran�n�n bast�m.
    	//sovalyeAktiflestir();
    	//dusmanAktiflestir();
    	
    	System.out.println("*********************************");
    	System.out.println("Oyuna ho� geldiniz.");
    	System.out.println("ANA MENU ");
    	System.out.println("1. T�m ��valyeleri g�ster");
    	System.out.println("2. Aktif olan ��valyeleri g�ster");
    	System.out.println("3. Ad� girilen ��valye bilgilerini g�ster");
    	System.out.println("4. Ad� girilen ��valyeyi de�i�tir.");
    	System.out.println("5. Yard�m");
    	System.out.println("6. Oyunu ba�lat");
    	System.out.println("7. Oyundan ��k");
    	System.out.println("L�tfen se�iminizi yap�n�z: ");
    	
    	
    }
          
    public void anaMenuyuGoster(){
        //gerek olmadigi icin kullanmadim.
    }
    
    public void yardim(){
    	System.out.println("2) ��valyeler:\r\n"+"��valyeler d��manlar� yenerek deneyim kazan�rlar\n"+"Oyunun ba�lang�c�nda rastgele se�ilen 5 adet ��valye aktifle�tirilir.\n"+
    "Bunlardan en az biri en �ok ikisi g��l� ��valye olmal�d�r."+"Her bir ��valyenin yaln�zca bir vuru� hakk� vard�r. Bir kez d��mana vuran ��valye yense de yenilse de aktif ��valyeler aras�ndan ��kar�l�r."+
    			" Oyun ba�lad�ktan sonra, hangi ��valyenin hangi d��mana vuraca��na oyuncu karar vermelidir."+
    "E�er oyuncu, aktif ��valyeleri bitmeden t�m d��manlar� yok edebilirse oyunun galibi olur.Ancak d��man say�s�ndan daha az say�da ��valye kald��� durumda, oyuncu oyunu kaybeder\n"+
    			"��valyelerin iki �e�idi vard�r:\n"+"G��l� ��valyeler: G��l� ��valye, hem g��l� hem de zay�f d��man� vurdu�unda onu yok edebilir.\n"+
    "Zay�f ��valyeler: Zay�f ��valye yaln�zca zay�f d��mana vurdu�unda yok edebilir.G��l� d��mana vurdu�unda kendisi yok olur ancak d��mana bir zarar veremez.");
    	baslangicEkrani();
    	menudenSecimYap();
    }
    	
    public void sovalyeleriGoster(){//sovalyeleri gosteren method.
    	
    	System.out.print(oyunVerisi.getSovalyeler());
    	System.out.println(oyunVerisi.getAktifSovalyeler());
    	baslangicEkrani();
    	menudenSecimYap();
    }
    public void aktifSovalyeleriGoster(){//aktif sovalyeleri gosteren method
    	System.out.println(oyunVerisi.getAktifSovalyeler());
    	baslangicEkrani();
    	menudenSecimYap();
    }
    
    public void menudenSecimYap(){//if else yapisiyla kullanicidan aldigim bilgiye gore menuyu calistirdim
    	Scanner input= new Scanner(System.in);
	    int secim=input.nextInt();
        
	    if(secim==1) {
        	sovalyeleriGoster();
	    	
	    }
        else if (secim==2) {
        	//sovalyeAktiflestir();
	    	aktifSovalyeleriGoster();
        }
        else if (secim==3) {//secilen sovalyenin bilgisini bastim
        	System.out.println("Sovalyenin Ad�n� Giriniz: ");
        	input.nextLine();
        	String bilgi= input.nextLine();
        	sovalyeyiGoster(oyunVerisi.getSovalye(bilgi));
        	
        }
        else if(secim==4) {//1. guclu sovalyeyi 2 tane zayif sovalyeyle degistirdim.

        	System.out.println("G��l� Bir Sovalye Yerine 2 Tane Zayif Sovalye Ekleniyor... : ");

    		oyunVerisi.getSovalyeler().get(0).setAktif(false);//1. sovalye deaktif ediliyor.
    		oyunVerisi.getAktifSovalyeler().remove(oyunVerisi.getAktifSovalyeler().get(0));
    		for(int i=1;i<oyunVerisi.getSovalyeler().size();i++) {
    			if((oyunVerisi.getSovalyeler().get(i).getAktif()==false) &&( oyunVerisi.getSovalyeler().get(i).getid()==2)) {
    				oyunVerisi.getSovalyeler().get(i).setAktif(true);//zayif sovalyeler seciliyor.
    				oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(i));
    			}
    		}
    		aktifSovalyeleriGoster();
        }
        else if(secim==5) {
        	yardim();
        }
        else if(secim==6) {
        	//sovalyeAktiflestir();//aktiflestirme yaptim.
        	//oyunVerisi.getAktifSovalyeler().remove(oyunVerisi.getAktifSovalyeler().get(0));
        	dusmanAktiflestir();
        	savasMotoru.Savastir(oyunVerisi);
        }
        else if (secim==7){
        	System.exit(0);
        }
    		
    		
    }
    
    public void sovalyeAktiflestir() {
    	oyunVerisi.getSovalyeler().get(0).setAktif(true);//ilk sovalye direkt guclu yapiliyor.
    	oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(0));
    	oyunVerisi.getSovalyeler().remove(0);//tekrar eklememek icin deaktif ediliyor.
    	int carpan=7;
    	for(int i=1;i<=4;i++) {
    		int x=(int)(Math.random()*carpan);//geri kalan 4 sovalye random dolduruluyor.
    		carpan--;
        	oyunVerisi.getSovalyeler().get(x).setAktif(true);
        	oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(x)); 
        	oyunVerisi.getSovalyeler().remove(x);
        	
    	}
    }
    public void dusmanAktiflestir() {
    	oyunVerisi.getDusmanlar().get(0).setAktif(true);//ilk dusman direkt guclu yapiliyor.
    	oyunVerisi.getAktifDusmanlar().add(oyunVerisi.getDusmanlar().get(0));
    	oyunVerisi.getDusmanlar().remove(0);//tekrar eklememek icin deaktif ediliyor.
    	int carpan=5;
    	for(int i=1;i<=4;i++) {
    		int x=(int)(Math.random()*carpan);//geri kalan 4 dusman random dolduruluyor.
    		carpan--;
        	oyunVerisi.getDusmanlar().get(x).setAktif(true);
        	oyunVerisi.getAktifDusmanlar().add(oyunVerisi.getDusmanlar().get(x)); 
        	oyunVerisi.getDusmanlar().remove(x);    
    	}
    }
    
    public void sovalyeyiGoster(Sovalye s){//sovalye bilgisi basiliyor.
    	System.out.println(s.toString()+ ", Vurus Hakki: " + s.getVurusHakki()+" , " + s.tipDondur());
    	baslangicEkrani();
    	menudenSecimYap();
        
    }
    public void oyunDurumunuGoster(ArrayList<Dusman> dusmanlar, ArrayList<Sovalye> sovalyeler ){
        //gerek olmadigi icin kullanmadim.
    }
    
}


