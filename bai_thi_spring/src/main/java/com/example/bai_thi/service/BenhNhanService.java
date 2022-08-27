package com.example.bai_thi.service;

import com.example.bai_thi.model.BenhNhan;
import com.example.bai_thi.repository.IBenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhNhanService implements IBenhNhanService {
    @Autowired
    private IBenhNhanRepository iBenhNhanRepository;

    @Override
    public List<BenhNhan> fillAllBenhNhan() {
        return iBenhNhanRepository.findAll();
    }
}
