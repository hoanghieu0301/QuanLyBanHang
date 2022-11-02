/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.ChucVu;
import irepository.IChucVuRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChucVuRepository implements IChucVuRepository {

    @Override
    public boolean insertChucVu(ChucVu t) {
        int check = 0;
        String sql = " insert into ChucVu(Ma, Ten)\n"
                + " values (?,?) ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, t.getMa());
            prst.setObject(2, t.getTen());
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public List<ChucVu> selectAllChucVu() {
        String sql = "  select id, Ma, Ten\n"
                + " from ChucVu ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            ResultSet rs = prst.executeQuery();
            List<ChucVu> listChucVu = new ArrayList<>();
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getString(1));
                cv.setMa(rs.getString(2));
                cv.setTen(rs.getString(3));
                listChucVu.add(cv);
            }
            return listChucVu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateChucVu(ChucVu t, String id) {
        int check = 0;
        String sql = " update ChucVu "
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
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public boolean deleteChuVu(String id) {
        int check = 0;
        String sql = "delete from ChucVu\n"
                + "where id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, id);
            check = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public ChucVu searchByMa(String ma) {
        String sql = " select Id, Ma, Ten\n"
                + " from ChucVu\n"
                + " where Ma = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prst = con.prepareStatement(sql)) {
            prst.setObject(1, ma);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getString(1));
                cv.setMa(rs.getString(2));
                cv.setTen(rs.getString(3));
                return cv;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

        @Override
    public ChucVu searchByTen(String ten) {
         String sql = " Select id from ChucVu where ten = ? ";

        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, ten);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ChucVu chucVu = new ChucVu();
                chucVu.setId(rs.getString(1));
                return chucVu;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {

//        ChucVu cv = new ChucVu("CV01", "Vệ Sinh");
//        String id = "F89CE281-1362-424A-A38A-3333E39F1058";
//        boolean bb = new irepository.repository.ChucVuRepository().updateChucVu(cv, id);
//        System.out.println("" + bb);
        ChucVu cv = new irepository.repository.ChucVuRepository().searchByTen("Trưởng phòng");
        System.out.println("" + cv.getId());
        
        List<ChucVu> list = new irepository.repository.ChucVuRepository().selectAllChucVu();
        System.out.println("" + list);
    }



    
}
