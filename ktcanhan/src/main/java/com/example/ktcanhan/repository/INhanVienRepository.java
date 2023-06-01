package com.example.ktcanhan.repository;
import com.example.ktcanhan.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface INhanVienRepository extends JpaRepository<NhanVien, Long>{
}
