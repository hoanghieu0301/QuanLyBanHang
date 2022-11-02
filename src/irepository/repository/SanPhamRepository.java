/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.SanPham;
import irepository.ISanPhamRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public List<SanPham> selectAllSanPham() {
        String sql = "  select id, Ma, Ten\n"
                + " from SanPham ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            ResultSet rs = prst.executeQuery();
            List<SanPham> listSanPham = new ArrayList<>();
            while (rs.next()) {
                SanPham cv = new SanPham();
                cv.setId(rs.getString(1));
                cv.setMa(rs.getString(2));
                cv.setTen(rs.getString(3));
                listSanPham.add(cv);
            }
            return listSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertSanPham(SanPham t) {
        int check = 0;
        String sql = " insert into SanPham(Ma, Ten)\n"
                + " values (?,?) ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, t.getMa());
            prst.setObject(2, t.getTen());
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean deleteSanPhamById(String id) {
        int check = 0;
        String sql = "delete from SanPham\n"
                + "where id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, id);
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean updateSanPham(SanPham t, String id) {
        int check = 0;
        String sql = " update SanPham "
                + " set Ma= ? , Ten = ? "
                + " where Id = ?";

        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, t.getMa());
            prst.setObject(2, t.getTen());
            prst.setObject(3, id);
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

}
