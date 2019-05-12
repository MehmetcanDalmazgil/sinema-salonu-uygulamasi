/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema.salonu.uygulaması;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dalmazgil
 */
public class SinemaSalonu {

    public int salon;
    public int seçseans;
    public String[] seans;
    public int geridön;
    public int biletseçim;
    public String harf;
    public int sayı;
    public int harfdeğiş;
    public int tutar;
    public int onay;
    public int[][] SalonKoltuk = new int[9][9];

    public void Bilgilendirme() {

        System.out.println("BURSA SİNEMA SALONUNA HOŞGELDİNİZ\n\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println("VİZYONDAKİ FİLMLER" + "\n------------------");
        System.out.println("Salon 1: Avengers:Endgame (Yaş Sınırı --> 13+) ");
        System.out.println("Salon 2: Corgi (Genel İzleyici) ");
        System.out.println("Salon 3: Hababam Sınıfı Yeniden (Yaş Sınırı --> 7+)");
        System.out.println("Salon 4: Suikastçi (Yaş Sınırı --> 13+) ");
        System.out.println("Salon 5: Hayvan Mezarlığı (Yaş Sınırı --> 18+)\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println("BİLET FİYATLARI" + "\n---------------");
        System.out.println("Tam Bilet = 15 TL" + "\nÖğrenci Bilet = 10 TL\n\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

    }

    public void SalonSeçim() {

        Bilgilendirme();

        int i = 2;

        Scanner girdi = new Scanner(System.in);

        System.out.println("Bilet Almak İstediğiniz Salon Numarasını Giriniz:");

        this.salon = girdi.nextInt();

        while (!(this.salon <= 5 && this.salon > 0 && this.salon % 1 == 0)) {

            System.out.println("\nLütfen Geçerli Bir Salon Numarası Giriniz(Kalan Hak=" + i + "):");
            i -= 1;

            this.salon = girdi.nextInt();

            if ((i == 0) && !(this.salon <= 5 && this.salon > 0)) {

                System.out.println("\nAna Sayfaya Yönlendiriliyorsunuz Lütfen Bekleyin...\n");
                System.out.println("---------------------------------------------------\n");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                SalonSeçim();
            }

        }

    }

    public void Seanslar(String[] seans) {

        System.out.println("");

        for (String s : seans) {

            System.out.println(s);
        }
    }

    public void SeansSeçim(String[] seanslar) {

        Scanner girdi = new Scanner(System.in);

        int j = 2;

        System.out.println("-------------------------------------------------");

        Seanslar(seanslar);

        System.out.println("Seans Saatinizi Seçiniz:");

        this.seçseans = girdi.nextInt();

        while (!(this.seçseans <= 5 && this.seçseans > 0 && this.seçseans % 1 == 0)) {

            System.out.println("\nLütfen Geçerli Bir Seans Saati Seçiniz(Kalan Hak=" + j + "):");
            j -= 1;

            this.seçseans = girdi.nextInt();

            if ((j == 0) && !((this.seçseans <= 5) && (this.seçseans > 0))) {

                System.out.println("\nAna Sayfaya Yönlendiriliyorsunuz Lütfen Bekleyin...\n");
                System.out.println("---------------------------------------------------\n");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                SalonSeçim();
                SeansSeçim(seanslar);

            }
        }
    }

    public void KoltukSeçim(String[] seanslar) {

        Scanner girdi = new Scanner(System.in);

        System.out.println("\nSEÇİLEN FİLM ve SEANS SAATİ\n" + "---------------------------");

        System.out.println(seanslar[0]);

        System.out.println("Seans Saati: " + seanslar[this.seçseans + 2] + "\n---------------------------\n");

        System.out.println("\nLütfen Bekleyin Koltuklar Görüntülenecktir...\n\n ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        SalonKoltuk();

        KoltukKarar(this.SalonKoltuk);

    }

    public void SalonKoltuk() {

        Random r = new Random();

        for (int i = 0; i < 40; i++) {

            int x = r.nextInt(9);

            int y = r.nextInt(9);

            SalonKoltuk[x][y] = 1;

        }
        System.out.println("   A    B    C    D    E    F    G    H    I   ");
        System.out.println("  -------------------------------------------");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if ((SalonKoltuk[i][j] == 1) && (j == 0)) {

                    System.out.print((i + 1) + " |D| ");

                }
                if ((SalonKoltuk[i][j] == 0) && (j == 0)) {

                    System.out.print((i + 1) + " | | ");

                }
                if ((SalonKoltuk[i][j] == 1) && (j != 0)) {

                    System.out.print(" |D| ");

                }

                if ((SalonKoltuk[i][j] == 0) && (j != 0)) {

                    System.out.print(" | | ");

                }

            }

            System.out.println("");
        }

        System.out.println("\n |D| = Dolu Koltuklar    | | = Boş Koltuklar\n ");
        System.out.println(" Koltuk Seçimine Geçmek İçin ENTER'a Basınız!\n");

    }

    public void KoltukKarar(int[][] SalonKoltuk) {

        Scanner girdi = new Scanner(System.in);

        boolean kontrol = false;

        while (kontrol == false) {

            this.harf = girdi.nextLine();

            while (!(harf.equals("A") || harf.equals("B") || harf.equals("C") || harf.equals("D") || harf.equals("E") || harf.equals("F") || harf.equals("G") || harf.equals("H") || harf.equals("I"))) {

                System.out.println("Hangi Harf Sırasından Koltuk İstiyorsanız Lütfen Giriniz:");
                this.harf = girdi.nextLine();
                System.out.println("\nLütfen Bekleyin...\n");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                if (!(harf.equals("A") || harf.equals("B") || harf.equals("C") || harf.equals("D") || harf.equals("E") || harf.equals("F") || harf.equals("G") || harf.equals("H") || harf.equals("I"))) {

                    System.out.println("\nGirilen Harf Sırası Geçersiz!");
                    System.out.println("\nTekrar Harf Seçimi İçin Sizi Yönlendiriyoruz Lütfen Bekleyin...\n\n");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }

                }

            }

            System.out.println("\n" + this.harf + " Harfinin Hangi Rakamından Koltuk İstiyorsanız Lütfen Giriniz: ");
            this.sayı = girdi.nextInt();

            while ((this.sayı <= 0) && (this.sayı > 9)) {

                System.out.println("\nGirilen Sayı Sırası Hatalı Lütfen Tekrar Giriniz:");
                this.sayı = girdi.nextInt();

            }
            switch (this.harf) {

                case "A":
                    this.harfdeğiş = 0;
                    break;
                case "B":
                    this.harfdeğiş = 1;
                    break;
                case "C":
                    this.harfdeğiş = 2;
                    break;
                case "D":
                    this.harfdeğiş = 3;
                    break;
                case "E":
                    this.harfdeğiş = 4;
                    break;
                case "F":
                    this.harfdeğiş = 5;
                    break;
                case "G":
                    this.harfdeğiş = 6;
                    break;
                case "H":
                    this.harfdeğiş = 7;
                    break;
                case "I":
                    this.harfdeğiş = 8;
                    break;

            }

            if (SalonKoltuk[this.sayı - 1][this.harfdeğiş] == 1) {

                System.out.println("\nSeçilen Koltuk Dolu!\n");
                System.out.println("Tekrar Seçim İçin Sizi Yönlendiriyoruz Lütfen Bekleyin...\n\n");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
            } else {
                System.out.println("Koltuk Seçimi Tamamlanadı.\n");
                System.out.println("\nSeçilen Koltuk: " + this.harf + this.sayı + "\n");
                System.out.println("Onaylıyorsanız Lütfen 1'e Basınız.");
                System.out.println("\nFarklı Bir Koltuk Seçmek İstiyorsanız Lütfen 0'a Basınız.");
                this.onay = girdi.nextInt();

                while (!(this.onay == 0 || this.onay == 1)) {
                    System.out.println("\nHatalı Tuşlama Yaptınız Lütfen Tekrar Tuşlayınız:");
                }

                if (this.onay == 1) {

                    SalonKoltuk[this.sayı - 1][this.harfdeğiş] = 1;
                    kontrol = true;

                    System.out.println("\nBilet Türünüzü Seçiniz(1-Tam Bilet 2-Öğrenci Bilet):");
                    this.biletseçim = girdi.nextInt();

                    while (!((this.biletseçim == 1) || (this.biletseçim == 2))) {

                        System.out.println("\nGirilen Bilet Türü Hatalı Lütfen Tekrar Giriniz:");
                        this.biletseçim = girdi.nextInt();
                    }
                    switch (this.biletseçim) {

                        case 1:
                            this.tutar = 15;
                            break;
                        case 2:
                            this.tutar = 10;
                            break;
                    }

                    System.out.println("\nBizi Tercih Ettiğiniz İçin Teşekkür Ederiz Lütfen Faturanızı Kaybetmeyin! :)");
                    System.out.println("----------------------------------------------------------------------------");

                } else {
                    System.out.println("\nLütfen Bekleyin Tekrar Seçim Yapmanız İçin Sizi Yönlendiriyoruz...\n");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }

                }

            }

        }

    }

}
