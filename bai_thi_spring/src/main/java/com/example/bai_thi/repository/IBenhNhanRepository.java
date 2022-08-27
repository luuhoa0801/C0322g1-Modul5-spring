package com.example.bai_thi.repository;

import com.example.bai_thi.model.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBenhNhanRepository extends JpaRepository<BenhNhan,Integer> {
    @Query(value = "select * from benh_nhan ",nativeQuery = true)
    List<BenhNhan> findAll();
}
