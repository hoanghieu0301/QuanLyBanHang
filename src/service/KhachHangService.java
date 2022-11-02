/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLKhachHang;

/**
 *
 * @author ASUS
 */
public interface KhachHangService {

    String addKhachHang(QLKhachHang t);

    List<QLKhachHang> selectAll();

    String update(QLKhachHang t, String id);

    String deleteKhachHang(String id);
}
