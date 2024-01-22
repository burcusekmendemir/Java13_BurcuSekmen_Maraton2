package com.burcu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_yarisma")
public class Yarisma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    @Temporal(TemporalType.DATE)
    LocalDate tarih;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yarisma")
    List<Yarismaci> yarismaciList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yarisma")
    List<Unlu> unluList;


}
