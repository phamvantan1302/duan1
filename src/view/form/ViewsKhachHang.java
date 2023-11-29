/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.Interface.IkhachHangService;
import service.impl.KhachHangServiceImpl;
import viewmodel.KhachHang;

/**
 *
 * @author Dell
 */
public class ViewsKhachHang extends javax.swing.JPanel {
    private List<KhachHang> listKH = new ArrayList<>();
    private DefaultTableModel dtm;
    private IkhachHangService serviceKH = new KhachHangServiceImpl();
    /**
     * Creates new form ViewsKhachHang
     */
    public ViewsKhachHang() {
        initComponents();
        loadTable(serviceKH.getAll());
    }
    public void loadTable(List<KhachHang> list) {
        dtm = (DefaultTableModel) tbKhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang kh : list) {
            dtm.addRow(new Object[]{
                kh.getMa(), kh.getTen(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(), kh.getQuocGia(), kh.htGioiTinh()
            });
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

        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        txtNgaySinhKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        radioNamKH = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        radioNuKH = new javax.swing.JRadioButton();
        txtDiaChiKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtQuocGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txtTenKh = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSdtKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 255));

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày sinh :");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên khách hàng", "Ngày Sinh", "Số điện thoại", "Địa chỉ", "Quốc gia", "Giới tính"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jLabel5.setText("Giới tính : ");

        btnXoa.setBackground(new java.awt.Color(51, 102, 255));
        btnXoa.setText("Xóa Khách Hàng");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        radioNamKH.setSelected(true);
        radioNamKH.setText("Nam");

        jLabel8.setText("Địa chỉ :");

        radioNuKH.setText("Nữ");

        jLabel6.setText("Mã KH : ");

        jLabel7.setText("Quốc gia :");

        txtMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHKeyReleased(evt);
            }
        });

        jLabel2.setText("Tên KH :");

        btnThem.setBackground(new java.awt.Color(51, 102, 255));
        btnThem.setText("Thêm Khách Hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTenKh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenKhKeyReleased(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 102, 255));
        btnSua.setText("Sửa Khách Hàng");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel3.setText("Số điện thoại :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("QUAN LY KHACH HANG ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnThem)
                .addGap(59, 59, 59)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addGap(71, 71, 71)
                        .addComponent(btnClear)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioNamKH)
                        .addGap(36, 36, 36)
                        .addComponent(radioNuKH)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 180, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgaySinhKH)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(txtDiaChiKH)
                        .addComponent(txtTenKh))
                    .addGap(523, 735, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNuKH)
                    .addComponent(jLabel5)
                    .addComponent(radioNamKH))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNgaySinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(96, 96, 96)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtMaKH.setText("");
        txtTenKh.setText("");
        txtNgaySinhKH.setText("");
        txtSdtKH.setText("");
        txtDiaChiKH.setText("");
        txtQuocGia.setText("");
        radioNamKH.setSelected(true);
        radioNuKH.setSelected(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tbKhachHang.getSelectedRow();
        txtMaKH.setText(tbKhachHang.getValueAt(row, 0).toString());
        txtTenKh.setText(tbKhachHang.getValueAt(row, 1).toString());
        txtNgaySinhKH.setText(tbKhachHang.getValueAt(row, 2).toString());
        txtSdtKH.setText(tbKhachHang.getValueAt(row, 3).toString());
        txtDiaChiKH.setText(tbKhachHang.getValueAt(row, 4).toString());
        txtQuocGia.setText(tbKhachHang.getValueAt(row, 5).toString());
        if (tbKhachHang.getValueAt(row, 6).toString().equalsIgnoreCase("Nam")) {
            radioNamKH.setSelected(true);
            radioNuKH.setSelected(false);
        } else {
            radioNuKH.setSelected(true);
            radioNamKH.setSelected(false);
        }
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaKH.getText();
        serviceKH.delete(ma);
        loadTable(serviceKH.getAll());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String ma = txtMaKH.getText();
        String ten = txtTenKh.getText();
        int gioiTinh = 0;
        if (radioNamKH.isSelected()) {
            radioNamKH.setSelected(true);
            gioiTinh = 0;
        } else {
            radioNuKH.setSelected(true);
            gioiTinh = 1;
        }
        Date ngaySinh = Date.valueOf(txtNgaySinhKH.getText());
        String sdt = txtSdtKH.getText();
        String diaChi = txtDiaChiKH.getText();
        String quocGia = txtQuocGia.getText();
        KhachHang kh = new KhachHang(ma, ten, ngaySinh, sdt, diaChi, quocGia, gioiTinh);
        String add = serviceKH.add(kh);
        JOptionPane.showMessageDialog(this, add);
        listKH = serviceKH.getAll();
        loadTable(listKH);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaKH.getText();
        String ten = txtTenKh.getText();
        int gioiTinh = 0;
        if (radioNamKH.isSelected()) {
            radioNamKH.setSelected(true);
            gioiTinh = 0;
        } else {
            radioNuKH.setSelected(true);
            gioiTinh = 1;
        }
        Date ngaySinh = Date.valueOf(txtNgaySinhKH.getText());
        String sdt = txtSdtKH.getText();
        String diaChi = txtDiaChiKH.getText();
        String quocGia = txtQuocGia.getText();
        KhachHang kh = new KhachHang(ma, ten, ngaySinh, sdt, diaChi, quocGia, gioiTinh);
        String update = serviceKH.update(kh, ma);
        JOptionPane.showMessageDialog(this, update);
        listKH = serviceKH.getAll();
        loadTable(listKH);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHKeyReleased
        // TODO add your handling code here:
//        listKH = serviceKH.searchByLoai(listKH, TOOL_TIP_TEXT_KEY)
        
    }//GEN-LAST:event_txtMaKHKeyReleased

    private void txtTenKhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhKeyReleased
        // TODO add your handling code here:
        String tenkh = txtTenKh.getText();
        List<KhachHang> listsearch = new KhachHangServiceImpl().searchByLoai(listKH, tenkh);
        loadTable(listsearch);
    }//GEN-LAST:event_txtTenKhKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioNamKH;
    private javax.swing.JRadioButton radioNuKH;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinhKH;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtTenKh;
    // End of variables declaration//GEN-END:variables
}