/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema.salonu.uygulaması;

import java.util.Scanner;

/**
 *
 * @author Dalmazgil
 */
public class SinemaSalonuUygulaması {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner girdi = new Scanner(System.in);

        SinemaSalonu Sinema = new SinemaSalonu();

        Salon1 Avengers = new Salon1();

        Salon2 Corgi = new Salon2();

        Salon3 Hababam = new Salon3();

        Salon4 Suikastçi = new Salon4();

        Salon5 HayvanMezarlığı = new Salon5();

        Fatura Fatura = new Fatura();

        Sinema.SalonSeçim();

        switch (Sinema.salon) {

            case 1: {
                // Salon 1,Salon 2, Salon 3,Salon 4,Salon 5 classları Sinema Salonundan extends edildiği için Sinema Salonu classında yer alan metotlar bu classlardan türetilen nesneler için kullanılabildi.
                Avengers.SeansSeçim(Avengers.seanslar);
                Avengers.KoltukSeçim(Avengers.seanslar);
                Fatura.Bilgi(Avengers.seanslar, Avengers.seçseans, Avengers.harf, Avengers.sayı, Avengers.tutar);
                break;
            }

            case 2: {

                Corgi.SeansSeçim(Corgi.seanslar);
                Corgi.KoltukSeçim(Corgi.seanslar);
                Fatura.Bilgi(Corgi.seanslar, Corgi.seçseans, Corgi.harf, Corgi.sayı, Corgi.tutar);
                break;
            }

            case 3: {

                Hababam.SeansSeçim(Hababam.seanslar);
                Hababam.KoltukSeçim(Hababam.seanslar);
                Fatura.Bilgi(Hababam.seanslar, Hababam.seçseans, Hababam.harf, Hababam.sayı, Hababam.tutar);
                break;
            }

            case 4: {

                Suikastçi.SeansSeçim(Suikastçi.seanslar);
                Suikastçi.KoltukSeçim(Suikastçi.seanslar);
                Fatura.Bilgi(Suikastçi.seanslar, Suikastçi.seçseans, Suikastçi.harf, Suikastçi.sayı, Suikastçi.tutar);
                break;

            }

            case 5: {

                HayvanMezarlığı.SeansSeçim(HayvanMezarlığı.seanslar);
                HayvanMezarlığı.KoltukSeçim(HayvanMezarlığı.seanslar);
                Fatura.Bilgi(HayvanMezarlığı.seanslar, HayvanMezarlığı.seçseans, HayvanMezarlığı.harf, HayvanMezarlığı.sayı, HayvanMezarlığı.tutar);
                break;
            }

            default: {

            }

        }

    }

}
