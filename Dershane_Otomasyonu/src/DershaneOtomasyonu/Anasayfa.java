package Final_Odevi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
		ArrayList<Ders> dersler = new ArrayList<Ders>();
		
		ArrayList<Ders> alinanDersler = new ArrayList<Ders>();
		
		String okunan_veri;
		String[] parca_veri;
		
		int kontrol = 0;
		
		int ders_id = 0,ogrenci_id = 0,ogrenci_yas = 0,enBuyukOgrenciId=0;
		String ders_ad,ogrenci_adsoyad = null;
		
		
		File myFile2 = new File("ders.txt");
		if(!myFile2.exists())
		{
			myFile2.createNewFile();
			System.out.println("Dosya Bulunamadi! Yeni Dosya Olusturuldu!");
		}
		else 
		{
			FileReader fr2 = new FileReader(myFile2);
			BufferedReader br2 = new BufferedReader(fr2);
			
			while((okunan_veri = br2.readLine())!=null) {
				parca_veri = okunan_veri.split("%");
				
				dersler.add(new Ders( parca_veri[1]));
			}
			
			fr2.close();
			br2.close();
		}
		
		File myFile1 = new File("ogrenci.txt");
		if(!myFile1.exists())
		{
			myFile1.createNewFile();
			System.out.println("Dosya Bulunamadi! Yeni Dosya Olusturuldu!");
		}
		else 
		{
			FileReader fr1 = new FileReader(myFile1); 
			BufferedReader br1 = new BufferedReader(fr1); 
			while((okunan_veri = br1.readLine())!= null)
			{
				if(okunan_veri.startsWith("+"))
				{
					if(kontrol==1)
					{
						ogrenciler.add(new Ogrenci(ogrenci_id, ogrenci_adsoyad, ogrenci_yas, alinanDersler));
						kontrol=0;
						alinanDersler = new ArrayList<Ders>();
					}
					
					okunan_veri = okunan_veri.replace("+", "");
					parca_veri = okunan_veri.split("%");
					
					ogrenci_id = Integer.parseInt(parca_veri[0]);
					ogrenci_adsoyad = parca_veri[1];
					ogrenci_yas = Integer.parseInt(parca_veri[2]);
					
					if(ogrenci_id> enBuyukOgrenciId)
					{
						enBuyukOgrenciId = ogrenci_id;
					}
					
				}	
				else if(okunan_veri.startsWith("*"))
				{
					kontrol = 1;
					
					okunan_veri = okunan_veri.replace("*", "");
					parca_veri = okunan_veri.split("%");
					
					ders_id = Integer.parseInt(parca_veri[0]);
					
					for(int i =0; i<dersler.size();i++)
					{
						if(ders_id == dersler.get(i).getDersId())
						{
							alinanDersler.add(dersler.get(i));
						}
					}
				}
				
			}
			ogrenciler.add(new Ogrenci(ogrenci_id, ogrenci_adsoyad, ogrenci_yas, alinanDersler));

			fr1.close();
			br1.close();
		}

		int secim;
		boolean dongu = true;
		
		while(dongu){

			System.out.println("\n---------DERSHANE OTOMASYONU---------\n");
			System.out.println("[1]  - Ders Ekle");
			System.out.println("[2]  - Ders Listele");
			System.out.println("[3]  - Ders Ara");
			System.out.println("[4]  - Ders Sil");
			System.out.println("[5]  - Ogrenci Ekle");
			System.out.println("[6]  - Ogrenci Ara");
			System.out.println("[7]  - Ogrenci Sil");
			System.out.println("[8]  - Ogrenci Listele");
			System.out.println("[9]  - Ogrencileri Ayrintili Listele");
			System.out.println("[10] - Ogrencilerin Odeyecegi Tutari Hesapla");
			System.out.println("[11] - Bitir");
			
			System.out.println("\nSeciminizi Giriniz: ");
			secim = scan.nextInt();
			
			switch (secim) {
			
			case 1:
				System.out.println("Eklenecek Dersin Adini Giriniz: ");
				ders_ad = scan.next();
				
				dersler.add(new Ders(ders_ad));
				
				System.out.println("Ders Kaydi Eklendi!");
				
				break;
				
			case 2:
				System.out.println("\nDers Id   Ders Ad");
				for(Ders temp_ders:dersler)
				{
					System.out.println(temp_ders.getDersId() + "      " + temp_ders.getDersAd());
				}
				break;
				
			case 3:
				int kontrol3 = 0;
				
				System.out.println("Aranan Dersin Adini Giriniz: ");
				ders_ad = scan.next();
				
				for(Ders temp_ders:dersler)
				{
					if(temp_ders.getDersAd().equals(ders_ad))
					{
						kontrol3 = 1;
						
						System.out.println("Aranan Ders:\n");
						System.out.println("Ders Id: "+temp_ders.getDersId());
						System.out.println("Ders Ad: "+temp_ders.getDersAd());
					}
				}	
				if(kontrol3 == 0)
				{
					System.out.println("Girilen Adda Ders Kaydi Bulunamadi!");
				}
				break;

			case 4: 
				int kontrol_ders = 0;
				int kontrol4 = 0;
			
				System.out.println("Silinecek Dersin Id'sini Giriniz: ");
				ders_id = scan.nextInt();
				
				for(int i = 0; i< ogrenciler.size(); i++)
				{
					for(int j = 0; j<dersler.size(); j++) 
					{	
						if(ogrenciler.get(i).alinanDersler.contains(dersler.get(j)) && ders_id == dersler.get(j).getDersId())
						{
							kontrol4 = 1;
							
							System.out.println("Bu Derse Ait Ogrenci Bulunmaktadir.");
							kontrol_ders = 1;
							break;
						}
						
						
						else if(ders_id == dersler.get(j).getDersId() && i == ogrenciler.size() - 1)  
						{
							kontrol4 = 1;
							kontrol_ders = 1;
							dersler.remove(j);
							System.out.println("Girilen Id'ye Ait Ders Kaydi Silindi!");
							break;
						}
						
					}
					
					if(kontrol_ders == 1)
					{
						break;
					}
				}
				
				if(kontrol4 == 0)
				{
					System.out.println("Girilen Id'ye Ait Ders Kaydi Bulunamadi!");
				}

				break;
				
			case 5: 
				int kontrol5 = 0,ders_sayi;
	
				while(true)
				{
					System.out.println("Eklenecek Ogrencinin Id'sini Giriniz: ");
					ogrenci_id = scan.nextInt();
					if(ogrenci_id>enBuyukOgrenciId)
						break;
					else {
						System.out.println("En Buyuk Id: "+enBuyukOgrenciId
								+" Daha Buyuk Bir Deger Girilmelidir!");
					}
				}
				
				for(Ogrenci temp_ogrenci: ogrenciler)
				{
					if(temp_ogrenci.getOgrId() == ogrenci_id)
					{
						System.out.println("Bu Id'de Baska Ogrenci Kayitlidir!");
						kontrol5 = 1;
						break;
					}
				}
				
				if(kontrol5 != 1)
				{
					alinanDersler = new ArrayList<Ders>();
					System.out.println("Eklenecek Ogrencinin Adini-Soyadini Giriniz: ");
					scan.nextLine();
					ogrenci_adsoyad = scan.nextLine();
					System.out.println("Eklenecek Ogrencinin Yasini Giriniz: ");
					ogrenci_yas = scan.nextInt();
					System.out.println("Ogrencinin Alacagi Ders Sayisini Giriniz: ");
					ders_sayi = scan.nextInt();
					for(int i=0; i<ders_sayi; i++)
				    {
						System.out.println("Ogrencinin Aldigi "+(i+1)+". Dersin Adi: ");
						ders_ad =scan.next();

					   for(int j =0; j<dersler.size();j++) 
					   {
							if(dersler.get(j).getDersAd().equals(ders_ad))
							{
								alinanDersler.add(dersler.get(j));
								break;
							}
							else if(j == dersler.size()-1)
							{
								System.out.println("Eklenecek Ders Bulunamadi!");
								break;
							}
						
					   }
					   
				     }
					
					ogrenciler.add(new Ogrenci(ogrenci_id,ogrenci_adsoyad, ogrenci_yas, alinanDersler));

					System.out.println("Ogrenci Kaydi Eklendi!");
				}
				break;
				
			case 6: 
				int kontrol6 = 0;
				
				System.out.println("Aranan Ogrencinin Adini-Soyadini Giriniz: ");
				scan.nextLine();
				ogrenci_adsoyad = scan.nextLine();
				
				for(Ogrenci temp_ogrenci: ogrenciler)
				{	
					if(temp_ogrenci.getOgrAdSoyad().equals(ogrenci_adsoyad))
					{
						kontrol6 = 1;
						
						System.out.println("Aranan Ogrenci:\n");
						System.out.println("Ogrenci Id: "+temp_ogrenci.getOgrId());
						System.out.println("Ogrenci Ad-Soyad: "+temp_ogrenci.getOgrAdSoyad());
						System.out.println("Ogrenci Yas: "+temp_ogrenci.getOgrYas());
						
						System.out.println("\nOgrencinin Ders Bilgileri:\n");
						
						for(Ders temp_ders: temp_ogrenci.alinanDersler)
						{
							System.out.println("Ders Id: "+temp_ders.getDersId());
							System.out.println("Ders Ad: "+temp_ders.getDersAd());
							System.out.println("\n");
						}
					}	
				}
				if(kontrol6 == 0)
				{
					System.out.println("Girilen Adda Ogrenci Kaydi Bulunamadi!");
				}
				break;
				
			case 7: 
				int kontrol7 = 0;
				
				System.out.println("Silinecek Ogrencinin Id'sini Giriniz: ");
				ogrenci_id = scan.nextInt();
				
				for(Ogrenci temp_ogrenci:ogrenciler)
				{
					if(temp_ogrenci.getOgrId() == ogrenci_id)
					{
						kontrol7 = 1;
						ogrenciler.remove(temp_ogrenci);
						System.out.println("Secilen Id'ye Ait Ogrenci Kaydi Silindi!");
						break;
					}
				}	
				if(kontrol7 == 0)
				{
					System.out.println("Girilen Id'ye Ait Ogrenci Kaydi Bulunamadi!");
				}	
				break;
				
			case 8: 
				System.out.println("Tum Ogrenciler:");
				for(Ogrenci temp_ogrenci:ogrenciler)
				{
					System.out.println(temp_ogrenci.getOgrId()+"  "+temp_ogrenci.getOgrAdSoyad()
									  +"  "+ temp_ogrenci.getOgrYas());
				}
				break;
				
			case 9:
				System.out.println("\nTum Ogrencilerin Ayrintili Listesi:");
				for(Ogrenci temp_ogrenci:ogrenciler)
				{
					System.out.println(temp_ogrenci.getOgrId()+"  "+temp_ogrenci.getOgrAdSoyad()
					  +"  "+ temp_ogrenci.getOgrYas());
					
					for(Ders temp_ders: temp_ogrenci.alinanDersler)
					{
						System.out.println("      "+temp_ders.getDersId() + "  " + temp_ders.getDersAd());
					}
				}
				break;
				
			case 10: 
				int kontrol10 = 0;
				int ders_sayisi = 0;
				double toplam_ucret=0,indirim;
				
				System.out.println("Odeyecegi Toplam Ucret Hesaplanacak Ogrenci Id'sini Giriniz: ");
				ogrenci_id = scan.nextInt();
				
				for(Ogrenci temp_ogrenci:ogrenciler)
				{
					if(temp_ogrenci.getOgrId() == ogrenci_id)
					{
						kontrol10 = 1;
						
						ders_sayisi = temp_ogrenci.alinanDersler.size();
						
						if(ders_sayisi == 2)  
					    {
						   System.out.println("1.Kampanyadan Yararlanabilir! Ikinci Ders %5 Indirimlidir!");
						   indirim = 400*0.05;
						   toplam_ucret = 4*((ders_sayisi * 400)- indirim);
					    }
					    else if(ders_sayisi == 3)  
					    {
						    System.out.println("2.Kampanyadan Yararlanabilir! Ucuncu Ders %15 Indirimlidir!");
						    indirim = 400*0.15;
							toplam_ucret = 4*((ders_sayisi * 400)- indirim);
					    }
					    else if(ders_sayisi > 3) 
					    {
						    System.out.println("3.Kampanyadan Yararlanabilir! Her Ders %10 Indirimlidir!");
						    indirim = ders_sayisi * (400*0.1);
						    toplam_ucret = 4*((ders_sayisi * 400)- indirim);
					    }
					    else 
					    {
						    System.out.println("Tek Ders Alan Ogrenciler Icýn Kampanya Bulunmamaktadir!");
						    toplam_ucret = 4 * 400;
					    }
						
					    System.out.println("Ogrencinin Odeyecegi Aylik Toplam Ucret: "+ toplam_ucret +" TL'dir.");
						break;
					}
				}
				if(kontrol10 == 0)
				{
					System.out.println("Girilen Id'ye Ait Ogrenci Kaydi Bulunamadi!");
				}
				break;
				
			case 11: 
				FileWriter fw1 = new FileWriter(myFile1);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				
				for(Ogrenci temp_ogrenci: ogrenciler)
				{
					bw1.write("+" + temp_ogrenci.getOgrId() + "%"+ temp_ogrenci.getOgrAdSoyad()
					+"%" +temp_ogrenci.getOgrYas() + '\n');
					
					for(Ders temp_ders:temp_ogrenci.alinanDersler)
					{
						bw1.write("*" + temp_ders.getDersId() + "%"+ temp_ders.getDersAd()+'\n');
					}
				}
				fw1.flush();
				bw1.flush();
				
				FileWriter fw2 = new FileWriter(myFile2);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				
				for(Ders temp_ders: dersler)
				{
					bw2.write(temp_ders.getDersId() +"%"+ temp_ders.getDersAd()+'\n');
				}
				fw2.flush();
				bw2.flush();
				
				dongu = false;
				break;
				
			default:
				System.out.println("Yanlis Secim Yaptiniz! [1-11] Arasinda Deger Girin!");
				break;
			}
			
		}
		
	}
	
}