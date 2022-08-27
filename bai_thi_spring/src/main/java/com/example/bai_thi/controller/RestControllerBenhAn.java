package com.example.bai_thi.controller;

import com.example.bai_thi.model.BenhAn;
import com.example.bai_thi.service.IBenhAnService;
import com.example.bai_thi.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/benhAn")
@CrossOrigin
public class RestControllerBenhAn {
    @Autowired
    private IBenhAnService iBenhAnService;
    @Autowired
    private IBenhNhanService iBenhNhanService;
   @GetMapping("")
   public ResponseEntity<Page<BenhAn>> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page){
       return new ResponseEntity<>(iBenhAnService.findAll( PageRequest.of(page,5)), HttpStatus.OK);
   }
    @PostMapping("/create")
    private ResponseEntity<BenhAn> create(@RequestBody BenhAn benhAn) {
        iBenhAnService.create(benhAn);
        return new ResponseEntity<>(benhAn,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBenhAn(@PathVariable int id) {
        iBenhAnService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BenhAn>findById(@PathVariable int id){
       return new ResponseEntity<>(iBenhAnService.findById(id),HttpStatus.OK);
   }


    @PutMapping("/update/{id}")
    public ResponseEntity<BenhAn> updateBenhAn(@PathVariable int id, @RequestBody BenhAn benhAn) {
        BenhAn benhAns = iBenhAnService.findById(id);
        if (benhAns == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        benhAns.setBacSi(benhAn.getBacSi());
        benhAns.setLiDo(benhAn.getLiDo());
        benhAns.setMaBenhAn(benhAn.getMaBenhAn());
        benhAns.setNgayRa(benhAn.getNgayRa());
        benhAns.setNgayVao(benhAn.getNgayVao());
        benhAns.setPhuongPhap(benhAn.getPhuongPhap());
        benhAns.setBenhNhans(benhAn.getBenhNhans());
        iBenhAnService.update(benhAns);
        return new ResponseEntity<>(benhAns, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<BenhAn>> searchPatient(@RequestParam String liDo,
                                                       @PageableDefault(value = 5) Pageable pageable) {
        Page<BenhAn> benhAns = iBenhAnService.search(liDo, pageable);
        return new ResponseEntity<>(benhAns, HttpStatus.OK);
    }


}
