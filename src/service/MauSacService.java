/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLMauSac;

/**
 *
 * @author ASUS
 */
public interface MauSacService {
    String addMauSac(QLMauSac t);
    
    List<QLMauSac> selectAll();
    
    String updateMauSac(QLMauSac t, String id);
    
    String deleteMauSac(String id);
}
