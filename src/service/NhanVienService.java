/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLNhanVien;

/**
 *
 * @author ASUS
 */
public interface NhanVienService {
    String addCuaHang(QLNhanVien t);

    List<QLNhanVien> selectAll();

    String updateNhanVien(QLNhanVien t, String id);

    String deleteNhanVien(String id);
}
