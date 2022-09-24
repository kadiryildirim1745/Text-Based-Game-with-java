package Oyun;

import java.util.*;

public class OyunGorunumu {
	private OyunVerisi oyunVerisi= new OyunVerisi();
    private SavasMotoru savasMotoru =new SavasMotoru();//nesneleri olusturdum.
    
    
    public OyunGorunumu(){
        
    }
    
    public void baslangicEkrani(){//baslangýc ekranýnýn bastým.
    	//sovalyeAktiflestir();
    	//dusmanAktiflestir();
    	
    	System.out.println("*********************************");
    	System.out.println("Oyuna hoþ geldiniz.");
    	System.out.println("ANA MENU ");
    	System.out.println("1. Tüm þövalyeleri göster");
    	System.out.println("2. Aktif olan þövalyeleri göster");
    	System.out.println("3. Adý girilen þövalye bilgilerini göster");
    	System.out.println("4. Adý girilen þövalyeyi deðiþtir.");
    	System.out.println("5. Yardým");
    	System.out.println("6. Oyunu baþlat");
    	System.out.println("7. Oyundan çýk");
    	System.out.println("Lütfen seçiminizi yapýnýz: ");
    	
    	
    }
          
    public void anaMenuyuGoster(){
        //gerek olmadigi icin kullanmadim.
    }
    
    public void yardim(){
    	System.out.println("2) Þövalyeler:\r\n"+"Þövalyeler düþmanlarý yenerek deneyim kazanýrlar\n"+"Oyunun baþlangýcýnda rastgele seçilen 5 adet þövalye aktifleþtirilir.\n"+
    "Bunlardan en az biri en çok ikisi güçlü þövalye olmalýdýr."+"Her bir þövalyenin yalnýzca bir vuruþ hakký vardýr. Bir kez düþmana vuran þövalye yense de yenilse de aktif þövalyeler arasýndan çýkarýlýr."+
    			" Oyun baþladýktan sonra, hangi þövalyenin hangi düþmana vuracaðýna oyuncu karar vermelidir."+
    "Eðer oyuncu, aktif þövalyeleri bitmeden tüm düþmanlarý yok edebilirse oyunun galibi olur.Ancak düþman sayýsýndan daha az sayýda þövalye kaldýðý durumda, oyuncu oyunu kaybeder\n"+
    			"Þövalyelerin iki çeþidi vardýr:\n"+"Güçlü Þövalyeler: Güçlü þövalye, hem güçlü hem de zayýf düþmaný vurduðunda onu yok edebilir.\n"+
    "Zayýf Þövalyeler: Zayýf þövalye yalnýzca zayýf düþmana vurduðunda yok edebilir.Güçlü düþmana vurduðunda kendisi yok olur ancak düþmana bir zarar veremez.");
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
        	System.out.println("Sovalyenin Adýný Giriniz: ");
        	input.nextLine();
        	String bilgi= input.nextLine();
        	sovalyeyiGoster(oyunVerisi.getSovalye(bilgi));
        	
        }
        else if(secim==4) {//1. guclu sovalyeyi 2 tane zayif sovalyeyle degistirdim.

        	System.out.println("Güçlü Bir Sovalye Yerine 2 Tane Zayif Sovalye Ekleniyor... : ");

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


