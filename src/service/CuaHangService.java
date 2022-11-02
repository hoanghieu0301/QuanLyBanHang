/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLCuaHang;

/**
 *
 * @author ASUS
 */
public interface CuaHangService {

    String addCuaHang(QLCuaHang t);

    List<QLCuaHang> selectAll();

    String updateCuaHang(QLCuaHang t, String id);

    String deleteCuaHang(String id);

    QLCuaHang searchByMa(String ma);

    QLCuaHang selectByTen(String ten);

}
