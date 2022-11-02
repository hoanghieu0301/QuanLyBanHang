/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLChucVu;

public interface ChucVuService {
    
    String addChucVu(QLChucVu t);
    
    List<QLChucVu> selectAll();
    
    String updateChucVu(QLChucVu t, String id);
    
    String deleteChucVu(String id);
    
    QLChucVu searchByMa(String ma);
    
    QLChucVu selectByTen(String ten);
}
