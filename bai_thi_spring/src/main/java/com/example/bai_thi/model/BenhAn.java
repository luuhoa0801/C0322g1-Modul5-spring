package com.example.bai_thi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenhAn {

//    benhNhan?: BenhNhan;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maBenhAn;
    private String ngayVao;
    private String ngayRa;
    private String liDo;
    private String phuongPhap;
    private String bacSi;

    @ManyToOne()
    @JoinColumn(name = "id_benh_nhan")
    private BenhNhan benhNhans;

    public void setId(Integer id) {
        this.id = id;
    }

    public BenhNhan getBenhNhans() {
        return benhNhans;
    }

    public void setBenhNhans(BenhNhan benhNhans) {
        this.benhNhans = benhNhans;
    }

    public BenhAn() {
    }

    public BenhAn(int id, String maBenhAn, String ngayVao, String ngayRa, String liDo, String phuongPhap, String bacSi) {
        this.id = id;
        this.maBenhAn = maBenhAn;
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.liDo = liDo;
        this.phuongPhap = phuongPhap;
        this.bacSi = bacSi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public String getPhuongPhap() {
        return phuongPhap;
    }

    public void setPhuongPhap(String phuongPhap) {
        this.phuongPhap = phuongPhap;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }
}
