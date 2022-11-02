/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.CuaHang;
import irepository.ICuaHangRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuaHangRepository implements ICuaHangRepository {

    @Override
    public List<CuaHang> selectAllCuaHang() {
        String sql = " select Id, Ma, Ten, DiaChi, ThanhPho, QuocGia \n"
                + " from CuaHang";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            List<CuaHang> lists = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang();
                cuaHang.setId(rs.getString(1));
                cuaHang.setMa(rs.getString(2));
                cuaHang.setTen(rs.getString(3));
                cuaHang.setDiaChi(rs.getString(4));
                cuaHang.setThanhPho(rs.getString(5));
                cuaHang.setQuocGia(rs.getString(6));
                lists.add(cuaHang);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CuaHang selectCuaHangByMa(String ma) {
        String sql = " select Id, Ma, Ten, DiaChi, ThanhPho, QuocGia\n"
                + " from CuaHang"
                + " where ma = ? ";

        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, ma);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang();
                cuaHang.setId(rs.getString(1));
                cuaHang.setMa(rs.getString(2));
                cuaHang.setTen(rs.getString(3));
                cuaHang.setDiaChi(rs.getString(4));
                cuaHang.setThanhPho(rs.getString(5));
                cuaHang.setQuocGia(rs.getString(6));
                return cuaHang;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertCuaHang(CuaHang t) {
        int check = 0;
        String sql = "insert into CuaHang(Ma, Ten, DiaChi, ThanhPho, QuocGia)\n"
                + "values (?,?,?,?,?)";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getDiaChi());
            prs.setObject(4, t.getThanhPho());
            prs.setObject(5, t.getQuocGia());
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean deleteCuaHangById(String id) {
        int check = 0;
        String sql = "delete from CuaHang"
                + " where id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, id);

            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean updateCuaHang(CuaHang t, String id) {
        int check = 0;
        String sql = " update CuaHang\n"
                + " set Ma =?, Ten=?, DiaChi=?, ThanhPho=?, QuocGia=?\n"
                + " where Id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getDiaChi());
            prs.setObject(4, t.getThanhPho());
            prs.setObject(5, t.getQuocGia());
            prs.setObject(6, id);
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        CuaHang kh = new irepository.repository.CuaHangRepository().selectByTen("Kim 2n");
        System.out.println("" + kh);
        List<CuaHang> lists = new irepository.repository.CuaHangRepository().selectAllCuaHang();
        System.out.println(" " + lists);
    }

    @Override
    public CuaHang selectByTen(String ten) {
        String sql = " select Ten ";

        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, ten);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang();
                cuaHang.setTen(rs.getString(1));
                return cuaHang;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
