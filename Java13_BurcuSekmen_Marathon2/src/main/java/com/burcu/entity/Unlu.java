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
@Table(name = "tbl_unlu")
public class Unlu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String adSoyad;
    Double boy;
    Double kilo;
    @Enumerated
    Cinsiyet cinsiyet;
    @Enumerated
    Meslek meslek;
    String imageUrl;
    @ManyToOne
    Yarisma yarisma;
    @OneToOne (cascade = CascadeType.ALL)
    DetayliBilgi detayliBilgi;
    @OneToOne(cascade = CascadeType.ALL)
    Ipucu ipucu;

}
