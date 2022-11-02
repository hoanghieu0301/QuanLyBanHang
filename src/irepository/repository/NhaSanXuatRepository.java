/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.NhaSanXuat;
import irepository.INhaSanXuatRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class NhaSanXuatRepository implements INhaSanXuatRepository {

    @Override
    public List<NhaSanXuat> selectAllNSX() {
        String sql = " select id, Ma, Ten\n"
                + " from  NSX";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            ResultSet rs = prst.executeQuery();
            List<NhaSanXuat> listDSP = new ArrayList<>();
            while (rs.next()) {
                NhaSanXuat cv = new NhaSanXuat();
                cv.setId(rs.getString(1));
                cv.setMa(rs.getString(2));
                cv.setTen(rs.getString(3));
                listDSP.add(cv);
            }
            return listDSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhaSanXuatRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertNSX(NhaSanXuat t) {
        int check = 0;
        String sql = " insert into NSX(Ma, Ten)\n"
                + " values (?,?) ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, t.getMa());
            prst.setObject(2, t.getTen());
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhaSanXuatRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean deleteNSXById(String id) {
        int check = 0;
        String sql = "delete from NSX\n"
                + "where id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, id);
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhaSanXuatRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean update(NhaSanXuat t, String id) {
        int check = 0;
        String sql = " update DongSP "
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
            Logger.getLogger(NhaSanXuatRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

}
