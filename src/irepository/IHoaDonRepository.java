/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.HoaDon;
import java.util.List;

public interface IHoaDonRepository {

    List<HoaDon> selectAllDHoaDon();

    Boolean insertHoaDon(HoaDon t);
}
