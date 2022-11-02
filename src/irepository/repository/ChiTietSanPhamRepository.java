/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irepository.repository;

import domainmodel.ChiTietSanPham;
import domainmodel.DongSanPham;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import domainmodel.SanPham;
import irepository.IChiTietSanPhamRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietSanPhamRepository implements IChiTietSanPhamRepository {

    @Override
    public List<ChiTietSanPham> selectAllChiTietSanPham() {
        String sql = " select ChiTietSP.id, SanPham.Ten, NSX.Ten, MauSac.Ten, DongSP.Ten, NamBH, "
                + " MoTa, SoLuongTon, GiaNhap, GiaBan, SanPham.ma\n "
                + "from ChiTietSP join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "				join NSX on ChiTietSP.IdNsx = NSX.Id\n"
                + "				join MauSac on ChiTietSP.IdMauSac = MauSac.Id\n"
                + "				join DongSP on ChiTietSP.IdDongSP = DongSP.Id ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            List<ChiTietSanPham> listChiTietSp = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setId(rs.getString(1));

                SanPham sp = new SanPham();
                sp.setMa(rs.getString(11));
                sp.setTen(rs.getString(2));
                ctsp.setIdSP(sp);

                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(rs.getString(3));
                ctsp.setIdNSX(nsx);

                MauSac ms = new MauSac();
                ms.setTen(rs.getString(4));
                ctsp.setIdMaiSac(ms);

                DongSanPham dsp = new DongSanPham();
                dsp.setTen(rs.getString(5));
                ctsp.setIdDongSP(dsp);

                ctsp.setNamBH(rs.getInt(6));
                ctsp.setMoTa(rs.getString(7));
                ctsp.setSoLuongTon(rs.getInt(8));
                ctsp.setGiaNhap(rs.getBigDecimal(9));
                ctsp.setGiaBan(rs.getBigDecimal(10));

                listChiTietSp.add(ctsp);
            }
            return listChiTietSp;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insertChiTietSanPham(ChiTietSanPham t) {
        int check = 0;
        String sql = "insert into ChiTietSP(IdSP, IdNsx, IdMauSac, IdDongSP, "
                + "NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan )\n"
                + "values(?,?,?,?,?,?,?,?,?)";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getIdSP().getId());
            prs.setObject(2, t.getIdNSX().getId());
            prs.setObject(3, t.getIdMaiSac().getId());
            prs.setObject(4, t.getIdDongSP().getId());
            prs.setObject(5, t.getNamBH());
            prs.setObject(6, t.getMoTa());
            prs.setObject(7, t.getSoLuongTon());
            prs.setObject(8, t.getGiaNhap());
            prs.setObject(9, t.getGiaBan());
            check = prs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean deleteChiTietSanPhamById(String id) {
        int check = 0;
        String sql = "delete from chitietsanpham where id = ? ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, id);
            check = prs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public Boolean updateChiTietSanPham(ChiTietSanPham t, String id) {
        int check = 0;
        String sql = "insert into ChiTietSP(IdSP, IdNsx, IdMauSac, IdDongSP, "
                + "NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan )\n"
                + "values(?,?,?,?,?,?,?,?,?)"
                + "where id = ? ";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, t.getIdSP().getId());
            prs.setObject(2, t.getIdNSX().getId());
            prs.setObject(3, t.getIdMaiSac().getId());
            prs.setObject(4, t.getIdDongSP().getId());
            prs.setObject(5, t.getNamBH());
            prs.setObject(6, t.getMoTa());
            prs.setObject(7, t.getSoLuongTon());
            prs.setObject(8, t.getGiaNhap());
            prs.setObject(9, t.getGiaBan());
            prs.setObject(10, id);
            check = prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public ChiTietSanPham selectByTen(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        List<ChiTietSanPham> lists = new ChiTietSanPhamRepository().selectAllChiTietSanPham();
        System.out.println("" + lists);
    }

    @Override
    public Boolean updateSoLuongTon(int soLuonTon, String id) {
        int check = 0;
        String sql = "update ChiTietSP\n"
                + "set SoLuongTon = ?\n"
                + "where id =  ?";
        try ( Connection con = utilities.DBConnection.getConnection();  PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, soLuonTon);
            prs.setObject(2, id);
            check = prs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
