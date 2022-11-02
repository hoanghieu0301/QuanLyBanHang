/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.NhaSanXuat;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface INhaSanXuatRepository {

    List<NhaSanXuat> selectAllNSX();

    Boolean insertNSX(NhaSanXuat t);

    Boolean deleteNSXById(String id);

    Boolean update(NhaSanXuat t, String id);
}
