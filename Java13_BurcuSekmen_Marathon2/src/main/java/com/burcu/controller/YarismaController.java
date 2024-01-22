package com.burcu.controller;

import com.burcu.entity.Ipucu;
import com.burcu.entity.Unlu;
import com.burcu.entity.Yarismaci;
import com.burcu.repository.YarismaciRepository;
import com.burcu.service.IpucuService;
import com.burcu.service.UnluService;

import java.util.List;
import java.util.Scanner;

public class YarismaController {


    public static void tahminEt(Yarismaci yarismaci, List<Unlu> unluList){
        Scanner scanner=new Scanner(System.in);

        long baslangicZamani =0L;

        for (Unlu unlu: unluList) {
            System.out.println("************************************");
            System.out.println("*********** WHO AM I ? ************");
            System.out.println("************************************");
            List<Ipucu> ipucuList = IpucuService.ipucuGetir(List.of(unlu));
            baslangicZamani= System.currentTimeMillis(); //Yarişmacının yarışmaya başlangıç suresini verir.
            boolean dogruTahmin=false;
            do {
                System.out.println("Tahmiminizi giriniz:");
                String tahmin=scanner.nextLine();
                Ipucu ipucu=ipucuList.get(0);

                if (unlu.getId().equals(ipucu.getUnlu().getId())){ //Ipucudan gelen ünlü ile randomUnluGetir() methodundan gelen ünlü listesindeki ünlüyü karşılaştırır.
                    if (tahmin.equalsIgnoreCase(unlu.getAdSoyad())){ //Tahmin edilen ile randomUnluGetir() methodundan gelen ünlüyü karşılaştırır.
                        System.out.println("Tebrikler, dogru tahmin ettiniz!");
                        dogruTahmin=true;
                        break;
                    }else {
                        System.out.println("Yanlış tahmin, tekrar deneyiniz.");
                    }
                }
            }while (!dogruTahmin);
        }
        long bitisZamani = System.currentTimeMillis(); //Yarışmanın bitiş süresini verir
        int yarismaSuresi = (int) ((bitisZamani - baslangicZamani) / 1000); //Saniye cinsinden yarışmanın geçen süresini verir.
        yarismaci.setSure(yarismaSuresi);

        System.out.println("Yarışma sonlandı!");
        System.out.println("********************************");
    }

}
