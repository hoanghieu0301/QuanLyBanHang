/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSanPhamService;

import service.impl.ChiTietSanPhamImpl;
import service.impl.DongSanPhamImpl;
import service.impl.MauSacImpl;
import service.impl.NhaSanXuatImpl;
import service.impl.SanPhamiImpl;
import viewmodel.QLChiTietSanPham;
import viewmodel.QLMauSac;
import viewmodel.QLNhaSanXuat;
import viewmodel.QLSanPham;
import viewmodel.QlDongSanPham;

/**
 *
 * @author ASUS
 */
public class ViewChiTietSanPhamJFrame extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<QLChiTietSanPham> listQLChiTietSanPham = new ArrayList<>();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamImpl();
    private DefaultComboBoxModel dcbmSP = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmMS = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmDongSP = new DefaultComboBoxModel();

    public ViewChiTietSanPhamJFrame() {
        initComponents();
        //idSP.getTen(), idNSX.getTen(), idMaiSac.getTen(), idDongSP.getTen(), moTa, namBH, soLuongTon, giaNhap, giaBan
        String[] header = {"Tên Sp", "Tên NSX", "Mau Sắc", "Dòng Sp", "Miêu tả", "Năm Bh", "SL", "Giá Nhập", "Giá Bán"};
        jTable1.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        listQLChiTietSanPham = chiTietSanPhamService.selectAll();
        showData(listQLChiTietSanPham);

        cbbTenSanPham.setModel(dcbmSP);
        loadCBBSp();

        cbbNSX.setModel(dcbmNSX);
        loadCBBNSX();

        cbbMau.setModel(dcbmMS);
        loadCBBMau();

        cbbDong.setModel(dcbmDongSP);
        loadCBBDongSP();
    }

    private void showData(List<QLChiTietSanPham> listQLChiTietSanPham) {
        dtm.setRowCount(0);
        for (QLChiTietSanPham ql : listQLChiTietSanPham) {
            dtm.addRow(ql.toRowData());
        }
    }

    private void loadCBBSp() {
        List<QLSanPham> list = new SanPhamiImpl().selectAll();
        for (QLSanPham ql : list) {
            dcbmSP.addElement(ql.getTen());
        }
    }

    private void loadCBBNSX() {
        List<QLNhaSanXuat> list = new NhaSanXuatImpl().selectAll();
        for (QLNhaSanXuat ql : list) {
            dcbmNSX.addElement(ql.getTen());
        }
    }

    private void loadCBBMau() {
        List<QLMauSac> list = new MauSacImpl().selectAll();
        for (QLMauSac ql : list) {
            dcbmMS.addElement(ql.getTen());
        }

    }

    private void loadCBBDongSP() {
        List<QlDongSanPham> list = new DongSanPhamImpl().selectAll();
        for (QlDongSanPham ql : list) {
            dcbmDongSP.addElement(ql.getTen());
        }

    }

    private void fillData(int index) {
        lblId.setText(listQLChiTietSanPham.get(index).getId());
        cbbNSX.setSelectedItem(listQLChiTietSanPham.get(index).getIdNSX().getTen());
        cbbTenSanPham.setSelectedItem(listQLChiTietSanPham.get(index).getIdSP().getTen());
        cbbMau.setSelectedItem(listQLChiTietSanPham.get(index).getIdMaiSac().getTen());
        cbbDong.setSelectedItem(listQLChiTietSanPham.get(index).getIdDongSP().getTen());
        txtNamBaoHanh.setText(String.valueOf(listQLChiTietSanPham.get(index).getNamBH()));
        txtaMoTa.setText(listQLChiTietSanPham.get(index).getMoTa());
        txtSoLuong.setText(String.valueOf(listQLChiTietSanPham.get(index).getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(listQLChiTietSanPham.get(index).getGiaNhap()));
        txtGiaBan.setText(String.valueOf(listQLChiTietSanPham.get(index).getGiaBan()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbTenSanPham = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        cbbMau = new javax.swing.JComboBox<>();
        cbbDong = new javax.swing.JComboBox<>();
        txtNamBaoHanh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaMoTa = new javax.swing.JTextArea();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chi Tiết Sản Phẩm");

        lblId.setText("_");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel3);

        jLabel3.setText("ID chi tiết sp");

        jLabel4.setText("Tên sản phẩm");

        jLabel5.setText("Nhà sản xuất");

        jLabel6.setText("Màu sắc");

        jLabel7.setText("Dòng sp");

        jLabel8.setText("Năm bảo hàng");

        jLabel9.setText("Mô tả");

        jLabel10.setText("Số lượng tồn");

        jLabel11.setText("Giá nhập");

        jLabel12.setText("Giá bán");

        jLabel13.setText("__________");

        cbbTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtaMoTa.setColumns(20);
        txtaMoTa.setRows(5);
        jScrollPane1.setViewportView(txtaMoTa);

        jLabel2.setText("VND");

        jLabel14.setText("VND");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDong, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhập", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblId))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fillData(jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLChiTietSanPham qLChiTietSanPham = new QLChiTietSanPham();

        List<QLSanPham> qLSanPhams = new SanPhamiImpl().selectAll();
        for (QLSanPham ql : qLSanPhams) {
            QLSanPham qlsp = new QLSanPham();
            if (cbbTenSanPham.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlsp.setId(ql.getId());
                qLChiTietSanPham.setIdSP(qlsp);
            }
        }
//        nhà
        List<QLNhaSanXuat> qLNhaSanXuats = new NhaSanXuatImpl().selectAll();
        for (QLNhaSanXuat ql : qLNhaSanXuats) {
            QLNhaSanXuat qlnsx = new QLNhaSanXuat();
            if (cbbNSX.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlnsx.setId(ql.getId());
                qLChiTietSanPham.setIdNSX(qlnsx);
            }
        }

        List<QLMauSac> qLMauSacs = new MauSacImpl().selectAll();
        for (QLMauSac ql : qLMauSacs) {
            QLMauSac qlms = new QLMauSac();
            if (cbbMau.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlms.setId(ql.getId());
                qLChiTietSanPham.setIdMaiSac(qlms);
            }
        }

//dòng
        List<QlDongSanPham> qlDongSanPhams = new DongSanPhamImpl().selectAll();
        for (QlDongSanPham ql : qlDongSanPhams) {
            QlDongSanPham qlDongSanPham = new QlDongSanPham();
            if (cbbDong.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlDongSanPham.setId(ql.getId());
                qLChiTietSanPham.setIdDongSP(qlDongSanPham);
            }
        }

        qLChiTietSanPham.setNamBH(Integer.parseInt(txtNamBaoHanh.getText()));
        qLChiTietSanPham.setMoTa(txtaMoTa.getText());
        qLChiTietSanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        qLChiTietSanPham.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(txtGiaNhap.getText())));
        qLChiTietSanPham.setGiaBan(BigDecimal.valueOf(Double.parseDouble(txtGiaBan.getText())));

        JOptionPane.showMessageDialog(rootPane, chiTietSanPhamService.addChiTietSP(qLChiTietSanPham));
        listQLChiTietSanPham = chiTietSanPhamService.selectAll();
        showData(listQLChiTietSanPham);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        QLChiTietSanPham qLChiTietSanPham = new QLChiTietSanPham();

        List<QLSanPham> qLSanPhams = new SanPhamiImpl().selectAll();
        for (QLSanPham ql : qLSanPhams) {
            QLSanPham qlsp = new QLSanPham();
            if (cbbTenSanPham.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlsp.setId(ql.getId());
                qLChiTietSanPham.setIdSP(qlsp);
            }
        }
//        nhà
        List<QLNhaSanXuat> qLNhaSanXuats = new NhaSanXuatImpl().selectAll();
        for (QLNhaSanXuat ql : qLNhaSanXuats) {
            QLNhaSanXuat qlnsx = new QLNhaSanXuat();
            if (cbbNSX.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlnsx.setId(ql.getId());
                qLChiTietSanPham.setIdNSX(qlnsx);
            }
        }

        List<QLMauSac> qLMauSacs = new MauSacImpl().selectAll();
        for (QLMauSac ql : qLMauSacs) {
            QLMauSac qlms = new QLMauSac();
            if (cbbMau.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlms.setId(ql.getId());
                qLChiTietSanPham.setIdMaiSac(qlms);
            }
        }

//dòng
        List<QlDongSanPham> qlDongSanPhams = new DongSanPhamImpl().selectAll();
        for (QlDongSanPham ql : qlDongSanPhams) {
            QlDongSanPham qlDongSanPham = new QlDongSanPham();
            if (cbbDong.getSelectedItem().toString().equalsIgnoreCase(ql.getTen())) {
                qlDongSanPham.setId(ql.getId());
                qLChiTietSanPham.setIdDongSP(qlDongSanPham);
            }
        }

        qLChiTietSanPham.setNamBH(Integer.parseInt(txtNamBaoHanh.getText()));
        qLChiTietSanPham.setMoTa(txtaMoTa.getText());
        qLChiTietSanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        qLChiTietSanPham.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(txtGiaNhap.getText())));
        qLChiTietSanPham.setGiaBan(BigDecimal.valueOf(Double.parseDouble(txtGiaBan.getText())));

        JOptionPane.showMessageDialog(rootPane, chiTietSanPhamService.updateChiTietSP(qLChiTietSanPham, listQLChiTietSanPham.get(jTable1.getSelectedRow()).getId()));
        listQLChiTietSanPham = chiTietSanPhamService.selectAll();
        showData(listQLChiTietSanPham);
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        JOptionPane.showMessageDialog(rootPane, chiTietSanPhamService.deleteChiTietSP(listQLChiTietSanPham.get(jTable1.getSelectedRow()).getId()));
        listQLChiTietSanPham = chiTietSanPhamService.selectAll();
        showData(listQLChiTietSanPham);
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChiTietSanPhamJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbDong;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbTenSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtNamBaoHanh;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextArea txtaMoTa;
    // End of variables declaration//GEN-END:variables
}
