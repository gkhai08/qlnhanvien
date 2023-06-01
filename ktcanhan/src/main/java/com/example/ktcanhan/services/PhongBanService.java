package com.example.ktcanhan.services;

import com.example.ktcanhan.entity.PhongBan;
import com.example.ktcanhan.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    public PhongBan getPhongBanById(Long id){
        Optional<PhongBan> optionalPhongBan = phongBanRepository.findById(id);
        if (optionalPhongBan.isPresent()){
            return optionalPhongBan.get();
        }else{
            throw new RuntimeException("PhongBan not found");
        }
    }
    public void addPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    public PhongBan savePhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void deletePhongBan(Long id) {
        phongBanRepository.deleteById(id);
    }

    public void updatedPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }
}