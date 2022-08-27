package com.example.bai_thi.service;

import com.example.bai_thi.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBenhAnService {
    Page<BenhAn> findAll(Pageable pageable);

    BenhAn findById(int id);

    void create(BenhAn benhAn);

    void delete(Integer id);

    void update(BenhAn benhAn);

    Page<BenhAn> search(String liDo, Pageable pageable);
}
