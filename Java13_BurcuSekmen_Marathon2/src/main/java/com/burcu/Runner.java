package com.burcu;

import com.burcu.service.YarismaService;
import com.burcu.utility.create.CreateData;

public class Runner {


    public static void main(String[] args) {

        CreateData.veriEkle();

        /**
         * İpuçlarını tahmin etmeye çalışırken (kenan imirzalioglu, acun ilicali, gupse ozay gibi
         * TR karakter olmadan tahmin etmelisiniz, kayıtlarını bu şekil yaptım)
         * Çünkü bilgisayarım Tr karakter hatası veriyor:) böyle yazınca doğru sonuçların geldiği görülebilir:)
         */
        YarismaService.yarismayiBaslat();

    }


}
