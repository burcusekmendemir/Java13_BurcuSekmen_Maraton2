package com.burcu.service;

import com.burcu.entity.Unlu;
import com.burcu.repository.UnluRepository;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UnluService {

    public static List<Unlu> randomUnluGetir(){
        List<Unlu> unluList = new UnluRepository().findAll();
        Collections.shuffle(unluList); // shuffle ile listenin her yarışmacıda karışmasını sağlıyoruz.
        return unluList;
    }

}
