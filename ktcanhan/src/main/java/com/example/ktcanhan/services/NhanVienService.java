package com.example.ktcanhan.services;

import com.example.ktcanhan.entity.NhanVien;
import com.example.ktcanhan.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired

    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getALlNhanVien() {

        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(Long id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }
    public void addNhanVien (NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }
    public void updateNhanVien (NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }
    public void deleteNhanVien (Long id) {
        nhanVienRepository.deleteById(id);
    }
}