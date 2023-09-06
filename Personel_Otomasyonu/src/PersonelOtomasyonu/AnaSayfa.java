package Odev1;

import java.util.Scanner;

public class AnaSayfa {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Departman Sayisini Giriniz: ");
		
		int departmanSayi;
		departmanSayi = scan.nextInt();
		
		Departman[] departmanlar = new Departman[departmanSayi];
		
		int depNo,personelSayi;
		String depAd;
		
		for(int i=0; i< departmanSayi; i++)
		{
			System.out.println((i+1)+".Departman No Giriniz: ");
			depNo = scan.nextInt();
			
			System.out.println((i+1)+".Departman Ad Giriniz: ");
			depAd = scan.next();
			
			System.out.println("Personel Sayisini Giriniz: ");
			personelSayi = scan.nextInt();
			
			Personel[] personeller = new Personel[personelSayi];
			
			int perYas;
			String perAd,perSoyad;
			
			for(int j=0 ; j<personelSayi; j++)
			{
				System.out.println((j+1)+".Personel Ad Giriniz: ");
				perAd = scan.next();
				
				System.out.println((j+1)+".Personel Soyad Giriniz: ");
				perSoyad = scan.next();
				
				System.out.println((j+1)+".Personel Yas Giriniz: ");
				perYas = scan.nextInt();
				
				Personel per = new Personel(depNo, perAd, perSoyad, perYas);
				personeller[j] = per;
			}
			
			int projeSayi;
			
			System.out.println("Proje Sayisini Giriniz: ");
			projeSayi = scan.nextInt();
			
			Proje[] projeler = new Proje[projeSayi];
			
			String projeAd;
			int projeSure,projeMaaliyet;
			
			for(int k=0 ; k<projeSayi; k++)
			{
				System.out.println((k+1)+".Proje Ad Giriniz: ");
				projeAd = scan.next();
				
				System.out.println((k+1)+".Proje Suresinin Kac Ay Oldugunu Giriniz: ");
				projeSure = scan.nextInt();
				
				System.out.println((k+1)+".Proje Maaliyetinin Kac TL Oldugunu Giriniz: ");
				projeMaaliyet = scan.nextInt();
				
				Proje pr = new Proje(depNo, projeAd, projeSure, projeMaaliyet);
				projeler[k] = pr;
				
			}
			
			Departman dep = new Departman(depNo, depAd,personeller,projeler);
			departmanlar[i] = dep;
			
		}
		
		int secim,personelYas,projeSure,projeMaaliyet;
		String departmanAd,personelAd,projeAd;
		float ortYas,ortMaaliyet;
		boolean dongu = true;
		
		while(dongu)
		{

			System.out.println("[1] - Tum Departman Bilgilerini Listele");
			System.out.println("[2] - Departman Adina Gore Arama Yap");
			System.out.println("[3] - Personel Adina Gore Arama Yap");
			System.out.println("[4] - Proje Adina Gore Arama Yap");
			System.out.println("[5] - Yas Bilgisine Gore Personelleri Bul");
			System.out.println("[6] - Yas Bilgisine Gore Personelleri Analiz Et");
			System.out.println("[7] - Proje Suresine Gore Projeleri Bul");
			System.out.println("[8] - Proje Maaliyetine Gore Projeleri Bul");
			System.out.println("[9] - Proje Maaliyetine Gore Projeleri Analiz Et");
			System.out.println("[10] - Cikis");
			
			System.out.println("Seciminizi Giriniz: ");
			secim = scan.nextInt();
			
			switch (secim) {
			case 1:
				for(int i=0;i<departmanlar.length;i++)
				{
					System.out.println("\nDepartmanlar");
					System.out.println((i+1)+".Departman No: "+departmanlar[i].getDepNo());
					System.out.println((i+1)+".Departman Ad: "+departmanlar[i].getDepAd());
					
					System.out.println("\nPersoneller");
					for(int j=0;j<departmanlar[i].personeller.length;j++)
					{
						System.out.println((j+1)+".Personel ID: "+departmanlar[i].personeller[j].getPerID());
						System.out.println((j+1)+".Personel Ad: "+departmanlar[i].personeller[j].getPerAd());
						System.out.println((j+1)+".Personel Soyad: "+departmanlar[i].personeller[j].getPerSoyad());
						System.out.println((j+1)+".Personel Yas: "+departmanlar[i].personeller[j].getPerYas());
					}
					
					System.out.println("\nProjeler");
					for(int k=0;k<departmanlar[i].projeler.length;k++)
					{
						System.out.println((k+1)+".Proje ID: "+departmanlar[i].projeler[k].getProjeID());
						System.out.println((k+1)+".Proje Ad: "+departmanlar[i].projeler[k].getProjeAd());
						System.out.println((k+1)+".Proje Suresi: "+departmanlar[i].projeler[k].getProjeSure());
						System.out.println((k+1)+".Proje Maaliyeti: "+departmanlar[i].projeler[k].getProjeMaaliyet());
					}
				}
				break;
				
			case 2:
				System.out.println("Aranan Departmanin Adini Giriniz: ");
				departmanAd = scan.next();
				
				int sayac = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					if(departmanlar[i].getDepAd().equals(departmanAd))
					{
						System.out.println("\nDepartmanlar");
						System.out.println((i+1)+".Departman No: "+departmanlar[i].getDepNo());
						System.out.println((i+1)+".Departman Ad: "+departmanlar[i].getDepAd());
						
						System.out.println("\nPersoneller");
						for(int j=0;j<departmanlar[i].personeller.length;j++)
						{
							System.out.println((j+1)+".Personel ID: "+departmanlar[i].personeller[j].getPerID());
							System.out.println((j+1)+".Personel Ad: "+departmanlar[i].personeller[j].getPerAd());
							System.out.println((j+1)+".Personel Soyad: "+departmanlar[i].personeller[j].getPerSoyad());
							System.out.println((j+1)+".Personel Yas: "+departmanlar[i].personeller[j].getPerYas());
						}
						System.out.println("\nProjeler");
						for(int k=0;k<departmanlar[i].projeler.length;k++)
						{
							System.out.println((k+1)+".Proje ID: "+departmanlar[i].projeler[k].getProjeID());
							System.out.println((k+1)+".Proje Ad: "+departmanlar[i].projeler[k].getProjeAd());
							System.out.println((k+1)+".Proje Suresi: "+departmanlar[i].projeler[k].getProjeSure());
							System.out.println((k+1)+".Proje Maaliyeti: "+departmanlar[i].projeler[k].getProjeMaaliyet());
						}
						sayac++;
					}
				}
				if (sayac == 0)
					System.out.println("Aranan Departman Bulunamadi!");
				break;
				
			case 3:
				System.out.println("Aranan Personel Adini Giriniz: ");
				personelAd = scan.next();
				
				int sayac2 = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int j=0;j<departmanlar[i].personeller.length;j++)
					{
						if(departmanlar[i].personeller[j].getPerAd().equals(personelAd))
						{
							System.out.println((j+1)+".Personel ID: "+departmanlar[i].personeller[j].getPerID());
							System.out.println((j+1)+".Personel Ad: "+departmanlar[i].personeller[j].getPerAd());
							System.out.println((j+1)+".Personel Soyad: "+departmanlar[i].personeller[j].getPerSoyad());
							System.out.println((j+1)+".Personel Yas: "+departmanlar[i].personeller[j].getPerYas());
							sayac2++;
						}
					}
				}
				
				if (sayac2 == 0)
					System.out.println("Aranan Personel Bulunamadi!");
				break;

			case 4: 
				System.out.println("Aranan Proje Adini Giriniz: ");
				projeAd = scan.next();
				
				int sayac3 = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int k=0;k<departmanlar[i].projeler.length;k++)
					{
						if(departmanlar[i].projeler[k].getProjeAd().equals(projeAd))
						{
							System.out.println((k+1)+".Proje ID: "+departmanlar[i].projeler[k].getProjeID());
							System.out.println((k+1)+".Proje Ad: "+departmanlar[i].projeler[k].getProjeAd());
							System.out.println((k+1)+".Proje Suresi: "+departmanlar[i].projeler[k].getProjeSure());
							System.out.println((k+1)+".Proje Maaliyeti: "+departmanlar[i].projeler[k].getProjeMaaliyet());
							sayac3++;
						}
					}
				}
				
				if (sayac3 == 0)
					System.out.println("Aranan Proje Bulunamadi!");
				break;

			case 5: 
				System.out.println("Aranan Personelin Yasini Giriniz: ");
				personelYas = scan.nextInt();
				
				int sayac4 = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int j=0;j<departmanlar[i].personeller.length;j++)
					{
						if(departmanlar[i].personeller[j].getPerYas() == personelYas)
						{
							System.out.println((j+1)+".Personel ID: "+departmanlar[i].personeller[j].getPerID());
							System.out.println((j+1)+".Personel Ad: "+departmanlar[i].personeller[j].getPerAd());
							System.out.println((j+1)+".Personel Soyad: "+departmanlar[i].personeller[j].getPerSoyad());
							System.out.println((j+1)+".Personel Yas: "+departmanlar[i].personeller[j].getPerYas());
							sayac4++;
						}
					}
				}
				
				if (sayac4 == 0)
					System.out.println("Aranan Personel Bulunamadi!");
				break;
			case 6: 
				
				int toplamYas = 0;
				int perSayi = 0;
				int sayac20_30=0;
				int sayac31_40=0;
				int sayac41_50=0;
				int sayac50=0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int j=0;j<departmanlar[i].personeller.length;j++)
					{
						perSayi = departmanlar[i].personeller[j].getPersonelSayi();
						
						if(departmanlar[i].personeller[j].getPerYas()>=20 
							&& departmanlar[i].personeller[j].getPerYas()<=30)
						{
							sayac20_30++;
						}
						else if (departmanlar[i].personeller[j].getPerYas()>=31 
								&& departmanlar[i].personeller[j].getPerYas()<=40) 
						{
							sayac31_40++;
						}
						else if (departmanlar[i].personeller[j].getPerYas()>=41 
								&& departmanlar[i].personeller[j].getPerYas()<=50) 
						{
							sayac41_50++;
						}
						else if (departmanlar[i].personeller[j].getPerYas()>50) 
						{
							sayac50++;
						}
						
						toplamYas += departmanlar[i].personeller[j].getPerYas();
					}
				}
				
				ortYas = toplamYas / perSayi;
				
				System.out.println("21-30 Yas Araligindaki Personel Sayisi: "+sayac20_30);
				System.out.println("31-40 Yas Araligindaki Personel Sayisi: "+sayac31_40);
				System.out.println("41-50 Yas Araligindaki Personel Sayisi: "+sayac41_50);
				System.out.println("50 Yasindan Buyuk Personel Sayisi: "+sayac50);
				System.out.println("Tum Personellerin Yas Ortalamasi: "+ortYas);
				
				break;
				
			case 7: 
				System.out.println("Aranan Proje Suresini Giriniz: ");
				projeSure = scan.nextInt();
				
				int sayac5 = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int k=0;k<departmanlar[i].projeler.length;k++)
					{
						if(departmanlar[i].projeler[k].getProjeSure() == projeSure)
						{
							System.out.println((k+1)+".Proje ID: "+departmanlar[i].projeler[k].getProjeID());
							System.out.println((k+1)+".Proje Ad: "+departmanlar[i].projeler[k].getProjeAd());
							System.out.println((k+1)+".Proje Suresi: "+departmanlar[i].projeler[k].getProjeSure());
							System.out.println((k+1)+".Proje Maaliyeti: "+departmanlar[i].projeler[k].getProjeMaaliyet());
							sayac5++;
						}
					}
				}
				
				if (sayac5 == 0)
					System.out.println("Aranan Proje Bulunamadi!");
				break;
				
			case 8: 
				System.out.println("Aranan Proje Maaliyetini Giriniz: ");
				projeMaaliyet = scan.nextInt();
				
				int sayac6 = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int k=0;k<departmanlar[i].projeler.length;k++)
					{
						if(departmanlar[i].projeler[k].getProjeMaaliyet() == projeMaaliyet)
						{
							System.out.println((k+1)+".Proje ID: "+departmanlar[i].projeler[k].getProjeID());
							System.out.println((k+1)+".Proje Ad: "+departmanlar[i].projeler[k].getProjeAd());
							System.out.println((k+1)+".Proje Suresi: "+departmanlar[i].projeler[k].getProjeSure());
							System.out.println((k+1)+".Proje Maaliyeti: "+departmanlar[i].projeler[k].getProjeMaaliyet());
							sayac6++;
						}
					}
				}
				
				if (sayac6 == 0)
					System.out.println("Aranan Proje Bulunamadi!");
				break;
				
			case 9: 
				int toplamMaaliyet=0;
				int enBuyuk = 0;
				int enKucuk = 0;
				int projeSayi = 0;
				
				for(int i=0;i<departmanlar.length;i++)
				{
					for(int j=0;j<departmanlar[i].projeler.length;j++)
					{
						projeSayi = departmanlar[i].projeler[j].getProjeSayisi();

						enBuyuk = departmanlar[0].projeler[0].getProjeMaaliyet();
						enKucuk = departmanlar[0].projeler[0].getProjeMaaliyet();
						
						
						if(departmanlar[i].projeler[j].getProjeMaaliyet()> enBuyuk) 
						{
							enBuyuk = departmanlar[i].projeler[j].getProjeMaaliyet();
						}
						if (departmanlar[i].projeler[j].getProjeMaaliyet()< enKucuk) 
						{
							enKucuk = departmanlar[i].projeler[j].getProjeMaaliyet();
						}
						
						toplamMaaliyet += departmanlar[i].projeler[j].getProjeMaaliyet();
					}
				}
				
				ortMaaliyet = toplamMaaliyet / projeSayi;
				
				System.out.println("En Yuksek Maaliyetli Proje: "+enBuyuk);
				System.out.println("En Dusuk Maaliyetli Proje: "+enKucuk);
				System.out.println("Tum Projelerin Ortalama Maaliyeti: "+ortMaaliyet);
				break;
				
			case 10: 
				dongu = false;
				break;
				
			default:
				System.out.println("Yenlis Secim Yaptiniz! [1-10] Arasinda Deger Girin!");
				break;
			}
			
		}

	}

}
