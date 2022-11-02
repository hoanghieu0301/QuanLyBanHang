/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChiTietSanPham;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import irepository.repository.HoaDonChiTietRepository;
import java.util.ArrayList;
import java.util.List;
import service.HoaDonChiTietService;
import viewmodel.QLChiTietSanPham;
import viewmodel.QLHoaDon;
import viewmodel.QLHoaDonChiTiet;
import viewmodel.QLSanPham;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTietImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    @Override
    public String addHoaDonChiTiet(QLHoaDonChiTiet t) {
        //        idHoaDon, idChiTietSP, SoLuong, DonGia
        HoaDonChiTiet hdct = new HoaDonChiTiet();

        HoaDon hd = new HoaDon();
        hd.setId(t.getIdHoaDon().getId());
        hdct.setIdHoaDon(hd);

        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setId(t.getIdChiTietSP().getId());
        hdct.setIdChiTietSP(ctsp);

        hdct.setSoLuong(t.getSoLuong());
        hdct.setDonGia(t.getDonGia());

        boolean addHDCT = hoaDonChiTietRepository.insertHoaDonChiTiet(hdct);
        if (addHDCT) {
            return "Thêm hóa đơn chi tiết thành công";

        } else {
            return "Thêm hóa đơn chi tiết không thành công";
        }
    }

    @Override
    public List<QLHoaDonChiTiet> selectAll() {
        List<HoaDonChiTiet> listHoaDonChiTiet = hoaDonChiTietRepository.selectAllDHoaDonChiTiet();
        List<QLHoaDonChiTiet> listQL = new ArrayList<>();
        //HoaDonChiTiet.IdHoaDon,HoaDonChiTiet.IdChiTietSP, SanPham.Ma,  SanPham.Ten, SoLuong, DonGia
        for (HoaDonChiTiet hd : listHoaDonChiTiet) {
            QLHoaDonChiTiet ql = new QLHoaDonChiTiet();

            QLHoaDon qlHD = new QLHoaDon();
            qlHD.setId(hd.getIdHoaDon().getId());
            ql.setIdHoaDon(qlHD);

            QLChiTietSanPham ctSP = new QLChiTietSanPham();
            ctSP.setId(hd.getIdChiTietSP().getId());
            ql.setIdChiTietSP(ctSP);

            QLSanPham sp = new QLSanPham();
            sp.setMa(hd.getIdChiTietSP().getIdSP().getMa());
            sp.setTen(hd.getIdChiTietSP().getIdSP().getTen());
            ctSP.setIdSP(sp);

            ql.setSoLuong(hd.getSoLuong());

            ql.setDonGia(hd.getDonGia());
            listQL.add(ql);
        }
        return listQL;
    }

    public static void main(String[] args) {
        List<QLHoaDonChiTiet> lists = new service.impl.HoaDonChiTietImpl().selectAll();
        System.out.println("" + lists);
    }
}
