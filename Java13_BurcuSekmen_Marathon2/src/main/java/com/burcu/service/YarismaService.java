package com.burcu.service;

import com.burcu.controller.YarismaController;
import com.burcu.entity.Unlu;
import com.burcu.entity.Yarismaci;
import com.burcu.repository.YarismaRepository;
import com.burcu.repository.YarismaciRepository;

import java.util.List;

public class YarismaService {


    public static void yarismayiBaslat(){
        List<Yarismaci> yarismaciList=new YarismaciRepository().findAll();
        List<Unlu> unluList =  UnluService.randomUnluGetir();

        for (Yarismaci yarismaci : yarismaciList) {
            System.out.println("**************************************");
            System.out.println("**************************************");
            System.out.println("Yarişmaci...: " + yarismaci.getAd());
            YarismaController.tahminEt(yarismaci, unluList);

            yarismaci.setSure(0);
        }

        Yarismaci kazanan = yarismaciList.get(0);
        for (Yarismaci yarismaci : yarismaciList) {
            if (yarismaci.getSure() > kazanan.getSure()){
                kazanan = yarismaci;
            }
        }

        System.out.println("Oyunun Kazananı....: " + kazanan.getAd());
    }
}
