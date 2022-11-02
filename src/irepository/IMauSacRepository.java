/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.MauSac;
import java.util.List;

public interface IMauSacRepository {

    List<MauSac> selectAllMauSac();

    Boolean insertMauSac(MauSac t);

    Boolean deleteMauSacById(String id);

    Boolean updateMauSac(MauSac t, String id);
}
