/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

public class QLHoaDonChiTiet {

    private QLHoaDon idHoaDon;
    private QLChiTietSanPham idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;

    public QLHoaDonChiTiet() {
    }

    public QLHoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(QLHoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public QLChiTietSanPham getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(QLChiTietSanPham idChiTietSP) {
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
        return "QLHoaDonChiTiet{" + "idHoaDon=" + idHoaDon + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

}
