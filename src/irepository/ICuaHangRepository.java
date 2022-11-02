/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.CuaHang;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICuaHangRepository {
    List<CuaHang> selectAllCuaHang();
    
    CuaHang selectCuaHangByMa(String ma);
    
    Boolean insertCuaHang(CuaHang t);
    
    Boolean deleteCuaHangById(String id);
    
    Boolean updateCuaHang(CuaHang t, String id);
    
    CuaHang selectByTen(String ten);
}
