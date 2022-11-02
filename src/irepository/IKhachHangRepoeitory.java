/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.KhachHang;
import java.util.List;


public interface IKhachHangRepoeitory {
      List<KhachHang> selectAllKhachHang();
      
      Boolean insertKhachHang(KhachHang t);
      
      Boolean updateKhachHang(KhachHang t, String id);
      
      Boolean deleteKhachHang(String id);

}
