/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
public class HoaDonChiTiet implements Serializable{
    
    private HoaDon idHoaDon;
    private ChiTietSanPham idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public ChiTietSanPham getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSanPham idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHoaDon=" + idHoaDon + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

 
    
    
}
