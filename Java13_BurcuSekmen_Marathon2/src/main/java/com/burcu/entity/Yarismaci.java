package com.burcu.entity;

import com.burcu.utility.enums.Cinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_yarismaci")
public class Yarismaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    Integer yas;
    Integer sure;
    @Enumerated
    Cinsiyet cinsiyet;
    @ManyToOne
    Yarisma yarisma;
}
