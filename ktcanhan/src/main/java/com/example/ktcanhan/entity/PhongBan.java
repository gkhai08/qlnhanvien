package com.example.ktcanhan.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongBan")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy ="phongBan" , cascade = CascadeType.ALL )
    private List<NhanVien> nhanVien;
}
