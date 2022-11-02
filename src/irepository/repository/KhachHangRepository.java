/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.KhachHang;
import irepository.IKhachHangRepoeitory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangRepository implements IKhachHangRepoeitory {

    @Override
    public List<KhachHang> selectAllKhachHang() {
        String sql = " select Id, Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau\n"
                + " from KhachHang";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            List<KhachHang> listKhachHang = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setTenDem(rs.getString(4));
                kh.setHo(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSdt(rs.getString(7));
                kh.setDiaChi(rs.getString(8));
                kh.setThanhPho(rs.getString(9));
                kh.setQuocGia(rs.getString(10));
                kh.setMatKhau(rs.getString(11));
                listKhachHang.add(kh);
            }
            return listKhachHang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertKhachHang(KhachHang t) {
        int check = 0;
        String sql = " insert into KhachHang (Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau)\n"
                + " values (?, ?, ?, ?, ?, ?, ?, ?,? , ?) ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getTenDem());
            prs.setObject(4, t.getHo());
            prs.setObject(5, t.getNgaySinh());
            prs.setObject(6, t.getSdt());
            prs.setObject(7, t.getDiaChi());
            prs.setObject(8, t.getThanhPho());
            prs.setObject(9, t.getQuocGia());
            prs.setObject(10, t.getMatKhau());
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean updateKhachHang(KhachHang t, String id) {
        int check = 0;
        String sql = " update KhachHang\n "
                + " set Ma = ? , Ten = ?, TenDem = ?, Ho = ?, NgaySinh = ?, Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ?\n"
                + " where Id = ?";

        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getTenDem());
            prs.setObject(4, t.getHo());
            prs.setObject(5, t.getNgaySinh());
            prs.setObject(7, t.getSdt());
            prs.setObject(8, t.getDiaChi());
            prs.setObject(9, t.getThanhPho());
            prs.setObject(10, t.getQuocGia());
            prs.setObject(11, t.getMatKhau());
            prs.setObject(12, id);
            check = prs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean deleteKhachHang(String id) {
        int check = 0;
        String sql = " delete KhachHang\n"
                + " where Id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, id);
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
      
    }

    public static void main(String[] args) {
        List<KhachHang> listKhachHang =  new irepository.repository.KhachHangRepository().selectAllKhachHang();
        System.out.println(""+listKhachHang);
    }
}
