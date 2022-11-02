/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChucVu;
import domainmodel.CuaHang;
import domainmodel.NhanVien;
import irepository.repository.NhanVienRepository;
import java.util.ArrayList;
import java.util.List;
import service.NhanVienService;
import viewmodel.QLChucVu;
import viewmodel.QLCuaHang;
import viewmodel.QLNhanVien;

/**
 *
 * @author ASUS
 */
public class NhanVienImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepsitory = new NhanVienRepository();

    @Override
    public String addCuaHang(QLNhanVien t) {
        
        NhanVien nhanVien = new NhanVien();
        
        nhanVien.setMa(t.getMa());
        nhanVien.setHo(t.getHo());
        nhanVien.setTen(t.getTen());
        nhanVien.setTenDem(t.getTenDem());
        nhanVien.setGioiTinh(t.getGioiTinh());
        nhanVien.setNgaySinh(t.getNgaySinh());
        nhanVien.setDiaChi(t.getDiaChi());
        nhanVien.setMatKhau(t.getMatKhau());

        CuaHang ch = new CuaHang();
        ch.setId(t.getIdCH().getId());
        nhanVien.setIdCH(ch);

        ChucVu cv = new ChucVu();
        cv.setId(t.getIdCV().getId());
        nhanVien.setIdCV(cv);

        nhanVien.setTrangThai(t.getTrangThai());

        boolean ql = nhanVienRepsitory.insertCuaHang(nhanVien);
        if (ql) {
            return "thêm thành công";
        } else {
            return " thêm không thành công";
        }
    }

    @Override
    public List<QLNhanVien> selectAll() {
        List<NhanVien> list = nhanVienRepsitory.selectAllNhanVien();
        List<QLNhanVien> listQL = new ArrayList<>();
        for (NhanVien t : list) {
            QLNhanVien ql = new QLNhanVien();
            ql.setId(t.getId());
            ql.setMa(t.getMa());
            ql.setHo(t.getHo());
            ql.setTen(t.getTen());
            ql.setTenDem(t.getTenDem());
            ql.setGioiTinh(t.getGioiTinh());
            ql.setNgaySinh(t.getNgaySinh());
            ql.setDiaChi(t.getDiaChi());
            ql.setMatKhau(t.getMatKhau());

            QLCuaHang qlCH = new QLCuaHang();
            qlCH.setTen(t.getIdCH().getTen());
            ql.setIdCH(qlCH);

            QLChucVu cv = new QLChucVu();
            cv.setTen(t.getIdCV().getTen());
            ql.setIdCV(cv);

            ql.setTrangThai(t.getTrangThai());
            listQL.add(ql);
        }
        return listQL;
    }

    @Override
    public String updateNhanVien(QLNhanVien t, String id) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(t.getMa());
        nhanVien.setHo(t.getHo());
        nhanVien.setTen(t.getTen());
        nhanVien.setTenDem(t.getTenDem());
        nhanVien.setGioiTinh(t.getGioiTinh());
        nhanVien.setNgaySinh(t.getNgaySinh());
        nhanVien.setDiaChi(t.getDiaChi());
        nhanVien.setMatKhau(t.getMatKhau());

        CuaHang ch = new CuaHang();
        ch.setId(t.getIdCH().getId());
        nhanVien.setIdCH(ch);

        ChucVu cv = new ChucVu();
        cv.setId(t.getIdCV().getId());
        nhanVien.setIdCV(cv);

        nhanVien.setTrangThai(t.getTrangThai());

        boolean ql = nhanVienRepsitory.updateCuaHang(nhanVien, id);
        if (ql) {
            return "thêm thành công";
        } else {
            return " thêm không thành công";
        }
    }

    @Override
    public String deleteNhanVien(String id) {
        boolean ql = nhanVienRepsitory.deleteCuaHangById(id);
        if (ql) {
            return "thêm thành công";
        } else {
            return " thêm không thành công";
        }
    }

}
