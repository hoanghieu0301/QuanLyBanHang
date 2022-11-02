/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class GioHang implements Serializable{
    private String id;
    private KhachHang idKH;
    private NhanVien idNV;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
    private int trangThai;
           
}
