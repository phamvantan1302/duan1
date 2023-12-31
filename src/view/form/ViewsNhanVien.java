/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.NhanVienService;
import service.impl.NhanVienServiceImpl;
import viewmodel.NhanVienModel;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class ViewsNhanVien extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<NhanVienModel> listNV = new ArrayList<>();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    /**
     * Creates new form ViewsNhanVien
     */
    public ViewsNhanVien() {
        initComponents();
        tableHienThi.setModel(dtm);
        String[] header = {"ma", "ten", "gioi tinh", "ngay sinh", "email", "sdt", "dia chi", "trang thai"};
        dtm.setColumnIdentifiers(header);

        listNV = nhanVienService.getAll();

        showDataTable(listNV);
    }

    private void showDataTable(List<NhanVienModel> lists) {
        dtm.setRowCount(0);
        for (NhanVienModel x : lists) {
            dtm.addRow(x.toDataRow());
        }
    }

    public void fillDataRow(int i) {
        NhanVienModel nv = listNV.get(i);
        txtMa.setText(nv.getMa());
        txtTen.setText(nv.getTen());
        if (nv.isGioiTinh()) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        txtNgaySinh.setText(String.valueOf(nv.getNgaySinh()));
        txtMail.setText(nv.getEmail());
        txtSdt.setText(nv.getSdt());
        txtDiaChi.setText(nv.getDiaChi());
        if (nv.isTrangThai()) {
            radioDangLam.setSelected(true);
        } else {
            radioNghi.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btClean = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHienThi = new javax.swing.JTable();
        cbbLoc = new javax.swing.JComboBox<>();
        radioDangLam = new javax.swing.JRadioButton();
        radioNghi = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btLoiChuc = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        labelMess = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(153, 153, 255));

        btThem.setBackground(new java.awt.Color(51, 102, 255));
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(51, 102, 255));
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(51, 102, 255));
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btClean.setBackground(new java.awt.Color(51, 102, 255));
        btClean.setText("Clean");
        btClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCleanActionPerformed(evt);
            }
        });

        tableHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "SDT", "Giới Tính", "Địa Chỉ", "Tuổi", "Email", "Trạng Thái"
            }
        ));
        tableHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHienThi);

        cbbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm", "Nghỉ" }));
        cbbLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocActionPerformed(evt);
            }
        });
        cbbLoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbLocKeyReleased(evt);
            }
        });

        buttonGroup3.add(radioDangLam);
        radioDangLam.setSelected(true);
        radioDangLam.setText("Đang làm");

        buttonGroup3.add(radioNghi);
        radioNghi.setText("Nghỉ");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel6.setText("SDT");

        jLabel10.setText("Lọc trạng thái");

        jLabel7.setText("Ngày Sinh");

        jLabel8.setText("Email");

        jLabel9.setText("Trang Thai");

        btLoiChuc.setBackground(new java.awt.Color(51, 102, 255));
        btLoiChuc.setText("Lời chúc ");
        btLoiChuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoiChucActionPerformed(evt);
            }
        });

        labelMess.setForeground(new java.awt.Color(255, 51, 51));
        labelMess.setText("Không có thông báo");

        jLabel12.setText("tìm theo tên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("QUAN LY NHAN VIEN");

        jLabel2.setText("Ma NV: ");

        jLabel3.setText("Dia Chi");

        jLabel4.setText("Ten NV");

        jLabel5.setText("Gioi Tinh");

        buttonGroup1.add(radioNam);
        radioNam.setSelected(true);
        radioNam.setText("Nam");

        buttonGroup1.add(radioNu);
        radioNu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(radioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radioDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(radioNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 347, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(705, 705, 705)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(labelMess, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btLoiChuc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNam)
                    .addComponent(radioNu))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioDangLam)
                    .addComponent(radioNghi))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch)
                        .addComponent(jLabel12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLoiChuc, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(labelMess))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        boolean gioiTinh = radioNam.isSelected();
        if (gioiTinh) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
        String mail = txtMail.getText();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        String mk = "1234";
        boolean trangThai = radioDangLam.isSelected();
        if (trangThai) {
            radioDangLam.setSelected(true);
        } else {
            radioNghi.setSelected(true);
        }
        NhanVienModel nv = new NhanVienModel(ma, ten, gioiTinh, ngaySinh, mail, sdt, diaChi, mk, trangThai);
        String add = nhanVienService.add(nv);
        JOptionPane.showMessageDialog(this, add);
        listNV = nhanVienService.getAll();
        showDataTable(listNV);
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        boolean gioiTinh = radioNam.isSelected();
        if (gioiTinh) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
        String mail = txtMail.getText();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        boolean trangThai = radioDangLam.isSelected();
        if (trangThai) {
            radioDangLam.setSelected(true);
        } else {
            radioNghi.setSelected(true);
        }
        NhanVienModel nv = new NhanVienModel(ma, ten, gioiTinh, ngaySinh, mail, sdt, diaChi, trangThai);
        String update = nhanVienService.update(nv, ma);
        JOptionPane.showMessageDialog(this, update);
        listNV = nhanVienService.getAll();
        showDataTable(listNV);
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        int i = tableHienThi.getSelectedRow();
        if (i == -1) {
            return;
        } else {
            listNV.remove(i);
        }
        dtm.setRowCount(0);
        for (NhanVienModel x : listNV) {
            Vector<Object> v = new Vector<>();
            v.add(x.getMa());
            v.add(x.getTen());
            v.add(x.isGioiTinh());
            v.add(x.getNgaySinh());
            v.add(x.getEmail());
            v.add(x.getSdt());
            v.add(x.getDiaChi());
            v.add(x.isTrangThai());
            dtm.addRow(v);
        }
        String ma = txtMa.getText();
        JOptionPane.showMessageDialog(this, nhanVienService.delete(ma));
        showDataTable(listNV);
    }//GEN-LAST:event_btXoaActionPerformed

    private void btCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCleanActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtMail.setText("");
        txtNgaySinh.setText("");
        txtSdt.setText("");
        txtSearch.setText("");
        buttonGroup1.clearSelection();
        cbbLoc.setSelectedItem("Tất cả");
        labelMess.setText("mess thông báo");
        buttonGroup3.clearSelection();
    }//GEN-LAST:event_btCleanActionPerformed

    private void tableHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHienThiMouseClicked
        // TODO add your handling code here:
        int i = tableHienThi.getSelectedRow();
        fillDataRow(i);
    }//GEN-LAST:event_tableHienThiMouseClicked

    private void cbbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocActionPerformed
        // TODO add your handling code here:
        if (cbbLoc.getSelectedItem() == "Tất cả") {
            listNV = nhanVienService.getAll();
            showDataTable(listNV);
        }
        if (cbbLoc.getSelectedItem() == "Đang làm") {
            listNV = nhanVienService.getAll();
            boolean trangThai = true;
            List<NhanVienModel> listft = new NhanVienServiceImpl().searchByTrangThai(listNV, trangThai);
            showDataTable(listft);
        }
        if (cbbLoc.getSelectedItem() == "Nghỉ") {
            listNV = nhanVienService.getAll();
            boolean trangThai = false;
            List<NhanVienModel> listft = new NhanVienServiceImpl().searchByTrangThai(listNV, trangThai);
            showDataTable(listft);
        }
    }//GEN-LAST:event_cbbLocActionPerformed

    private void cbbLocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbLocKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbLocKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        listNV = nhanVienService.getAll();
        String ten = txtSearch.getText();
        List<NhanVienModel> listft = new NhanVienServiceImpl().searchByLoai(listNV, ten);
        showDataTable(listft);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btLoiChucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoiChucActionPerformed
        // TODO add your handling code here:
//        String email = txtMail.getText();
//        ViewEmail mail = new ViewEmail(this, true, email);
//        this.dispose();
//        mail.setVisible(true);
    }//GEN-LAST:event_btLoiChucActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewsNhanVien().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClean;
    private javax.swing.JButton btLoiChuc;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMess;
    private javax.swing.JRadioButton radioDangLam;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNghi;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tableHienThi;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
