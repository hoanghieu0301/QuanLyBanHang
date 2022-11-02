/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import irepository.repository.KhachHangRepository;
import java.util.ArrayList;
import java.util.List;
import service.KhachHangService;
import viewmodel.QLKhachHang;

/**
 *
 * @author ASUS
 */
public class KhachHangImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public String addKhachHang(QLKhachHang t) {
        KhachHang kh = new KhachHang();

        kh.setMa(t.getMa());
        kh.setTen(t.getTen());
        kh.setTenDem(t.getTenDem());
        kh.setHo(t.getHo());
        kh.setNgaySinh(t.getNgaySinh());
        kh.setSdt(t.getSdt());
        kh.setDiaChi(t.getDiaChi());
        kh.setThanhPho(t.getThanhPho());
        kh.setQuocGia(t.getQuocGia());
        kh.setMatKhau(t.getMatKhau());

        boolean addKH = khachHangRepository.insertKhachHang(kh);
        if (addKH) {
            return "Thêm khách hàng thành công";
        } else {
            return "Thêm khách hàng không thành công";
        }
    }

    @Override
    public List<QLKhachHang> selectAll() {
        List<KhachHang> kh = khachHangRepository.selectAllKhachHang();
        List<QLKhachHang> listQL = new ArrayList<>();
        for (KhachHang x : kh) {
            //Id, Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau
            QLKhachHang qlKh = new QLKhachHang();
            qlKh.setId(x.getId());
            qlKh.setMa(x.getMa());
            qlKh.setTen(x.getTen());
            qlKh.setTenDem(x.getTenDem());
            qlKh.setHo(x.getHo());
            qlKh.setNgaySinh(x.getNgaySinh());
            qlKh.setSdt(x.getSdt());
            qlKh.setDiaChi(x.getDiaChi());
            qlKh.setThanhPho(x.getThanhPho());
            qlKh.setQuocGia(x.getQuocGia());
            qlKh.setMatKhau(x.getMatKhau());

            listQL.add(qlKh);
        }
        return listQL;
    }

    @Override
    public String update(QLKhachHang t, String id) {
        KhachHang kh = new KhachHang();

        kh.setMa(t.getMa());
        kh.setTen(t.getTen());
        kh.setTenDem(t.getTenDem());
        kh.setHo(t.getHo());
        kh.setNgaySinh(t.getNgaySinh());
        kh.setSdt(t.getSdt());
        kh.setDiaChi(t.getDiaChi());
        kh.setThanhPho(t.getThanhPho());
        kh.setQuocGia(t.getQuocGia());
        kh.setMatKhau(t.getMatKhau());

        boolean addKH = khachHangRepository.updateKhachHang(kh, id);
        if (addKH) {
            return "Cập nhập khách hàng thành công";
        } else {
            return "Cập nhập khách hàng không thành công";
        }
    }

    @Override
    public String deleteKhachHang(String id) {
        boolean addKH = khachHangRepository.deleteKhachHang(id);
        if (addKH) {
            return "Xóa khách hàng thành công";
        } else {
            return "Xóa khách hàng không thành công";
        }
    }

}
