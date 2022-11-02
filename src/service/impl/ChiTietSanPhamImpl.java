/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChiTietSanPham;
import domainmodel.DongSanPham;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import domainmodel.SanPham;
import irepository.repository.ChiTietSanPhamRepository;
import java.util.ArrayList;
import java.util.List;
import service.ChiTietSanPhamService;
import viewmodel.QLChiTietSanPham;
import viewmodel.QLMauSac;
import viewmodel.QLNhaSanXuat;
import viewmodel.QLSanPham;
import viewmodel.QlDongSanPham;

public class ChiTietSanPhamImpl implements ChiTietSanPhamService {
    
    private ChiTietSanPhamRepository chiTietRepository = new ChiTietSanPhamRepository();
    
    @Override
    public String addChiTietSP(QLChiTietSanPham t) {
        if (t.getIdSP().getId().isEmpty() || t.getIdNSX().getId().isEmpty() || t.getIdMaiSac().getId().isEmpty() || t.getIdDongSP().getId().isEmpty()
                || t.getMoTa().trim().isEmpty() || String.valueOf(t.getNamBH()).trim().isEmpty() || String.valueOf(t.getSoLuongTon()).trim().isEmpty() || String.valueOf(t.getGiaNhap()).trim().isEmpty()
                || String.valueOf(t.getGiaBan()).trim().isEmpty()) {
            return "Không đc để trống";
        }
        ChiTietSanPham ctsp = new ChiTietSanPham();
        SanPham sp = new SanPham();
        sp.setId(t.getIdSP().getId());
        ctsp.setIdSP(sp);
        
        NhaSanXuat nsx = new NhaSanXuat();
        nsx.setId(t.getIdNSX().getId());
        ctsp.setIdNSX(nsx);
        
        MauSac ms = new MauSac();
        ms.setId(t.getIdMaiSac().getId());
        ctsp.setIdMaiSac(ms);
        
        DongSanPham dsp = new DongSanPham();
        dsp.setId(t.getIdDongSP().getId());
        ctsp.setIdDongSP(dsp);
        
        ctsp.setMoTa(t.getMoTa());
        ctsp.setNamBH(t.getNamBH());
        ctsp.setSoLuongTon(t.getSoLuongTon());
        ctsp.setGiaNhap(t.getGiaNhap());
        ctsp.setGiaBan(t.getGiaBan());
        boolean qlSP = chiTietRepository.insertChiTietSanPham(ctsp);
        if (qlSP) {
            return "Thêm đối tượng thành công";
        } else {
            return "thên đối tường không thành công";
        }
    }
    
    @Override
    public List<QLChiTietSanPham> selectAll() {
        List<ChiTietSanPham> listCTSP = chiTietRepository.selectAllChiTietSanPham();
        List<QLChiTietSanPham> listQl = new ArrayList<>();
        for (ChiTietSanPham ct : listCTSP) {
            QLChiTietSanPham ql = new QLChiTietSanPham();
            ql.setId(ct.getId());
            
            QLSanPham qlSP = new QLSanPham();
            qlSP.setMa(ct.getIdSP().getMa());
            qlSP.setTen(ct.getIdSP().getTen());
            ql.setIdSP(qlSP);
            
            QLNhaSanXuat nsx = new QLNhaSanXuat();
            nsx.setTen(ct.getIdNSX().getTen());
            ql.setIdNSX(nsx);
            
            QLMauSac ms = new QLMauSac();
            ms.setTen(ct.getIdMaiSac().getTen());
            ql.setIdMaiSac(ms);
            
            QlDongSanPham dsp = new QlDongSanPham();
            dsp.setTen(ct.getIdDongSP().getTen());
            ql.setIdDongSP(dsp);
            
            ql.setNamBH(ct.getNamBH());
            ql.setMoTa(ct.getMoTa());
            ql.setSoLuongTon(ct.getSoLuongTon());
            ql.setGiaNhap(ct.getGiaNhap());
            ql.setGiaBan(ct.getGiaBan());
            listQl.add(ql);
        }
        return listQl;
    }
    
    @Override
    public String updateChiTietSP(QLChiTietSanPham t, String id) {
//        idSP.getTen(), idNSX.getTen(), idMaiSac.getTen(), idDongSP.getTen(), moTa, namBH, soLuongTon, giaNhap, giaBan
        if (t.getIdSP().getId().isEmpty() || t.getIdNSX().getId().isEmpty() || t.getIdMaiSac().getId().isEmpty() || t.getIdDongSP().getId().isEmpty()
                || t.getMoTa().trim().isEmpty() || String.valueOf(t.getNamBH()).trim().isEmpty() || String.valueOf(t.getSoLuongTon()).trim().isEmpty() || String.valueOf(t.getGiaNhap()).trim().isEmpty()
                || String.valueOf(t.getGiaBan()).trim().isEmpty()) {
            return "Không đc để trống";
        }
        ChiTietSanPham ctsp = new ChiTietSanPham();
        SanPham sp = new SanPham();
        sp.setId(t.getIdSP().getId());
        ctsp.setIdSP(sp);
        
        NhaSanXuat nsx = new NhaSanXuat();
        nsx.setId(t.getIdNSX().getId());
        ctsp.setIdNSX(nsx);
        
        MauSac ms = new MauSac();
        ms.setId(t.getIdMaiSac().getId());
        ctsp.setIdMaiSac(ms);
        
        DongSanPham dsp = new DongSanPham();
        dsp.setId(t.getIdDongSP().getId());
        ctsp.setIdDongSP(dsp);
        
        ctsp.setMoTa(t.getMoTa());
        ctsp.setNamBH(t.getNamBH());
        ctsp.setSoLuongTon(t.getSoLuongTon());
        ctsp.setGiaNhap(t.getGiaNhap());
        ctsp.setGiaBan(t.getGiaBan());
        boolean qlSP = chiTietRepository.updateChiTietSanPham(ctsp, id);
        if (qlSP) {
            return "Thêm đối tượng thành công";
        } else {
            return "thên đối tường không thành công";
        }
    }
    
    @Override
    public String deleteChiTietSP(String id) {
        boolean qlSP = chiTietRepository.deleteChiTietSanPhamById(id);
        if (qlSP) {
            return "Xóa đối tượng thành công";
        } else {
            return "Xóa đối tường không thành công";
        }
    }

    @Override
    public String updateSoLuonTon(int soLuonTon, String id) {
        boolean ss = chiTietRepository.updateSoLuongTon(soLuonTon, id);
        return null;
    }
    
}
