/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;


import domainmodel.CuaHang;
import irepository.repository.CuaHangRepository;
import java.util.ArrayList;
import java.util.List;
import service.CuaHangService;
import viewmodel.QLCuaHang;

/**
 *
 * @author ASUS
 */
public class CuaHangImpl implements CuaHangService {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    @Override
    public String addCuaHang(QLCuaHang t) {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(t.getMa());
        cuaHang.setTen(t.getTen());
        cuaHang.setDiaChi(t.getDiaChi());
        cuaHang.setThanhPho(t.getThanhPho());
        cuaHang.setQuocGia(t.getQuocGia());
        boolean add = cuaHangRepository.insertCuaHang(cuaHang);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm không thành công";
        }
    }

    @Override
    public List<QLCuaHang> selectAll() {
        List<CuaHang> lists = cuaHangRepository.selectAllCuaHang();
        List<QLCuaHang> listQLCuaHang = new ArrayList<>();
        for (CuaHang x : lists) {
            QLCuaHang qlCuaHang = new QLCuaHang();
            qlCuaHang.setId(x.getId());
            qlCuaHang.setMa(x.getMa());
            qlCuaHang.setTen(x.getTen());
            qlCuaHang.setDiaChi(x.getDiaChi());
            qlCuaHang.setThanhPho(x.getThanhPho());
            qlCuaHang.setQuocGia(x.getQuocGia());
            listQLCuaHang.add(qlCuaHang);
        }
        return listQLCuaHang;
    }

    @Override
    public String updateCuaHang(QLCuaHang t, String id) {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(t.getMa());
        cuaHang.setTen(t.getTen());
        cuaHang.setDiaChi(t.getDiaChi());
        cuaHang.setThanhPho(t.getThanhPho());
        cuaHang.setQuocGia(t.getQuocGia());
        boolean add = cuaHangRepository.updateCuaHang(cuaHang, id);
        if (add) {
            return "Update thành công";
        } else {
            return "Update không thành công";
        }
    }

    @Override
    public String deleteCuaHang(String id) {
        boolean add = cuaHangRepository.deleteCuaHangById(id);
        if (add) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public QLCuaHang searchByMa(String ma) {
        CuaHang cuaHang = cuaHangRepository.selectCuaHangByMa(ma);
        if (cuaHang != null) {
            QLCuaHang qlCuaHang = new QLCuaHang();
            qlCuaHang.setId(cuaHang.getId());
            qlCuaHang.setMa(cuaHang.getMa());
            qlCuaHang.setTen(cuaHang.getTen());
            qlCuaHang.setDiaChi(cuaHang.getDiaChi());
            qlCuaHang.setThanhPho(cuaHang.getThanhPho());
            qlCuaHang.setQuocGia(cuaHang.getQuocGia());
            return qlCuaHang;
        } else {
            return null;
        }

    }
    
    public static void main(String[] args) {
        List<QLCuaHang> list = new service.impl.CuaHangImpl().selectAll();
        System.out.println(""+list);
    }

    @Override
    public QLCuaHang selectByTen(String ten) {
        CuaHang cuaHang = cuaHangRepository.selectByTen(ten);
        QLCuaHang ql = new QLCuaHang();
        ql.setId(cuaHang.getId());
        return ql;
    }

}
