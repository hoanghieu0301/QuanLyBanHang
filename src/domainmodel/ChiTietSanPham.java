/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ASUS
 */
public class ChiTietSanPham implements Serializable{
    private String id;
    private SanPham idSP;
    private NhaSanXuat idNSX;
    private MauSac idMaiSac;
    private DongSanPham idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id, SanPham idSP, NhaSanXuat idNSX, MauSac idMaiSac, DongSanPham idDongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMaiSac = idMaiSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public NhaSanXuat getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(NhaSanXuat idNSX) {
        this.idNSX = idNSX;
    }

    public MauSac getIdMaiSac() {
        return idMaiSac;
    }

    public void setIdMaiSac(MauSac idMaiSac) {
        this.idMaiSac = idMaiSac;
    }

    public DongSanPham getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(DongSanPham idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "id=" + id + ", idSP=" + idSP + ", idNSX=" + idNSX + ", idMaiSac=" + idMaiSac + ", idDongSP=" + idDongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }
    
    
}
