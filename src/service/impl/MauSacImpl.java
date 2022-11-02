/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.MauSac;
import irepository.repository.MauSacRepository;
import java.util.ArrayList;
import java.util.List;
import service.MauSacService;
import viewmodel.QLMauSac;

/**
 *
 * @author ASUS
 */
public class MauSacImpl implements MauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public String addMauSac(QLMauSac t) {
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
        boolean insertChucVu = mauSacRepository.insertMauSac(new MauSac(t.getMa(), t.getTen()));
        if (insertChucVu) {
            return "Thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public List<QLMauSac> selectAll() {
        List<MauSac> listMau = mauSacRepository.selectAllMauSac();
        List<QLMauSac> list = new ArrayList<>();
        for (MauSac x : listMau) {
            QLMauSac qlDSP = new QLMauSac();
            qlDSP.setId(x.getId());
            qlDSP.setMa(x.getMa());
            qlDSP.setTen(x.getTen());
            list.add(qlDSP);
        }
        return list;
    }

    @Override
    public String updateMauSac(QLMauSac t, String id) {
        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        } else {
            boolean update = mauSacRepository.updateMauSac(new MauSac(t.getMa(), t.getTen()), id);
            if (update) {
                return "Update thành công";
            } else {
                return "Update thất bại";
            }
        }
    }

    @Override
    public String deleteMauSac(String id) {
        boolean update = mauSacRepository.deleteMauSacById(id);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xpas thất bại";
        }
    }

}
