package Oyun;
import java.util.*;

public class SavasMotoru {
	Scanner input= new Scanner(System.in);
	OyunVerisi oyunVerisi=new OyunVerisi();
	public SavasMotoru(){
		
	}
	public void Savastir(OyunVerisi oyunVerisi){//oyun verisi nesnesini methoda parametre olarak gönderdim.
		System.out.println("<<<<<<<SAVAS BASLIYOR>>>>>>>");
		System.out.println("***********");
		while((oyunVerisi.getAktifSovalyeler().size()>=oyunVerisi.getAktifDusmanlar().size()) && oyunVerisi.getAktifDusmanlar().size()!=0) {
			//while dongusu ile sinirliyorum. eger dusman sayisi fazla olursa veya dusman sayisi 0 olursa oyun bitiyor.
			System.out.println("Oyun Karakterleri ");
			System.out.println("***********");
			System.out.println("**************");
			System.out.println("Sovalyeler Ve Dusmanlar ");
			System.out.println("Sovalyeler: ");
			for(int i=0;i< oyunVerisi.getAktifSovalyeler().size();i++) {
				System.out.println(i+1+".Sovalye:");
				System.out.println("*********");//sovalyenin ozelliklerini bastim.
				System.out.println("Adý Ve Id'si: "+ oyunVerisi.getAktifSovalyeler().get(i).toString());
				System.out.println("Sovalye "+ oyunVerisi.getAktifSovalyeler().get(i).tipDondur());
				System.out.println("Vurus Hakki : "+ oyunVerisi.getAktifSovalyeler().get(i).getVurusHakki());
				System.out.println("***********");
				System.out.println("");

			}
			System.out.println("Dusmanlar: ");
			for(int i=0;i< oyunVerisi.getAktifDusmanlar().size();i++) {
				System.out.println(i+1+".Dusman:");
				System.out.println("*********");//dusmanin ozelliklerini bastim.
				System.out.println("Adý : "+ oyunVerisi.getAktifDusmanlar().get(i).getIsim());
				System.out.println("");

	
			}
			System.out.println("Kullanacaginiz Sovalyeyi Seciniz: ");
			int sovalye=input.nextInt()-1;
			System.out.println("Saldýracaginiz Dusmani Seciniz: ");
			int dusman=input.nextInt()-1;
			oyunVerisi.getAktifSovalyeler().get(sovalye).vur(oyunVerisi.getAktifDusmanlar().get(dusman),oyunVerisi.getAktifSovalyeler().get(sovalye));
			//"vur" metoduna aktif sovalyeleri ve aktif dusmanlari parametre olarak gönderdim

			for(int i=0;i< oyunVerisi.getAktifSovalyeler().size();i++) {
				if(oyunVerisi.getAktifSovalyeler().get(i).getCanlimi()==false) {
					oyunVerisi.getAktifSovalyeler().remove(i);//ölen sovalyeleri deaktif ettim
				}
			}
			for(int i=0;i< oyunVerisi.getAktifDusmanlar().size();i++) {
				if(oyunVerisi.getAktifDusmanlar().get(i).getCanlimi()==false) {
					oyunVerisi.getAktifDusmanlar().remove(i);//ölen dusmanlari deaktif ettim.
				}
			}
			
		}
		if(oyunVerisi.getAktifDusmanlar().size()==0) {
			System.out.println("");
			System.out.println("Tebrikler Oyunu Kazandiniz.");			
		}
		else if(oyunVerisi.getAktifDusmanlar().size()>oyunVerisi.getAktifSovalyeler().size()) {
			System.out.println("");
			System.out.println("Sovalye Sayisi Dusman Sayisindan Daha Az.");
			System.out.println("Maalesef Oyunu Kaybettiniz.");
		}
	}
	
}
