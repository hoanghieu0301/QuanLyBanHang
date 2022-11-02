/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;


public class GioHangChiTiet implements Serializable{
    private GioHang idGioHang;
    private ChiTietSanPham idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;
}
