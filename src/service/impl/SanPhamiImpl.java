/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPham;
import irepository.repository.SanPhamRepository;
import java.util.ArrayList;
import java.util.List;
import service.SanPhamService;
import viewmodel.QLSanPham;

public class SanPhamiImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public String addSanPham(QLSanPham t) {
        if (t.getMa().trim().isEmpty()) {
            return "Không đc để trống";
        }

        if (t.getTen().trim().isEmpty()) {
            return "Không đc để trống";
        }

        List<SanPham> listSP = sanPhamRepository.selectAllSanPham();
        for (SanPham sanPham : listSP) {
            if (t.getMa().equalsIgnoreCase(sanPham.getMa())) {
                return "Mã trùng yêu cầu nhập lại";
            }
        }

        SanPham sanPham = new SanPham();
        sanPham.setMa(t.getMa());
        sanPham.setTen(t.getTen());
        boolean addSanPham = sanPhamRepository.insertSanPham(sanPham);
        if (addSanPham) {
            return "Thêm thành công";
        } else {
            return "Thêm không thành công";
        }
    }

    @Override
    public List<QLSanPham> selectAll() {
        List<SanPham> listSP = sanPhamRepository.selectAllSanPham();
        List<QLSanPham> listQLSP = new ArrayList<>();
        for (SanPham sanPham : listSP) {
            QLSanPham ql = new QLSanPham();
            ql.setId(sanPham.getId());
            ql.setMa(sanPham.getMa());
            ql.setTen(sanPham.getTen());
            listQLSP.add(ql);
        }
        return listQLSP;
    }

    @Override
    public String updateSanPham(QLSanPham t, String id) {
        if (t.getMa().trim().isEmpty()) {
            return "Không đc để trống";
        }

        if (t.getTen().trim().isEmpty()) {
            return "Không đc để trống";
        }

        SanPham sanPham = new SanPham();
        sanPham.setMa(t.getMa());
        sanPham.setTen(t.getTen());
        boolean addSanPham = sanPhamRepository.updateSanPham(sanPham, id);
        if (addSanPham) {
            return "Sửa thành công";
        } else {
            return "Sửa không thành công";
        }
    }

    @Override
    public String deleteSanPham(String id) {
        boolean update = sanPhamRepository.deleteSanPhamById(id);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xpas thất bại";
        }
    }

}
