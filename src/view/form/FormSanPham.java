/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import domainModel.SanPhamCT;
import domainModel.ThuocTinhSP;
import service.ChatLieu_Service;
import service.HangSanXuat_Service;
import service.KieuMu_Service;
import service.KinhMu_Service;
import service.MauSac_Service;
import service.SanPhamService;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCT_ViewModel;
import viewmodel.ThuocTinh_ViewModel;

/**
 *
 * @author ADMIN
 */
public class FormSanPham extends javax.swing.JPanel {

    List<SanPhamCT_ViewModel> listSPCT;
    List<SanPhamCT> listSanPhamCT;
    List<ThuocTinh_ViewModel> listTT;
    DefaultTableModel def;
    //
    String anh_PNG = null;
//
    ChatLieu_Service clSer = new ChatLieu_Service();
    HangSanXuat_Service hsxSer = new HangSanXuat_Service();
    KieuMu_Service kmSer = new KieuMu_Service();
    KinhMu_Service kinhSer = new KinhMu_Service();
    MauSac_Service msSer = new MauSac_Service();
    SanPhamService spSer = new SanPhamService();
    /**
     * Creates new form FormSanPham
     */
    public FormSanPham() {
        initComponents();
    }

    public void loadTable() {
        listSPCT = spSer.getAllSanPhamCT();
        def = (DefaultTableModel) tb_table.getModel();
        def.setRowCount(0);
        for (SanPhamCT_ViewModel sp : listSPCT) {
            Object[] rowData = {
                sp.getMaSP(), sp.getTenMu(), sp.getTenHang(), sp.getTenChatLieu(),
                sp.getTenMauSac(), sp.getSize(),
                sp.getTenKieuMu(), sp.getTenKinh(),
                sp.getGiaBan(), sp.getSoLuong(), sp.getAnh()
            };
            def.addRow(rowData);
        }
    }

    private SanPhamCT getFormSanPhamChiTiet() {
        SanPhamCT ct = new SanPhamCT();
        ct.setMaSP(txt_MaSanPham.getText());
        ct.setTenMu(txt_TenMu.getText());
        ct.setMaHang(this.hsxSer.getAllMaHangSanXuatbyTen(cb_HangSanXuat.getSelectedItem().toString()));
        ct.setMaChatLieu(this.clSer.getAllMaChatLieubyTen(cb_ChatLieu.getSelectedItem().toString()));
        ct.setMaMauSac(this.msSer.getAllMaMauSacbyTen(cb_MauSac1.getSelectedItem().toString()));
        ct.setSize(txt_Size.getText());
        ct.setMaKieuMu(this.kmSer.getAllMaKieuMubyTen(cb_KieuMu1.getSelectedItem().toString()));
        ct.setMaKinh(this.kinhSer.getAllMaKinhMubyTen(cb_KinhMu.getSelectedItem().toString()));
        ct.setGiaBan(Double.parseDouble(txt_GiaBan.getText()));

        ct.setSoLuong(Integer.parseInt(txt_SoLuong.getText()));
        ct.setAnh(anh_PNG);
        return ct;
    }

    private void showDeTailSanPhamCT(SanPhamCT_ViewModel sp) {
        txt_MaSanPham.setText(sp.getMaSP());
        txt_TenMu.setText(sp.getTenMu());
        cb_HangSanXuat.setSelectedItem(sp.getTenHang());
        cb_ChatLieu.setSelectedItem(sp.getTenChatLieu());
        cb_MauSac1.setSelectedItem(sp.getTenMauSac());
        txt_Size.setText(sp.getSize());
        cb_KieuMu1.setSelectedItem(sp.getTenKieuMu());
        cb_KinhMu.setSelectedItem(sp.getTenKinh());
        txt_GiaBan.setText(String.valueOf(sp.getGiaBan()));
        txt_SoLuong.setText(String.valueOf(sp.getSoLuong()));

        int row = tb_table.getSelectedRow();
        String icon = tb_table.getValueAt(row, 10).toString();
        lblAnh.setIcon(ResizeImage(String.valueOf(icon)));

    }

    private void showDeTaiThuocTinh(ThuocTinhSP tt) {
        txt_MaThuocTinh.setText(tt.getMaThuocTinh());
        txt_TenThuocTinh.setText(tt.getTenThuocTinh());
//        if (tt.getTrangThai() == 1) {
//            ckbTrangThai.setSelected(true);
//        } else {
//            ckbTrangThai.setSelected(false);
//        }
    }

    public void FillcbChatLieu() {
        cb_ChatLieu.removeAllItems();
        listTT = clSer.getAllChatLieuView();
        for (ThuocTinh_ViewModel tt : listTT) {
            cb_ChatLieu.addItem(tt.getTenThuocTinh());
        }
    }

    public void FillcbHangSanXuat() {
        cb_HangSanXuat.removeAllItems();
        listTT = hsxSer.getAllHangSanXuat();
        for (ThuocTinh_ViewModel tt : listTT) {
            cb_HangSanXuat.addItem(tt.getTenThuocTinh());
        }
    }

    public void FillcbKieuMu() {
        cb_KieuMu1.removeAllItems();
        listTT = kmSer.getAllKieuMu();
        for (ThuocTinh_ViewModel tt : listTT) {
            cb_KieuMu1.addItem(tt.getTenThuocTinh());
        }
    }

    public void FillcbKinhMu() {
        cb_KinhMu.removeAllItems();
        listTT = kinhSer.getAllKinhMu();
        for (ThuocTinh_ViewModel tt : listTT) {
            cb_KinhMu.addItem(tt.getTenThuocTinh());
        }

    }

    public void FillcbMauSac() {
        cb_MauSac1.removeAllItems();
        listTT = msSer.getAllMauSac();
        for (ThuocTinh_ViewModel tt : listTT) {
            cb_MauSac1.addItem(tt.getTenThuocTinh());
        }
    }

    private void FillTableMauSac() {
        listTT = msSer.getAllMauSac();
        def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        def.setRowCount(0);
        for (ThuocTinh_ViewModel tt : listTT) {
            Object[] rowData = {
                tt.getMaThuocTinh(), tt.getTenThuocTinh()
            };
            def.addRow(rowData);
        }
    }

    private void FillTableHangSX() {
        listTT = hsxSer.getAllHangSanXuat();
        def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        def.setRowCount(0);
        for (ThuocTinh_ViewModel tt : listTT) {
            Object[] row = {
                tt.getMaThuocTinh(), tt.getTenThuocTinh()
            };
            def.addRow(row);
        }
    }

    private void FillTableChatLieu() {
        listTT = clSer.getAllChatLieuView();
        def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        def.setRowCount(0);
        for (ThuocTinh_ViewModel tt : listTT) {
            Object[] row = {
                tt.getMaThuocTinh(), tt.getTenThuocTinh()
            };
            def.addRow(row);
        }
    }

    private void FillTableKieuMu() {
        listTT = kmSer.getAllKieuMu();;
        def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        def.setRowCount(0);
        for (ThuocTinh_ViewModel tt : listTT) {
            Object[] row = {
                tt.getMaThuocTinh(), tt.getTenThuocTinh()
            };
            def.addRow(row);
        }
    }

    private void FillTableKinhMu() {
        listTT = kinhSer.getAllKinhMu();
        def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        def.setRowCount(0);
        for (ThuocTinh_ViewModel tt : listTT) {
            Object[] row = {
                tt.getMaThuocTinh(), tt.getTenThuocTinh()
            };
            def.addRow(row);
        }

    }

    public void ClearForm() {
        txt_Size.setText("");
        txt_MaSanPham.setText("");
        txt_MaThuocTinh.setText("");
        txt_TenMu.setText("");
        txt_TenThuocTinh.setText("");
        cb_ChatLieu.setSelectedIndex(0);
        cb_HangSanXuat.setSelectedIndex(0);
        cb_KieuMu1.setSelectedIndex(0);
        cb_KinhMu.setSelectedIndex(0);
        cb_MauSac1.setSelectedIndex(0);
        txt_GiaBan.setText("");
        txt_SoLuong.setText("");
        lblAnh.setIcon(null);
        lbl_SoLuong.setText("");
        lbl_TenMu.setText("");
        lbl_GiaBan.setText("");
        lbl_Size.setText("");
        lbl_MaSanPham.setText("");
    }

    public int check() {
        int dem = 0;
        if (txt_MaSanPham.getText().equalsIgnoreCase(tb_table.getValueAt(tb_table.getSelectedRow(), 0).toString())) {
            lbl_MaSanPham.setText("Mã Sản Phẩm Bị Trùng !");
            return dem++;
        } else {
            // lbl_MaSanPham.setText("");
        }
        if (txt_MaSanPham.getText().equals("")) {
            lbl_MaSanPham.setText("*Vui lòng nhập mã mũ !");
            dem++;
        } else {
            lbl_MaSanPham.setText("");
        }
        if (txt_TenMu.getText().equals("")) {
            lbl_TenMu.setText("*Vui lòng nhập tên mũ bảo hiểm !");
            dem++;
        } else {
            lbl_TenMu.setText("");
        }

        if (txt_Size.getText().equals("")) {
            lbl_Size.setText("*Vui lòng nhập Size mũ!");
            dem++;
        } else {
            lbl_Size.setText("");
        }

        if (txt_GiaBan.getText().equals("")) {
            lbl_GiaBan.setText("*Vui lòng nhập giá bán mũ !");
            dem++;
        } else if (Double.parseDouble(txt_GiaBan.getText()) < 0) {
            lbl_GiaBan.setText("*Vui lòng nhập giá bán lớn hơn 0 !");
            dem++;
        } else {
            lbl_GiaBan.setText("");
        }
        if (txt_SoLuong.getText().equals("")) {
            lbl_SoLuong.setText("*Vui lòng nhập số lượng mũ !");
            dem++;
        } else {
            lbl_SoLuong.setText("");
        }
        Pattern sp4 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~[a-z]]", Pattern.CASE_INSENSITIVE);
        Matcher mt4 = sp4.matcher(txt_GiaBan.getText());
        boolean cons4 = mt4.find();
        {
            if (cons4 == true) {
                lbl_GiaBan.setText("*Không được nhập kí tự đặc biệt trong giá bán  !");
                txt_GiaBan.requestFocus();
                dem++;
            }
        }
        Pattern sp5 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~[a-z]]", Pattern.CASE_INSENSITIVE);
        Matcher mt5 = sp5.matcher(txt_SoLuong.getText());
        boolean cons5 = mt5.find();
        {
            if (cons5 == true) {
                lbl_SoLuong.setText("*Không được nhập kí tự đặc biệt trong số lượng  !");
                txt_GiaBan.requestFocus();
                dem++;
            }
        }

        return dem;
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myimage = new ImageIcon(ImagePath);
        Image img = myimage.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private ThuocTinhSP getFormThuocTinh() {
        String ma = txt_MaThuocTinh.getText();
        String ten = txt_TenThuocTinh.getText();
        int trangThai = 0;
        ThuocTinhSP tt = new ThuocTinhSP(ma, ten, trangThai);
        return tt;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_ThemSP = new javax.swing.JButton();
        btn_SuaTT = new javax.swing.JButton();
        btn_XoaSP = new javax.swing.JButton();
        btn_Clear = new javax.swing.JButton();
        txt_MaSanPham = new javax.swing.JTextField();
        txt_TenMu = new javax.swing.JTextField();
        cb_HangSanXuat = new javax.swing.JComboBox<>();
        cb_ChatLieu = new javax.swing.JComboBox<>();
        cb_MauSac1 = new javax.swing.JComboBox<>();
        cb_KieuMu1 = new javax.swing.JComboBox<>();
        txt_SoLuong = new javax.swing.JTextField();
        cb_KinhMu = new javax.swing.JComboBox<>();
        txt_GiaBan = new javax.swing.JTextField();
        lbl_MaSanPham = new javax.swing.JLabel();
        lbl_TenMu = new javax.swing.JLabel();
        btn_LoadTable = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        lbl_SoLuong = new javax.swing.JLabel();
        lbl_GiaBan = new javax.swing.JLabel();
        lbl_Size = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdo_HangSanXuat = new javax.swing.JRadioButton();
        rdo_ChatLieu = new javax.swing.JRadioButton();
        rdo_MauSac = new javax.swing.JRadioButton();
        rdo_KieuMu = new javax.swing.JRadioButton();
        rdo_KinhMu = new javax.swing.JRadioButton();
        btn_ThemCTSP = new javax.swing.JButton();
        btn_SuaCTSP = new javax.swing.JButton();
        btn_XoaCTSP = new javax.swing.JButton();
        btn_ClearForm = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_TenThuocTinh = new javax.swing.JTextField();
        txt_MaThuocTinh = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_ChiTietSanPham = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 153, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 102, 0));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ảnh Mũ Bảo Hiểm ");

        jPanel10.setBackground(new java.awt.Color(0, 102, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã Sản Phẩm : ");

        jLabel3.setText("Tên Mũ : ");

        jLabel4.setText("Hãng Sản Xuất : ");

        jLabel5.setText("Chất Liệu : ");

        jLabel6.setText("Màu Sắc : ");

        jLabel9.setText("Kiểu Mũ : ");

        jLabel11.setText("Số Lượng : ");

        jLabel12.setText("Kính Mũ : ");

        jLabel13.setText("Giá Bán : ");

        btn_ThemSP.setBackground(new java.awt.Color(51, 102, 255));
        btn_ThemSP.setText("Thêm Sản Phẩm ");
        btn_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSPActionPerformed(evt);
            }
        });

        btn_SuaTT.setBackground(new java.awt.Color(51, 102, 255));
        btn_SuaTT.setText("Sửa Thông Tin ");
        btn_SuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaTTActionPerformed(evt);
            }
        });

        btn_XoaSP.setBackground(new java.awt.Color(51, 102, 255));
        btn_XoaSP.setText("Xóa Sản Phẩm ");
        btn_XoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaSPActionPerformed(evt);
            }
        });

        btn_Clear.setBackground(new java.awt.Color(51, 102, 255));
        btn_Clear.setText("Clear ");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        cb_HangSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_ChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_MauSac1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_KieuMu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_KieuMu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_KieuMu1ActionPerformed(evt);
            }
        });

        cb_KinhMu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_LoadTable.setBackground(new java.awt.Color(51, 102, 255));
        btn_LoadTable.setText("LoadTable");
        btn_LoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoadTableActionPerformed(evt);
            }
        });

        jLabel14.setText("Size");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tìm Kiếm Sản Phẩm : ");

        txt_TimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TimKiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txt_TenMu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_HangSanXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_MaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_MaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addComponent(lbl_TenMu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel13))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lbl_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cb_KinhMu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_KieuMu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Size, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ThemSP)
                .addGap(18, 18, 18)
                .addComponent(btn_SuaTT)
                .addGap(30, 30, 30)
                .addComponent(btn_XoaSP)
                .addGap(48, 48, 48)
                .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_LoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lbl_MaSanPham)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_TenMu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_TenMu)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(lbl_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_KieuMu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_HangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cb_KinhMu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lbl_GiaBan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_SoLuong)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_LoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_SuaTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_XoaSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblAnh.setText("jLabel14");
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Mũ ", "Hãng Sản Xuất", "Chất Liệu ", "Màu Sắc ", "Size", "Kiểu Mũ  ", "Kính Mũ", "Giá Bán ", "Số Lượng ", "Anh SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_table);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm ", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdo_HangSanXuat.setText("Hãng Xản Xuất ");
        rdo_HangSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_HangSanXuatActionPerformed(evt);
            }
        });

        rdo_ChatLieu.setText("Chất Liệu ");
        rdo_ChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_ChatLieuActionPerformed(evt);
            }
        });

        rdo_MauSac.setText("Màu Sắc ");
        rdo_MauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_MauSacActionPerformed(evt);
            }
        });

        rdo_KieuMu.setText("Kiểu Mũ ");
        rdo_KieuMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_KieuMuActionPerformed(evt);
            }
        });

        rdo_KinhMu.setText("Kính Mũ ");
        rdo_KinhMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_KinhMuActionPerformed(evt);
            }
        });

        btn_ThemCTSP.setBackground(new java.awt.Color(51, 102, 255));
        btn_ThemCTSP.setText("Thêm ");
        btn_ThemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCTSPActionPerformed(evt);
            }
        });

        btn_SuaCTSP.setBackground(new java.awt.Color(51, 102, 255));
        btn_SuaCTSP.setText("Sửa ");
        btn_SuaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaCTSPActionPerformed(evt);
            }
        });

        btn_XoaCTSP.setBackground(new java.awt.Color(51, 102, 255));
        btn_XoaCTSP.setText("Xóa ");
        btn_XoaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaCTSPActionPerformed(evt);
            }
        });

        btn_ClearForm.setText("Clear ");
        btn_ClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearFormActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên Thuộc Tính : ");

        jLabel16.setText("Mã Thuộc Tính : ");

        tb_ChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Thuộc Tính", "Tên Thuộc Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_ChiTietSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rdo_KieuMu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdo_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdo_HangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(265, 265, 265)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_TenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_MaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_ThemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(btn_SuaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btn_XoaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(389, 389, 389))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_KinhMu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdo_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_HangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_MaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_TenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_KieuMu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThemCTSP)
                    .addComponent(btn_SuaCTSP)
                    .addComponent(btn_XoaCTSP)
                    .addComponent(btn_ClearForm))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdo_KinhMu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rdo_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết Thuộc Tính ", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSPActionPerformed
        // TODO add your handling code here:
        if (check() == 0) {
            SanPhamCT ct = getFormSanPhamChiTiet();
            spSer.insert(ct);
            loadTable();
        }
    }//GEN-LAST:event_btn_ThemSPActionPerformed

    private void btn_SuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaTTActionPerformed
        // TODO add your handling code here:
        int row = tb_table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn một dòng để sửa !");
            return;
        }
        SanPhamCT sp = getFormSanPhamChiTiet();
        this.spSer.update(sp, txt_MaSanPham.getText());
        JOptionPane.showMessageDialog(this, "Sửa Thành Công !");
        loadTable();
    }//GEN-LAST:event_btn_SuaTTActionPerformed

    private void btn_XoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaSPActionPerformed
        // TODO add your handling code here:
        //        SanPhamCT ct = getFormSanPhamChiTiet();

        int row = tb_table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn một sản phẩm để xóa!");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa '" + tb_table.getValueAt(row, 1) + "' ra khỏi bảng không ?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            this.spSer.delete(txt_MaSanPham.getText());
            loadTable();
            JOptionPane.showMessageDialog(this, "Đã xóa thành công !");
            ClearForm();
        }
    }//GEN-LAST:event_btn_XoaSPActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        // TODO add your handling code here:
        ClearForm();
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void cb_KieuMu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_KieuMu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_KieuMu1ActionPerformed

    private void btn_LoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoadTableActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btn_LoadTableActionPerformed

    private void txt_TimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TimKiemCaretUpdate
        // TODO add your handling code here:
        String tk = txt_TimKiem.getText();
        if (tk.equals("")) {
            return;
        }
        listSPCT = spSer.getAllSanPham(tk);
        DefaultTableModel def = (DefaultTableModel) tb_table.getModel();
        def.setRowCount(0);
        for (SanPhamCT_ViewModel sp : listSPCT) {
            Object[] data = {
                sp.getMaSP(), sp.getTenMu(), sp.getTenHang(), sp.getTenChatLieu(),
                sp.getTenMauSac(), sp.getSize(),
                sp.getTenKieuMu(), sp.getTenKinh(),
                sp.getGiaBan(), sp.getSoLuong(), sp.getAnh()
            };
            def.addRow(data);
        }
    }//GEN-LAST:event_txt_TimKiemCaretUpdate

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser("");
            fc.showOpenDialog(null);
            File f = fc.getSelectedFile();
            anh_PNG = f.getAbsolutePath();
            lblAnh.setText("");
            lblAnh.setIcon(ResizeImage(String.valueOf(anh_PNG)));
            System.out.println(anh_PNG);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ảnh chưa được chọn");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void tb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMouseClicked
        int row = tb_table.getSelectedRow();
        SanPhamCT_ViewModel ct = listSPCT.get(row);
        showDeTailSanPhamCT(ct);
    }//GEN-LAST:event_tb_tableMouseClicked

    private void rdo_HangSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_HangSanXuatActionPerformed
        // TODO add your handling code here:
        FillTableHangSX();
    }//GEN-LAST:event_rdo_HangSanXuatActionPerformed

    private void rdo_ChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_ChatLieuActionPerformed
        // TODO add your handling code here:
        FillTableChatLieu();
    }//GEN-LAST:event_rdo_ChatLieuActionPerformed

    private void rdo_MauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_MauSacActionPerformed
        // TODO add your handling code here:
        FillTableMauSac();
    }//GEN-LAST:event_rdo_MauSacActionPerformed

    private void rdo_KieuMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_KieuMuActionPerformed
        // TODO add your handling code here:
        FillTableKieuMu();
    }//GEN-LAST:event_rdo_KieuMuActionPerformed

    private void rdo_KinhMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_KinhMuActionPerformed
        // TODO add your handling code here:
        FillTableKinhMu();
    }//GEN-LAST:event_rdo_KinhMuActionPerformed

    private void btn_ThemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCTSPActionPerformed
        // TODO add your handling code here:
        if (rdo_HangSanXuat.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            hsxSer.themHangSanXuat(tt);
            FillTableHangSX();
        } else if (rdo_ChatLieu.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            clSer.themChatLieu(tt);
            FillTableChatLieu();
        } else if (rdo_KieuMu.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            kmSer.themKieuMu(tt);
            FillTableKieuMu();
        } else if (rdo_KinhMu.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            kinhSer.themKinhMu(tt);
            FillTableKinhMu();
        } else if (rdo_MauSac.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            msSer.themMauSac(tt);
            FillTableMauSac();
        }
    }//GEN-LAST:event_btn_ThemCTSPActionPerformed

    private void btn_SuaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaCTSPActionPerformed
        // TODO add your handling code here:
        String HangSX = hsxSer.getMaHangSanXuat(txt_MaThuocTinh.getText());
        String ChatLieu = clSer.getMaChatLieu(txt_MaThuocTinh.getText());
        String KieuMu = kmSer.getMaKieuMu(txt_MaThuocTinh.getText());
        String KinhMu = kinhSer.getMaKinhMu(txt_MaThuocTinh.getText());
        String MauSac = msSer.getMaMauSac(txt_MaThuocTinh.getText());
        if (rdo_HangSanXuat.isSelected()) {
            ThuocTinhSP tt = getFormThuocTinh();
            this.hsxSer.suaHangSanXuat(tt, HangSX);
            FillTableHangSX();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }else if (rdo_ChatLieu.isSelected()){
            ThuocTinhSP tt = getFormThuocTinh();
            this.clSer.suaChatLieu(tt, ChatLieu);
            FillTableChatLieu();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }else if(rdo_KieuMu.isSelected()){
            ThuocTinhSP tt = getFormThuocTinh();
            this.kinhSer.suaKinhMu(tt, KieuMu);
            FillTableKieuMu();
            JOptionPane.showMessageDialog(this, "Sửa thành công !");
        }else if(rdo_KinhMu.isSelected()){
            ThuocTinhSP tt = getFormThuocTinh();
            this.kinhSer.suaKinhMu(tt, KinhMu);
            FillTableKinhMu();
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
        }else if(rdo_MauSac.isSelected()){
            ThuocTinhSP tt = getFormThuocTinh();
            this.msSer.suaMauSac(tt, MauSac);
            FillTableMauSac();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }
    }//GEN-LAST:event_btn_SuaCTSPActionPerformed

    private void btn_XoaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaCTSPActionPerformed
        // TODO add your handling code here:

        if (rdo_HangSanXuat.isSelected()) {
            hsxSer.xoaHangSanXuat(txt_MaThuocTinh.getText());
            FillTableHangSX();
            //JOptionPane.showMessageDialog(this, "Xóa thành công !");
        } else if (rdo_ChatLieu.isSelected()) {
            clSer.xoaChatLieu(txt_MaThuocTinh.getText());
            FillTableChatLieu();
        } else if (rdo_KieuMu.isSelected()) {
            kmSer.xoaKieuMu(txt_MaThuocTinh.getText());
            FillTableKieuMu();
        } else if (rdo_KinhMu.isSelected()) {
            kinhSer.xoaKinhMu(txt_MaThuocTinh.getText());
            FillTableKinhMu();
        } else if (rdo_MauSac.isSelected()) {
            msSer.xoaMauSac(txt_MaThuocTinh.getText());
            FillTableMauSac();
        }
    }//GEN-LAST:event_btn_XoaCTSPActionPerformed

    private void btn_ClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearFormActionPerformed
        // TODO add your handling code here:
        txt_MaThuocTinh.setText("");
        txt_TenThuocTinh.setText("");
    }//GEN-LAST:event_btn_ClearFormActionPerformed

    private void tb_ChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ChiTietSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tb_ChiTietSanPham.getSelectedRow();
        DefaultTableModel def = (DefaultTableModel) tb_ChiTietSanPham.getModel();
        String ma = tb_ChiTietSanPham.getValueAt(index, 0).toString();
        if (rdo_MauSac.isSelected()) {
            ThuocTinhSP tt = msSer.getAllMauSacByMa(ma);
            showDeTaiThuocTinh(tt);
        } else if (rdo_ChatLieu.isSelected()) {
            ThuocTinhSP tt = clSer.getAllChatLieuByMa(ma);
            showDeTaiThuocTinh(tt);
        } else if (rdo_HangSanXuat.isSelected()) {
            ThuocTinhSP tt = hsxSer.getAllHangSanXuatByMa(ma);
            showDeTaiThuocTinh(tt);
        } else if (rdo_KieuMu.isSelected()) {
            ThuocTinhSP tt = kmSer.getAllKieuMuByMa(ma);
            showDeTaiThuocTinh(tt);
        } else if (rdo_KinhMu.isSelected()) {
            ThuocTinhSP tt = kinhSer.getAllKinhMuByMa(ma);
            showDeTaiThuocTinh(tt);
        }
    }//GEN-LAST:event_tb_ChiTietSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_ClearForm;
    private javax.swing.JButton btn_LoadTable;
    private javax.swing.JButton btn_SuaCTSP;
    private javax.swing.JButton btn_SuaTT;
    private javax.swing.JButton btn_ThemCTSP;
    private javax.swing.JButton btn_ThemSP;
    private javax.swing.JButton btn_XoaCTSP;
    private javax.swing.JButton btn_XoaSP;
    private javax.swing.JComboBox<String> cb_ChatLieu;
    private javax.swing.JComboBox<String> cb_HangSanXuat;
    private javax.swing.JComboBox<String> cb_KieuMu1;
    private javax.swing.JComboBox<String> cb_KinhMu;
    private javax.swing.JComboBox<String> cb_MauSac1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lbl_GiaBan;
    private javax.swing.JLabel lbl_MaSanPham;
    private javax.swing.JLabel lbl_Size;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_TenMu;
    private javax.swing.JRadioButton rdo_ChatLieu;
    private javax.swing.JRadioButton rdo_HangSanXuat;
    private javax.swing.JRadioButton rdo_KieuMu;
    private javax.swing.JRadioButton rdo_KinhMu;
    private javax.swing.JRadioButton rdo_MauSac;
    private javax.swing.JTable tb_ChiTietSanPham;
    private javax.swing.JTable tb_table;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_MaSanPham;
    private javax.swing.JTextField txt_MaThuocTinh;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenMu;
    private javax.swing.JTextField txt_TenThuocTinh;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
