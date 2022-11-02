/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository;
import domainmodel.ChucVu;
import java.util.List;

public interface IChucVuRepository {
     boolean insertChucVu(ChucVu t);
     
     List<ChucVu> selectAllChucVu();
     
     boolean  updateChucVu(ChucVu t, String id);
     
     boolean deleteChuVu(String id);
     
     ChucVu searchByMa(String ma);
     
     ChucVu searchByTen(String ten);
     
}
