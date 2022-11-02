/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.ChiTietSanPham;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.SanPham;
import irepository.IHoaDonChiTiet;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTietRepository implements IHoaDonChiTiet {

    @Override
    public List<HoaDonChiTiet> selectAllDHoaDonChiTiet() {
        String sql = " select  HoaDonChiTiet.IdHoaDon,HoaDonChiTiet.IdChiTietSP, SanPham.Ma,  SanPham.Ten, SoLuong, DonGia\n "
                + " from HoaDonChiTiet join ChiTietSP on HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id\n "
                + "					join SanPham on ChiTietSP.IdSP = SanPham.Id\n "
                + "					join HoaDon on HoaDonChiTiet.IdHoaDon = HoaDon.Id ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            List<HoaDonChiTiet> lists = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));
                hoaDonChiTiet.setIdHoaDon(hd);

                ChiTietSanPham ctSP = new ChiTietSanPham();
                ctSP.setId(rs.getString(2));
                hoaDonChiTiet.setIdChiTietSP(ctSP);

                SanPham sp = new SanPham();
                sp.setMa(rs.getString(3));
                sp.setTen(rs.getString(4));
                ctSP.setIdSP(sp);
                hoaDonChiTiet.setIdChiTietSP(ctSP);

                hoaDonChiTiet.setSoLuong(rs.getInt(5));

                hoaDonChiTiet.setDonGia(rs.getBigDecimal(6));

                lists.add(hoaDonChiTiet);

            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertHoaDonChiTiet(HoaDonChiTiet t) {
        int check = 0;
        String sql = " insert HoaDonChiTiet(idHoaDon, idChiTietSP, SoLuong, DonGia) \n"
                + " values (?,?,?,?)";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getIdHoaDon().getId());
            prs.setObject(2, t.getIdChiTietSP().getId());
            prs.setObject(3, t.getSoLuong());
            prs.setObject(4, t.getDonGia());
            
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

}
