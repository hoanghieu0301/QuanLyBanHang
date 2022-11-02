/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLNhaSanXuat;

/**
 *
 * @author ASUS
 */
public interface NhaSanXuatService {

    String addNXS(QLNhaSanXuat t);

    List<QLNhaSanXuat> selectAll();

    String updateNSX(QLNhaSanXuat t, String id);

    String deleteNSX(String id);
}
