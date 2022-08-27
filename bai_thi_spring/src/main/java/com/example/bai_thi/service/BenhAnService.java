package com.example.bai_thi.service;

import com.example.bai_thi.model.BenhAn;
import com.example.bai_thi.repository.IBenhAnrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BenhAnService implements IBenhAnService {
    @Autowired
    private IBenhAnrepository iBenhAnrepository;

    @Override
    public Page<BenhAn> findAll(Pageable pageable) {
        return iBenhAnrepository.findAllBenhAn(pageable);
    }

    @Override
    public BenhAn findById(int id) {
        return iBenhAnrepository.findById(id);
    }

    @Override
    public void create(BenhAn benhAn) {
         iBenhAnrepository.create(benhAn.getBacSi(),benhAn.getLiDo(),benhAn.getMaBenhAn(),
                 benhAn.getNgayRa(),benhAn.getNgayVao(),benhAn.getPhuongPhap(),benhAn.getBenhNhans().getId());
    }

    @Override
    public void delete(Integer id) {
        iBenhAnrepository.delete(id);
    }

    @Override
    public void update(BenhAn benhAn) {
        iBenhAnrepository.update(benhAn.getBacSi(),benhAn.getLiDo(),benhAn.getMaBenhAn(),benhAn.getNgayRa(),
                benhAn.getNgayVao(),benhAn.getPhuongPhap(),benhAn.getBenhNhans().getId(),benhAn.getId());
    }

    @Override
    public Page<BenhAn> search(String liDo, Pageable pageable) {
        return iBenhAnrepository.search("%"+liDo +"%", pageable);
    }

}
