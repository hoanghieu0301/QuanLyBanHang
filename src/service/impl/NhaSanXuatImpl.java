/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.NhaSanXuat;
import irepository.repository.NhaSanXuatRepository;
import java.util.ArrayList;
import java.util.List;
import service.NhaSanXuatService;
import viewmodel.QLNhaSanXuat;

/**
 *
 * @author ASUS
 */
public class NhaSanXuatImpl implements NhaSanXuatService {

    private NhaSanXuatRepository nsxRepository = new NhaSanXuatRepository();

    @Override
    public String addNXS(QLNhaSanXuat t) {
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
        boolean insertChucVu = nsxRepository.insertNSX(new NhaSanXuat(t.getMa(), t.getTen()));
        if (insertChucVu) {
            return "Thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public List<QLNhaSanXuat> selectAll() {
        List<NhaSanXuat> listDongSP = nsxRepository.selectAllNSX();
        List<QLNhaSanXuat> listQLDSP = new ArrayList<>();
        for (NhaSanXuat x : listDongSP) {
            QLNhaSanXuat qlDSP = new QLNhaSanXuat();
            qlDSP.setId(x.getId());
            qlDSP.setMa(x.getMa());
            qlDSP.setTen(x.getTen());
            listQLDSP.add(qlDSP);
        }
        return listQLDSP;
    }

    @Override
    public String updateNSX(QLNhaSanXuat t, String id) {
        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        } else {
            boolean update = nsxRepository.update(new NhaSanXuat(t.getMa(), t.getTen()), id);
            if (update) {
                return "Update thành công";
            } else {
                return "Update thất bại";
            }
        }
    }

    @Override
    public String deleteNSX(String id) {
        boolean update = nsxRepository.deleteNSXById(id);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xpas thất bại";
        }
    }

}
