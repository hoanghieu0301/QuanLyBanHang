/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;


import domainmodel.SanPham;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ISanPhamRepository {
     List<SanPham> selectAllSanPham();

    Boolean insertSanPham(SanPham t);

    Boolean deleteSanPhamById(String id);

    Boolean updateSanPham(SanPham t, String id);
}
