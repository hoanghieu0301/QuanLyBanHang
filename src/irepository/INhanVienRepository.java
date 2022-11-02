/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.NhanVien;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface INhanVienRepository {

    List<NhanVien> selectAllNhanVien();

    Boolean insertCuaHang(NhanVien t);

    Boolean deleteCuaHangById(String id);

    Boolean updateCuaHang(NhanVien t, String id);
}
