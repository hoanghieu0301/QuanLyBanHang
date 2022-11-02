/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.DongSanPham;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IDongSanPhamRepository {

    List<DongSanPham> selectAllDSP();

    Boolean insertDSP(DongSanPham t);

    Boolean deleteDSPById(String id);

    Boolean updateDSP(DongSanPham t, String id);
}
