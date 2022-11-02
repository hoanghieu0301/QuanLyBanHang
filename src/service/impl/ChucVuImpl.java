/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChucVu;
import service.ChucVuService;
import viewmodel.QLChucVu;
import irepository.IChucVuRepository;
import irepository.repository.ChucVuRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ChucVuImpl implements ChucVuService {

    private IChucVuRepository chucVuRepository = new ChucVuRepository();
    private List<QLChucVu> listQLChucVu = new ArrayList<>();

    @Override
    public String addChucVu(QLChucVu t) {
        // chuyển giao đầu vào từ Ql chức vụ vào chức vụ
        QLChucVu qlChucVu = new QLChucVu();
        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        }
        qlChucVu = new service.impl.ChucVuImpl().searchByMa(t.getMa());
        if (qlChucVu != null) {
            return "Mã trùng yêu cầu nhập lại";
        }
        listQLChucVu = selectAll();
        for (QLChucVu ql : listQLChucVu) {
            if (ql.getTen().equalsIgnoreCase(t.getTen())) {
                return "Tên chức vụ trùng yêu cầu nhập lại";
            }
        }
        boolean insertChucVu = chucVuRepository.insertChucVu(new ChucVu(t.getMa(), t.getTen()));
        if (insertChucVu) {
            return "Thêm thành công";
        } else {
            return "thêm thất bại";
        }

    }

    @Override
    public List<QLChucVu> selectAll() {
        List<ChucVu> listChuVu = chucVuRepository.selectAllChucVu();
        for (ChucVu x : listChuVu) {
            QLChucVu qlChucVu = new QLChucVu();
            qlChucVu.setId(x.getId());
            qlChucVu.setMa(x.getMa());
            qlChucVu.setTen(x.getTen());
            listQLChucVu.add(qlChucVu);
        }
        return listQLChucVu;
    }

    @Override
    public String updateChucVu(QLChucVu t, String id) {

        if (t.getMa().trim().isEmpty() || t.getTen().trim().isEmpty() == true) {
            return "Không được để trống";
        } else {
            boolean update = chucVuRepository.updateChucVu(new ChucVu(t.getMa(), t.getTen()), id);
            if (update) {
                return "Update thành công";
            } else {
                return "Update thất bại";
            }
        }
    }

    @Override
    public String deleteChucVu(String id) {
        boolean update = chucVuRepository.deleteChuVu(id);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xpas thất bại";
        }
    }

    @Override
    public QLChucVu searchByMa(String ma) {
        ChucVu cv = chucVuRepository.searchByMa(ma);
        if (cv != null) {
            QLChucVu ql = new QLChucVu();
            ql.setId(cv.getId());
            ql.setMa(cv.getMa());
            ql.setTen(cv.getTen());
            return ql;
        } else {
            return null;
        }
    }

    @Override
    public QLChucVu selectByTen(String ten) {
        ChucVu chucVu = chucVuRepository.searchByTen(ten);
        QLChucVu ql = new QLChucVu();
        ql.setId(chucVu.getId());
        return ql;
    }
}
