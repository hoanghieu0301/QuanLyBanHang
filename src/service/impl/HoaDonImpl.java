/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.NhanVien;
import irepository.repository.HoaDonRepository;
import java.util.ArrayList;
import java.util.List;
import service.HoaDonService;
import viewmodel.QLHoaDon;
import viewmodel.QLKhachHang;
import viewmodel.QLNhanVien;

/**
 *
 * @author ASUS
 */
public class HoaDonImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public String addCuaHang(QLHoaDon t) {
//        IdKH, IdNV, Ma, NgayTao, TinhTrang

        if (t.getMa().trim().isEmpty() || String.valueOf(t.getTinhTrang()).trim().isEmpty()) {
            return "Không được để trống";
        }
        HoaDon hd = new HoaDon();
        KhachHang kh = new KhachHang();
        kh.setId(t.getIdKH().getId());
        hd.setIdKH(kh);

        NhanVien nv = new NhanVien();
        nv.setId(t.getIdNV().getId());
        hd.setIdNV(nv);

        hd.setMa(t.getMa());
        hd.setNgayTao(t.getNgayTao());
        hd.setTinhTrang(t.getTinhTrang());

        Boolean addHoaDon = hoaDonRepository.insertHoaDon(hd);
        if (addHoaDon) {
            return "Thêm hóa đơn thành công";
        } else {
            return "Thêm hóa đơn không thành công";
        }

    }

    @Override
    public List<QLHoaDon> selectAll() {
        List<QLHoaDon> qlHoaDon = new ArrayList<>();
        List<HoaDon> list = hoaDonRepository.selectAllDHoaDon();
        for (HoaDon hoDon : list) {

            QLHoaDon ql = new QLHoaDon();
            ql.setId(hoDon.getId());

            QLKhachHang kh = new QLKhachHang();
            kh.setId(hoDon.getIdKH().getId());
            ql.setIdKH(kh);

            QLNhanVien nv = new QLNhanVien();
            nv.setTen(hoDon.getIdNV().getTen());
            nv.setId(hoDon.getIdNV().getId());
            ql.setIdNV(nv);

            ql.setMa(hoDon.getMa());
            ql.setNgayTao(hoDon.getNgayTao());
            ql.setTinhTrang(hoDon.getTinhTrang());
            qlHoaDon.add(ql);
        }
        return qlHoaDon;
    }

    public static void main(String[] args) {
        List<HoaDon> lists = new HoaDonRepository().selectAllDHoaDon();
        System.out.println("" + lists);
    }
}
