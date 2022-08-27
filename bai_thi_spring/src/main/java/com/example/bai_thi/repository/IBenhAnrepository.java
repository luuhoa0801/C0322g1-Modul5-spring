package com.example.bai_thi.repository;

import com.example.bai_thi.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBenhAnrepository extends JpaRepository<BenhAn,Integer> {

    @Query(value = "select * from benh_an", nativeQuery = true)
    Page<BenhAn> findAllBenhAn( Pageable pageable);

    @Query(value = "select * from benh_an where id = :id", nativeQuery = true)
    BenhAn findById(@Param("id") int id);

    @Modifying
    @Query(value = "insert into benh_an (bac_si,li_do,ma_benh_an,ngay_ra,ngay_vao,phuong_phap,id_benh_nhan) values" +
            " (:bacSi,:liDo,:maBenhAn,:ngayRa,:ngayVao,:phuongPhap,:idBenhNhan)", nativeQuery = true)
    void create(@Param("bacSi") String bacSi,
                @Param("liDo") String liDo,
                @Param("maBenhAn") String maBenhAn,
                @Param("ngayRa") String ngayRa,
                @Param("ngayVao") String ngayVao,
                @Param("phuongPhap") String phuongPhap,
                @Param("idBenhNhan") Integer idBenhNhan);

    @Modifying
    @Query(value = "delete from benh_an where id = :id ", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Query(value = "update benh_an set bac_si = :bacSi,li_do = :liDo,ma_benh_an = :maBenhAn,ngay_ra = :ngayRa," +
            "ngay_vao = :ngayVao,phuong_phap = :phuongPhap,id_benh_nhan = :idBenhNhan where id = :id",
            nativeQuery = true)
    void update(@Param("bacSi") String bacSi, @Param("liDo") String liDo,
                @Param("maBenhAn") String maBenhAn, @Param("ngayRa") String ngayRa,
                @Param("ngayVao") String ngayVao, @Param("phuongPhap") String phuongPhap,
                @Param("idBenhNhan") Integer idBenhNhan,@Param("id") Integer id);

    @Query(value = "select * from benh_an where li_do like :liDo ", nativeQuery = true)
    Page<BenhAn> search(@Param("liDo") String liDo, Pageable pageable);
}
