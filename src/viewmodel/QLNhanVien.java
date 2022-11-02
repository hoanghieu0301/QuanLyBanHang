/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;


import java.util.Date;

/**
 *
 * @author ASUS
 */
public class QLNhanVien {

    private String id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private QLCuaHang idCH;
    private QLChucVu idCV;
    private String idGuiBC;
    private int trangThai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public QLCuaHang getIdCH() {
        return idCH;
    }

    public void setIdCH(QLCuaHang idCH) {
        this.idCH = idCH;
    }

    public QLChucVu getIdCV() {
        return idCV;
    }

    public void setIdCV(QLChucVu idCV) {
        this.idCV = idCV;
    }
    
    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QLNhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", tenDem=" + tenDem + ", ho=" + ho + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", matKhau=" + matKhau + ", idCH=" + idCH + ", idCV=" + idCV + ", idGuiBC=" + idGuiBC + ", trangThai=" + trangThai + '}';
    }

    
    public Object[] toRowData() {
        return new Object[]{ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, matKhau, idCH.getTen(), idCV.getTen()};
    }
}
