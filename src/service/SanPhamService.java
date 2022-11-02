/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLSanPham;

/**
 *
 * @author ASUS
 */
public interface SanPhamService {
    String addSanPham(QLSanPham t);

    List<QLSanPham> selectAll();

    String updateSanPham(QLSanPham t, String id);

    String deleteSanPham(String id);
}
