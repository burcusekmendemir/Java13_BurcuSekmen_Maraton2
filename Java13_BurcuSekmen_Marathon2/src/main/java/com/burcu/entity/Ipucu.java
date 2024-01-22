package com.burcu.entity;

import com.burcu.utility.enums.Cinsiyet;
import com.burcu.utility.enums.Meslek;
import jakarta.persistence.*;
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
@Table(name = "tbl_ıpucu")
public class Ipucu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double boy;
    Double kilo;
    @Enumerated
    Cinsiyet cinsiyet;
    @Enumerated
    Meslek meslek;
    String sacRengi;
    String gozRengi;
    boolean programSunuyormu;
    boolean suanYeniBirSarkisiCiktiMi;
    boolean suanYeniBirDizisiCiktiMi;
    boolean suanYeniBirFilmiCiktiMi;
    boolean basrolMu;
    boolean yurtdisindaMiYasiyor;
    boolean evliMi;
    String  yarattigiEserinTuru;
    String memleketiNeresi;
    @OneToOne
    Unlu unlu;



}
