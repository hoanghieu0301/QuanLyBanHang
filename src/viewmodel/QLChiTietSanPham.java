/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

public class QLChiTietSanPham {

    private String id;
    private QLSanPham idSP;
    private QLNhaSanXuat idNSX;
    private QLMauSac idMaiSac;
    private QlDongSanPham idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QLSanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(QLSanPham idSP) {
        this.idSP = idSP;
    }

    public QLNhaSanXuat getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(QLNhaSanXuat idNSX) {
        this.idNSX = idNSX;
    }

    public QLMauSac getIdMaiSac() {
        return idMaiSac;
    }

    public void setIdMaiSac(QLMauSac idMaiSac) {
        this.idMaiSac = idMaiSac;
    }

    public QlDongSanPham getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(QlDongSanPham idDongSP) {
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

    public Object[] toRowData() {
        return new Object[]{idSP.getTen(), idNSX.getTen(), idMaiSac.getTen(), idDongSP.getTen(), moTa, namBH, soLuongTon, giaNhap, giaBan};
    }

    @Override
    public String toString() {
        return "QLChiTietSanPham{" + "id=" + id + ", idSP=" + idSP + ", idNSX=" + idNSX + ", idMaiSac=" + idMaiSac + ", idDongSP=" + idDongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    
}
