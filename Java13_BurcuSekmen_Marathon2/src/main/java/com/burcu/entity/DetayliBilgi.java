package com.burcu.entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_detaylibilgi")
public class DetayliBilgi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String sacRengi;
    String gozRengi;
    String sarkisininIsmi;
    String dizisininiIsmi;
    String filmininIsmi;
    String programininIsmi;
    boolean programSunuyorMu;
    boolean suanYeniBirSarkisiCiktiMi;
    boolean suanYeniBirDizisiCiktiMi;
    boolean suanYeniBirFilmiCiktiMi;
    boolean basrolMu;
    boolean yurtdisindaMiYasiyor;
    String memleketiNeresi;
    boolean evliMi;
    String  yarattigiEserinTuru;

    @OneToOne
    Unlu unlu;
}
