/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema.salonu.uygulaması;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Dalmazgil
 */
public class Fatura extends SinemaSalonu {

    public String Fatura;

    public void Bilgi(String[] seanslar, int seçseans, String harf, int sayı, int tutar) {

        this.Fatura = " " + seanslar[0] + " Seans Saati: " + seanslar[seçseans + 2] + "\n KoltukNo: " + harf + sayı + "\n Ödenecek Tutar: " + tutar + "TL";

        try {
            File dosya = new File("C:\\SinemaSalonu\\Fatura.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write(Fatura);
            yaz.close();
            System.out.println("\n Faturanız Kaydedildi");
            System.out.println(" --------------------");
        } catch (Exception hata) {
            hata.printStackTrace();
        }

        System.out.println(this.Fatura);

    }

}


 

    

    
    

