package com.example.bai_thi.controller;

import com.example.bai_thi.model.BenhNhan;
import com.example.bai_thi.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/benhNhan")
public class RestControllerBenhNhan {
    @Autowired
    private IBenhNhanService iBenhNhanService;

    @GetMapping("")
    private ResponseEntity<List<BenhNhan>> showListBenhNhan() {
        List<BenhNhan> listBenhNhan = iBenhNhanService.fillAllBenhNhan();
        if (listBenhNhan.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBenhNhan, HttpStatus.OK);

    }
}
