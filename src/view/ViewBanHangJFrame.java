/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSanPhamService;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.impl.ChiTietSanPhamImpl;
import service.impl.HoaDonChiTietImpl;
import service.impl.HoaDonImpl;
import viewmodel.QLChiTietSanPham;
import viewmodel.QLHoaDon;
import viewmodel.QLHoaDonChiTiet;
import viewmodel.QLKhachHang;
import viewmodel.QLNhanVien;
import viewmodel.QLSanPham;

public class ViewBanHangJFrame extends javax.swing.JFrame {

    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private List<QLChiTietSanPham> listChiTietSP = new ArrayList<>();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamImpl();
    private List<QLHoaDon> listQlHoaDon = new ArrayList<>();
    private HoaDonService hoaDonService = new HoaDonImpl();
    private List<QLHoaDonChiTiet> listQLHoaDonChiTiets = new ArrayList<>();
    private HoaDonChiTietService chiTietService = new HoaDonChiTietImpl();
    private int index = -1;

    public ViewBanHangJFrame() {
        initComponents();
        showHeaderSanPham();
        showHeaderHoaDon();
        showHeaderGioHang();
    }

    private void showHeaderGioHang() {
        //HoaDonChiTiet.IdHoaDon,HoaDonChiTiet.IdChiTietSP, SanPham.Ma,  SanPham.Ten, SoLuong, DonGia
        String[] header = {"STT", "Mã SP", "Tên", "Số lượng", "Đơn giá", "Thành Tiền"};
        JTableGioHang.setModel(dtmGioHang);
        dtmGioHang.setColumnIdentifiers(header);
    }

    private void showDataGioHang(List<QLHoaDonChiTiet> listQLHoaDonChiTiets) {
        dtmGioHang.setRowCount(0);
        int stt = 1;
        if (stt <= listQLHoaDonChiTiets.size()) {
            for (QLHoaDonChiTiet ql : listQLHoaDonChiTiets) {
                dtmGioHang.addRow(
                        new Object[]{stt++, ql.getIdChiTietSP().getIdSP().getMa(), ql.getIdChiTietSP().getIdSP().getTen(), ql.getSoLuong(), ql.getDonGia(), ql.getSoLuong() * Integer.parseInt(String.valueOf(ql.getDonGia()))}
                );
            }

        }
    }

    private void showHeaderHoaDon() {
        //ma, ngayTao, idNV.getTen(), tinhTrang(tinhTrang)
        String[] header = {"Stt", "Mã HD", "Ngày tạo", "Tên nhân viên", "Tình trạng"};
        JtableHoaDon.setModel(dtmHoaDon);
        dtmHoaDon.setColumnIdentifiers(header);

        listQlHoaDon = hoaDonService.selectAll();
        showDataHoaDon(listQlHoaDon);
    }

    private void showDataHoaDon(List<QLHoaDon> listQlHoaDon) {
        dtmHoaDon.setRowCount(0);
        int stt = 1;
        String trangThai = null;
        if (stt <= listChiTietSP.size()) {
            for (QLHoaDon ql : listQlHoaDon) {
                if (ql.getTinhTrang() == 0) {
                    trangThai = "Chờ thanh toán";
                } else if (ql.getTinhTrang() == 1) {
                    trangThai = "Đã thanh toán";
                } else {
                    trangThai = "Đã hủy";
                }
                dtmHoaDon.addRow(
                        new Object[]{stt++, ql.getMa(), ql.getNgayTao(), ql.getIdNV().getTen(), trangThai}
                );

                System.out.println("" + ql);
            }

        }

    }

    private void showHeaderSanPham() {
        String[] header = {"Stt", "Mã sp", "Tên sp", "Số lượng", "Giá nhập", "Gía bán", "Miêu tả"};
        JTableSanPham.setModel(dtmSanPham);
        dtmSanPham.setColumnIdentifiers(header);

        listChiTietSP = chiTietSanPhamService.selectAll();
        showDataSanPham(listChiTietSP);
    }

    private void showDataSanPham(List<QLChiTietSanPham> listChiTietSP) {
        dtmSanPham.setRowCount(0);
        int stt = 1;
        if (stt <= listChiTietSP.size()) {
            for (QLChiTietSanPham ql : listChiTietSP) {
                dtmSanPham.addRow(
                        new Object[]{stt++, ql.getIdSP().getMa(), ql.getIdSP().getTen(), ql.getSoLuongTon(), ql.getGiaNhap(), ql.getGiaBan(), ql.getMoTa()}
                );
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableGioHang = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableHoaDon = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblIdHoaDon = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        JTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableSanPham);

        jLabel1.setText("Tìm kiếm");

        jLabel7.setText("Số lượng");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ Hàng"));

        JTableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(JTableGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        JtableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JtableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JtableHoaDon);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn Chi Tiết"));

        jLabel2.setText("Id hóa đơn");

        jLabel3.setText("Mã hóa đơn");

        jLabel4.setText("Ngày tạo");

        jLabel5.setText("Tên nhân viên");

        jLabel6.setText("Tổng tiền");

        lblIdHoaDon.setText("jLabel7");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHoaDon)
                            .addComponent(txtNgayTao)
                            .addComponent(txtTenNhanVien)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblIdHoaDon))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnThanhToan)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)))
                    .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTaoHoaDon)
                                .addGap(69, 69, 69))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
//       IdKH, IdNV, Ma, NgayTao, TinhTrang
        QLHoaDon qlHoaDon = new QLHoaDon();
        Random ranDom = new Random();
        int x = ranDom.nextInt(200);
        qlHoaDon.setMa("HD" + x);
        QLKhachHang qlKh = new QLKhachHang();
        qlKh.setId("21E476C6-2D69-4125-AC8E-40692106402D");
        qlHoaDon.setIdKH(qlKh);
        QLNhanVien qlNV = new QLNhanVien();
        qlNV.setId("2f31c818-87ea-4fd9-a986-4d0788750994");
        qlHoaDon.setIdNV(qlNV);

        qlHoaDon.setNgayTao(new Date());
        qlHoaDon.setTinhTrang(0);
        JOptionPane.showMessageDialog(rootPane, hoaDonService.addCuaHang(qlHoaDon));
        listQlHoaDon = hoaDonService.selectAll();
        showDataHoaDon(listQlHoaDon);

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void JTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSanPhamMouseClicked
        double giaThanh = 0;
        double giaHien;
        index = JTableSanPham.getSelectedRow();
        if (index != -1) {
            QLChiTietSanPham QL = listChiTietSP.get(index);
            QLHoaDonChiTiet qLHoaDonChiTiet = new QLHoaDonChiTiet();
            if (txtSoLuong.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Xin mời nhập số lượng");
                return;
            }

            if (QL.getSoLuongTon() < Integer.parseInt(txtSoLuong.getText()) && QL.getSoLuongTon() < 0) {
                JOptionPane.showMessageDialog(this, "kiểm tra số lượng nhập và số lượng tồn hết");
                return;
            } else {

                int soLuong = Integer.parseInt(txtSoLuong.getText());
                chiTietSanPhamService.updateSoLuonTon(QL.getSoLuongTon() - soLuong, QL.getId());
                listChiTietSP = chiTietSanPhamService.selectAll();
                showDataSanPham(listChiTietSP);
                qLHoaDonChiTiet.setSoLuong(soLuong);
                giaHien = Double.parseDouble(String.valueOf(soLuong)) * Double.parseDouble(String.valueOf(QL.getGiaBan()));
                giaThanh += giaHien;
                txtTongTien.setText(String.valueOf(giaThanh));
            }

            // quản lý chi tiết sản phẩm
            QLChiTietSanPham qLChiTietSanPham = new QLChiTietSanPham();
            qLChiTietSanPham.setId(QL.getId());
            // quản lý hóa đơn

            QLSanPham qlSanPham = new QLSanPham();
            qlSanPham.setMa(QL.getIdSP().getMa());
            qlSanPham.setTen(QL.getIdSP().getTen());

            qLChiTietSanPham.setIdSP(qlSanPham);

            qLHoaDonChiTiet.setIdChiTietSP(qLChiTietSanPham);
            showDataSanPham(listChiTietSP);
            qLHoaDonChiTiet.setIdChiTietSP(qLChiTietSanPham);

            qLHoaDonChiTiet.setDonGia(QL.getGiaBan());

            listQLHoaDonChiTiets.add(qLHoaDonChiTiet);
            showDataGioHang(listQLHoaDonChiTiets);

        } else {
            JOptionPane.showMessageDialog(this, "Yêu cầu chọn đối tượng");
        }
    }//GEN-LAST:event_JTableSanPhamMouseClicked

    private void JtableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableHoaDonMouseClicked
        index = JtableHoaDon.getSelectedRow();
        if (index != -1) {
            // fill ra hóa đơn
            lblIdHoaDon.setText(listQlHoaDon.get(index).getId());
            txtMaHoaDon.setText(listQlHoaDon.get(index).getMa());

            SimpleDateFormat dateHoaDon = new SimpleDateFormat("yyyy-MM-dd");
            txtNgayTao.setText(dateHoaDon.format(listQlHoaDon.get(index).getNgayTao()));
            txtTenNhanVien.setText(listQlHoaDon.get(index).getIdNV().getTen());

        } else {
            JOptionPane.showMessageDialog(this, "Xin mời chọn hóa đơn");
        }
    }//GEN-LAST:event_JtableHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        List<QLHoaDonChiTiet> list = new ArrayList<>();
        int soLuong = 0;
        for (QLHoaDonChiTiet ql : listQLHoaDonChiTiets) {
            if (ql.getIdChiTietSP().getId().equals(ql.getIdChiTietSP().getId())) {
                soLuong += ql.getSoLuong();
                System.out.println("" + ql.getIdChiTietSP().getId());
            }
            System.out.println("" + soLuong);
            QLHoaDonChiTiet qlHDCT = new QLHoaDonChiTiet();

            QLHoaDon qlHD = new QLHoaDon();
            qlHD.setId(lblIdHoaDon.getText());
            qlHDCT.setIdHoaDon(qlHD);

            QLChiTietSanPham qlCTSP = new QLChiTietSanPham();
            qlCTSP.setId(ql.getIdChiTietSP().getId());
            qlHDCT.setIdChiTietSP(qlCTSP);

            qlHDCT.setSoLuong(soLuong);
            qlHDCT.setDonGia(BigDecimal.valueOf(Double.parseDouble(String.valueOf(ql.getSoLuong())) * Double.parseDouble(String.valueOf(ql.getDonGia()))));

            list.add(qlHDCT);
        }
        for (QLHoaDonChiTiet qlHDCT : list) {
            if (qlHDCT.getIdChiTietSP().getId().equals(qlHDCT.getIdChiTietSP().getId())) {
                String sq = qlHDCT.getIdChiTietSP().getId();
            }

            JOptionPane.showMessageDialog(this, chiTietService.addHoaDonChiTiet(qlHDCT));
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHangJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableGioHang;
    private javax.swing.JTable JTableSanPham;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JTable JtableHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblIdHoaDon;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
