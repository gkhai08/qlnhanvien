package com.example.ktcanhan.repository;
import com.example.ktcanhan.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface IPhongBanRepository extends JpaRepository<PhongBan, Long>{
}
