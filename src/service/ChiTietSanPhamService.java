/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLChiTietSanPham;

/**
 *
 * @author ASUS
 */
public interface ChiTietSanPhamService {
    String addChiTietSP(QLChiTietSanPham t);
    
    List<QLChiTietSanPham> selectAll();
    
    String updateChiTietSP(QLChiTietSanPham t, String id);
    
    String deleteChiTietSP(String id);
    
    String updateSoLuonTon(int soLuonTon, String id);
}
