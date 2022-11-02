/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.ChucVu;
import domainmodel.CuaHang;
import domainmodel.NhanVien;
import irepository.INhanVienRepository;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienRepository implements INhanVienRepository {
    
    @Override
    public List<NhanVien> selectAllNhanVien() {
        
        String sql = " select NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau,CuaHang.Ten , ChucVu.Ten, TrangThai\n"
                + " from NhanVien join CuaHang on NhanVien.IdCH = CuaHang.id\n"
                + "			join ChucVu on NhanVien.IdCV = ChucVu.Id";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            List<NhanVien> listNhanVien = new ArrayList();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getString(1));
                nhanVien.setMa(rs.getString(2));
                nhanVien.setTen(rs.getString(3));
                nhanVien.setTenDem(rs.getString(4));
                nhanVien.setHo(rs.getString(5));
                nhanVien.setGioiTinh(rs.getString(6));
                nhanVien.setNgaySinh(rs.getDate(7));
                nhanVien.setDiaChi(rs.getString(8));
                nhanVien.setSdt(rs.getString(9));
                nhanVien.setMatKhau(rs.getString(10));
                
                CuaHang cuaHang = new CuaHang();
                cuaHang.setTen(rs.getString(11));
                nhanVien.setIdCH(cuaHang);
                
                ChucVu chucVu = new ChucVu();
                chucVu.setTen(rs.getString(12));
                nhanVien.setIdCV(chucVu);
                
                nhanVien.setTrangThai(rs.getInt(13));
                listNhanVien.add(nhanVien);
            }
            return listNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Boolean insertCuaHang(NhanVien t) {
        int check = 0;
        String sql = " insert into NhanVien(Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai)\n"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getTenDem());
            prs.setObject(4, t.getHo());
            prs.setObject(5, t.getGioiTinh());
            prs.setObject(6, t.getNgaySinh());
            prs.setObject(7, t.getDiaChi());
            prs.setObject(8, t.getSdt());
            prs.setObject(9, t.getMatKhau());
            prs.setObject(10, t.getIdCH().getId());
            prs.setObject(11, t.getIdCV().getId());
            prs.setObject(12, t.getTrangThai());
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    @Override
    public Boolean deleteCuaHangById(String id) {
        int check = 0;
        String sql = " delete from NhanVien\n"
                + " where Id = ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, id);
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    @Override
    public Boolean updateCuaHang(NhanVien t, String id) {
        int check = 0;
        String sql = " update NhanVien\n"
                + " set Ma = ?, Ten = ?, TenDem = ?, Ho = ?, GioiTinh= ?, NgaySinh = ?, DiaChi = ?, Sdt = ?, MatKhau = ?, IdCH = ?, IdCV = ?, TrangThai = ?\n"
                + " where Id = ? ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql);) {
            prs.setObject(1, t.getMa());
            prs.setObject(2, t.getTen());
            prs.setObject(3, t.getTenDem());
            prs.setObject(4, t.getHo());
            prs.setObject(5, t.getGioiTinh());
            prs.setObject(6, t.getNgaySinh());
            prs.setObject(7, t.getDiaChi());
            prs.setObject(8, t.getSdt());
            prs.setObject(9, t.getMatKhau());
            prs.setObject(10, t.getIdCH().getId());
            prs.setObject(11, t.getIdCV().getId());
            prs.setObject(12, t.getTrangThai());
            prs.setObject(13, id);
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        List<NhanVien> list = new irepository.repository.NhanVienRepository().selectAllNhanVien();
        System.out.println("" + list);
    }
}
