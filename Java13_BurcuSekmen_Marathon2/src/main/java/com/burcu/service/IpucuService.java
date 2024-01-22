package com.burcu.service;

import com.burcu.entity.Ipucu;
import com.burcu.entity.Unlu;
import com.burcu.repository.IpucuRepository;

import java.util.ArrayList;
import java.util.List;

public class IpucuService {


    public static List<Ipucu> ipucuGetir(List<Unlu> unluList){
        List<Ipucu>  ipucuList = new IpucuRepository() .findAll();
        List<Ipucu> ipucuSon=new ArrayList<>();

        for (Unlu unlu : unluList) {
            // foreach ile her unlu için ipucu listesi id'lerine göre filtelendi ve bulunan ilk değer dönüldü eğer yoksa da null dönmesi için orElse ile belirtildi.
            Ipucu ipucu = ipucuList.stream().filter(x -> x.getUnlu().getId().equals(unlu.getId())).findFirst().orElse(null);
            if (ipucu != null) {
                System.out.println("********** İPUÇLARI *********");
                System.out.println("Boy: " + ipucu.getBoy());
                System.out.println("Kilo: " + ipucu.getKilo());
                System.out.println("Cinsiyet: " + ipucu.getCinsiyet());
                System.out.println("Meslek: " + ipucu.getMeslek());
                System.out.println("Yarattıgı Eserin Turu: " + ipucu.getYarattigiEserinTuru());
                System.out.println("Sac Rengi: " + ipucu.getSacRengi());
                System.out.println("Göz Rengi: " + ipucu.getGozRengi());
                System.out.println("Memleketi Neresi: " + ipucu.getMemleketiNeresi());
                System.out.println("Yurtdışında Mı Yaşıyor? : " + ipucu.isYurtdisindaMiYasiyor());
                System.out.println("Program Sunuyormu: " + ipucu.isProgramSunuyormu());
                System.out.println("Evli mı: " + ipucu.isEvliMi());
                System.out.println("Yeni Bir Filmi Çıktı Mı? : " + ipucu.isSuanYeniBirFilmiCiktiMi());
                System.out.println("Başrol Mu? : " + ipucu.isBasrolMu());
                System.out.println("*****************************");
                ipucuSon.add(ipucu);
            }

        }
        return ipucuSon;
    }



}
