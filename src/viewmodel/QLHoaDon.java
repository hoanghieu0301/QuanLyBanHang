/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

public class QLHoaDon {
//    /id, idKH, idNV, Ma, NgayTao,TinhTrang

    private String id;
    private QLKhachHang idKH;
    private QLNhanVien idNV;
    private String ma;
    private Date ngayTao;
    private int tinhTrang;

    public QLHoaDon() {
    }

    public QLHoaDon(String id, QLKhachHang idKH, QLNhanVien idNV, String ma, Date ngayTao, int tinhTrang) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QLKhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(QLKhachHang idKH) {
        this.idKH = idKH;
    }

    public QLNhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(QLNhanVien idNV) {
        this.idNV = idNV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String tinhTrang(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Chờ thanh toán";
        } else if (tinhTrang == 1) {
            return "Đã thanh toán";
        } else {
            return "Đã hủy";
        }
    }

    @Override
    public String toString() {
        return "QLHoaDon{" + "id=" + id + ", idKH=" + idKH + ", idNV=" + idNV + ", ma=" + ma + ", ngayTao=" + ngayTao + ", tinhTrang=" + tinhTrang + '}';
    }

    public Object[] toRowData() {

        return new Object[]{ma, ngayTao, idNV.getTen(), tinhTrang(tinhTrang)};
    }
}
