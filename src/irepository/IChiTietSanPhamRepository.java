/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.ChiTietSanPham;
import java.util.List;

public interface IChiTietSanPhamRepository {

    List<ChiTietSanPham> selectAllChiTietSanPham();

    Boolean insertChiTietSanPham(ChiTietSanPham t);

    Boolean deleteChiTietSanPhamById(String id);

    Boolean updateChiTietSanPham(ChiTietSanPham t, String id);

    ChiTietSanPham selectByTen(String ten);

    Boolean updateSoLuongTon(int soLuonTon, String id);
}
