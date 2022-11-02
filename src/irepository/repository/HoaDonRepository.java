/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.NhanVien;
import irepository.IHoaDonRepository;
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
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public List<HoaDon> selectAllDHoaDon() {
        String sql = " select HoaDon.id, HoaDon.idKH, idNV, HoaDon.Ma, NgayTao, TinhTrang, NhanVien.Ten\n "
                + " from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.Id"
                + "            join KhachHang on HoaDon.IdKH = KhachHang.Id ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));

                KhachHang kh = new KhachHang();

                kh.setId(rs.getString(2));
                hd.setIdKH(kh);

                NhanVien nv = new NhanVien();
                nv.setTen(rs.getString(7));
                nv.setId(rs.getString(3));
                hd.setIdNV(nv);

                hd.setMa(rs.getString(4));
                hd.setNgayTao(rs.getDate(5));
                hd.setTinhTrang(rs.getInt(6));

                listHoaDon.add(hd);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertHoaDon(HoaDon t) {
        int check = 0;
        String sql = "insert into HoaDon(IdKH, IdNV, Ma, NgayTao, TinhTrang)\n"
                + "values (?,?,?,?,?)";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getIdKH().getId());
            prs.setObject(2, t.getIdNV().getId());
            prs.setObject(3, t.getMa());
            prs.setObject(4, t.getNgayTao());
            prs.setObject(5, t.getTinhTrang());
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDon> lists = new HoaDonRepository().selectAllDHoaDon();
        System.out.println("" + lists);
    }
}
