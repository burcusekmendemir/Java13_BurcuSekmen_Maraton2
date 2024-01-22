package com.burcu.utility.create;

import com.burcu.entity.*;
import com.burcu.repository.YarismaRepository;
import com.burcu.utility.enums.Cinsiyet;
import com.burcu.utility.enums.Meslek;

import java.time.LocalDate;
import java.util.List;

public class CreateData {

    public static void veriEkle() {
        Ipucu ipucu1= Ipucu.builder()
                .boy(1.80)
                .kilo(90.0)
                .cinsiyet(Cinsiyet.ERKEK)
                .meslek(Meslek.TV_PROGRAMCISI)
                .yarattigiEserinTuru("Eğlence Yarışması")
                .sacRengi("Siyah")
                .gozRengi("Kahverengi")
                .memleketiNeresi("Erzurum")
                .programSunuyormu(true)
                .yurtdisindaMiYasiyor(true)
                .build();

        Ipucu ipucu2= Ipucu.builder()
                .boy(1.90)
                .kilo(95.0)
                .evliMi(true)
                .gozRengi("kahverengi")
                .meslek(Meslek.TV_PROGRAMCISI)
                .yarattigiEserinTuru("Bilgi Yarışması")
                .cinsiyet(Cinsiyet.ERKEK)
                .sacRengi("siyah")
                .memleketiNeresi("Ankara")
                .programSunuyormu(true)
                .build();

        Ipucu ipucu3= Ipucu.builder()
                .boy(1.60)
                .kilo(65.0)
                .gozRengi("kahverengi")
                .meslek(Meslek.FILM_OYUNCUSU)
                .yarattigiEserinTuru("Komedi")
                .cinsiyet(Cinsiyet.KADIN)
                .sacRengi("kahverengi")
                .memleketiNeresi("İzmir")
                .suanYeniBirFilmiCiktiMi(true)
                .evliMi(true)
                .basrolMu(true)
                .build();


        DetayliBilgi detayliBilgi1 = DetayliBilgi.builder()
                .sacRengi("Siyah")
                .gozRengi("Kahverengi")
                .programininIsmi("Survivor")
                .memleketiNeresi("Erzurum")
                .programSunuyorMu(true)
                .yurtdisindaMiYasiyor(true)
                .yarattigiEserinTuru("Eğlence Yarışması")
                .build();
        DetayliBilgi detayliBilgi2 = DetayliBilgi.builder()
                .sacRengi("Siyah")
                .gozRengi("Kahverengi")
                .programininIsmi("Kim Milyoner Olmak İster?")
                .memleketiNeresi("Ankara")
                .evliMi(true)
                .programSunuyorMu(true)
                .yarattigiEserinTuru("Bilgi Yarısması")
                .build();
        DetayliBilgi detayliBilgi3 = DetayliBilgi.builder()
                .sacRengi("Kahverengi")
                .gozRengi("Kahverengi")
                .filmininIsmi("Lohusa")
                .memleketiNeresi("İzmir")
                .evliMi(true)
                .suanYeniBirFilmiCiktiMi(true)
                .yarattigiEserinTuru("Komedi")
                .basrolMu(true)
                .build();


        Unlu unlu1 = Unlu.builder()
                .adSoyad("Acun Ilicali")
                .boy(1.80)
                .kilo(90.0)
                .cinsiyet(Cinsiyet.ERKEK)
                .meslek(Meslek.TV_PROGRAMCISI)
                .imageUrl("https://picsum.photos/00")
                .detayliBilgi(detayliBilgi1)
                .ipucu(ipucu1)
                .build();
        Unlu unlu2 = Unlu.builder()
                .adSoyad("Kenan İmirzalioglu")
                .boy(1.90)
                .kilo(95.0)
                .cinsiyet(Cinsiyet.ERKEK)
                .meslek(Meslek.TV_PROGRAMCISI)
                .imageUrl("https://picsum.photos/100")
                .detayliBilgi(detayliBilgi2)
                .ipucu(ipucu2)
                .build();
        Unlu unlu3 = Unlu.builder()
                .adSoyad("Gupse Ozay")
                .boy(1.60)
                .kilo(65.0)
                .cinsiyet(Cinsiyet.KADIN)
                .meslek(Meslek.FILM_OYUNCUSU)
                .imageUrl("https://picsum.photos/300")
                .detayliBilgi(detayliBilgi3)
                .ipucu(ipucu3)
                .build();

        detayliBilgi1.setUnlu(unlu1);
        ipucu1.setUnlu(unlu1);
        detayliBilgi2.setUnlu(unlu2);
        ipucu2.setUnlu(unlu2);
        detayliBilgi3.setUnlu(unlu3);
        ipucu3.setUnlu(unlu3);


        Yarismaci yarismaci1= Yarismaci.builder()
                .ad("Burcu")
                .yas(26)
                .cinsiyet(Cinsiyet.KADIN)
                .build();
        Yarismaci yarismaci2= Yarismaci.builder()
                .ad("Mert")
                .yas(28)
                .cinsiyet(Cinsiyet.ERKEK)
                .build();
        Yarismaci yarismaci3= Yarismaci.builder()
                .ad("Bahar")
                .yas(24)
                .cinsiyet(Cinsiyet.KADIN)
                .build();


        Yarisma yarisma = Yarisma.builder()
                .ad("Who Am I ?")
                .tarih(LocalDate.of(2024,1,22))
                .yarismaciList(List.of(yarismaci1,yarismaci2,yarismaci3))
                .unluList(List.of(unlu1,unlu2,unlu3))
                .build();


        yarismaci1.setYarisma(yarisma);
        yarismaci2.setYarisma(yarisma);
        yarismaci3.setYarisma(yarisma);
        unlu1.setYarisma(yarisma);
        unlu2.setYarisma(yarisma);
        unlu3.setYarisma(yarisma);
        new YarismaRepository().save(yarisma);


    }
}
