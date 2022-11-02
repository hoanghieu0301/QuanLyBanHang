/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DongSanPham;
import irepository.repository.DongSanPhamRepository;
import java.util.ArrayList;
import java.util.List;
import service.DongSanPhamService;
import viewmodel.QlDongSanPham;

/**
 *
 * @author ASUS
 */
public class DongSanPhamImpl implements DongSanPhamService {

    private DongSanPhamRepository dongSPRepository = new DongSanPhamRepository();

    @Override
    public String addDongSP(QlDongSanPham t) {
        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        }
//      
//        listQLChucVu = selectAll();
//        for (QLChucVu ql : listQLChucVu) {
//            if (ql.getTen().equalsIgnoreCase(t.getTen())) {
//                return "Tên chức vụ trùng yêu cầu nhập lại";
//            }
//        }
        boolean insertChucVu = dongSPRepository.insertDSP(new DongSanPham(t.getMa(), t.getTen()));
        if (insertChucVu) {
            return "Thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public List<QlDongSanPham> selectAll() {
        List<DongSanPham> listDongSP = dongSPRepository.selectAllDSP();
        List<QlDongSanPham> listQLDSP = new ArrayList<>();
        for (DongSanPham x : listDongSP) {
            QlDongSanPham qlDSP = new QlDongSanPham();
            qlDSP.setId(x.getId());
            qlDSP.setMa(x.getMa());
            qlDSP.setTen(x.getTen());
            listQLDSP.add(qlDSP);
        }
        return listQLDSP;
    }

    @Override
    public String updateDongSP(QlDongSanPham t, String id) {
        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        } else {
            boolean update = dongSPRepository.updateDSP(new DongSanPham(t.getMa(), t.getTen()), id);
            if (update) {
                return "Update thành công";
            } else {
                return "Update thất bại";
            }
        }
    }

    @Override
    public String deleteDongSP(String id) {
        boolean update = dongSPRepository.deleteDSPById(id);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xpas thất bại";
        }
    }

}
