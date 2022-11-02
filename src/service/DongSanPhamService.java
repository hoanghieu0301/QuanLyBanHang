/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QlDongSanPham;

/**
 *
 * @author ASUS
 */
public interface DongSanPhamService {
    String addDongSP(QlDongSanPham t);
    
    List<QlDongSanPham> selectAll();
    
    String updateDongSP(QlDongSanPham t, String id);
    
    String deleteDongSP(String id);
}
