/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietHDService;
import service.DangNhapService;
import service.HoaDonService;
import service.NhanVienService;
import service.impl.ChiTietHDSerivceImpl;
import service.impl.DangNhapServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.NhanVienServiceImpl;
import view.logiin.txtField;
import viewmodel.ChiTietHoaDon;
import viewmodel.HoaDon;
import viewmodel.HoaDonChiTiet;
import viewmodel.KhachHang;
import viewmodel.LuuMa;
import viewmodel.NhanVienModel;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public class FormHoaDon extends javax.swing.JPanel {

//    private List<KhachHang> listKH = new ArrayList<>();
    private DefaultTableModel tbHD = new DefaultTableModel();
    private DefaultTableModel tbGioHang = new DefaultTableModel();
    private DefaultTableModel tbSanPham = new DefaultTableModel();
    private DefaultTableModel tbHDDaTT = new DefaultTableModel();
//    private List<NhanVienModel> listNV = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<SanPhamCT_ViewModel> listSP = new ArrayList<>();
//    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private List<ChiTietHoaDon> listGioHang = new ArrayList<>();
    private ChiTietHDService chiTietHDService = new ChiTietHDSerivceImpl();
    private DangNhapService dangNhapService = new DangNhapServiceImpl();

    /**
     * Creates new form FormHoaDon
     */
    public FormHoaDon() {
        initComponents();
//        tableChung.setModel(tbChung);
//        String[] header = {"Mã", "Tình trạng"};
//        tbChung.setColumnIdentifiers(header);
//        listHD = hoaDonService.getAll();
//        showDataHD(listHD);
//        tableChiTiet.setModel(tbChiTiet);
//        String[] headerr = {"Mã HD", "Mã SP", "Số lượng", "Tổng tiền"};
//        tbChiTiet.setColumnIdentifiers(headerr);
//        listcthd = chiTietHDService.getAll();
//        showDatacthd(listcthd);
        fillTableHDDaTT();
        fillTableSP();
        fillTableHD();
    }

//    public void fillhdct() {
//        tableHoaDonDaThanhToan.setModel(tbHDDaTT);
//        String[] headerr = {"Mã HD", "Mã SP", "Số lượng SP", "Tổng tiền"};
//        tbHDDaTT.setColumnIdentifiers(headerr);
//    }
    public void fillTableHD() {
        tableHoaDon.setModel(tbHD);
        String[] header = {"Mã HD", "Ngày tạo", "Trạng thái"};
        tbHD.setColumnIdentifiers(header);
        int trangThai = 0;
        List<HoaDon> listft = new HoaDonServiceImpl().searchByTrangThai(listHD, trangThai);
        showDataHD(listft);
    }

    public void fillTableHDDaTT() {
        tableHoaDonDaThanhToan.setModel(tbHDDaTT);
        String[] header = {"Mã HD", "Ngày tạo", "Tổng tiền", "Trạng thái"};
        tbHDDaTT.setColumnIdentifiers(header);
        listHD = hoaDonService.getAllhd();
        int trangThai = 1;
        List<HoaDon> listft = new HoaDonServiceImpl().searchByTrangThai(listHD, trangThai);
        showDataHDDaTT(listft);
    }

    private void showDataHD(List<HoaDon> lists) {
        tbHD.setRowCount(0);
        for (HoaDon x : lists) {
            tbHD.addRow(x.toDataRow());
        }

    }

    private void showDataHDDaTT(List<HoaDon> lists) {
        tbHDDaTT.setRowCount(0);
        for (HoaDon x : lists) {
            tbHDDaTT.addRow(x.toDataRoww());
        }

    }
//

    public void fillTableSP() {
        tableSanPham.setModel(tbSanPham);
        String[] header = {"Mã", "Tên", "Giá bán", "Số lượng"};
        tbSanPham.setColumnIdentifiers(header);
        listSP = hoaDonService.getAllsp();
        showDatasp(listSP);
    }

    private void showDatasp(List<SanPhamCT_ViewModel> lists) {
        tbSanPham.setRowCount(0);
        for (SanPhamCT_ViewModel x : lists) {
            tbSanPham.addRow(x.toDataRow());
        }
    }

//    private void showDatahdct(List<ChiTietHoaDon> lists) {
//        tbHDDaTT.setRowCount(0);
//        for (ChiTietHoaDon x : lists) {
//            tbHDDaTT.addRow(x.toDataRow());
//        }
//    }
    private void loadHoaDonChiTiet(String maHoaDon) {
        List<ChiTietHoaDon> listChiTiet = listGioHang.stream()
                .filter(ct -> ct.getHd().equals(maHoaDon))
                .toList();

        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();

        model.setColumnCount(0);
        model.addColumn("Mã hóa đơn");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Số lượng");
        model.addColumn("Thành tiền");

        model.setRowCount(0);
        for (ChiTietHoaDon chiTiet : listChiTiet) {
            int soLuong = chiTiet.getSoLuong();
            int donGia = chiTiet.getDonGia();
            Object[] row = new Object[]{
                chiTiet.getHd(),
                chiTiet.getMasp(),
                chiTiet.getSoLuong(),
                chiTiet.getDonGia() * chiTiet.getSoLuong(),};

            model.addRow(row);
        }
    }

    private void clear() {
        txtGiaTien.setText("0");
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtTienDu.setText("0");
        txtTienMat.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtGiaTien = new javax.swing.JTextField();
        txtTienMat = new javax.swing.JTextField();
        txtTienDu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        btnChonHD = new javax.swing.JButton();
        btnChonTT = new javax.swing.JButton();
        btnChonSP = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableHoaDonDaThanhToan = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar1.add(jMenu6);

        jMenu7.setText("jMenu7");

        setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Hóa đơn chi tiết");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Sản Phẩm");

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableGioHang);

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableSanPham);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Thông tin");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Mã hóa đơn");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Ngày tạo");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tổng tiền");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Tiền khách đưa");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tiền trả lại");

        btnThanhToan.setBackground(new java.awt.Color(51, 102, 255));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNgayTao.setEditable(false);
        txtNgayTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGiaTien.setEditable(false);
        txtGiaTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTienMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTienMat.setText("0");
        txtTienMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienMatKeyReleased(evt);
            }
        });

        txtTienDu.setEditable(false);
        txtTienDu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTienDu.setText("0");
        txtTienDu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienDuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(222, 222, 222))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(33, 33, 33)
                            .addComponent(txtTienDu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(btnThanhToan)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaHD)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTienDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Hóa Đơn Chờ");

        btnTaoHD.setBackground(new java.awt.Color(51, 102, 255));
        btnTaoHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTaoHD.setText("Tạo HD");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnChonHD.setBackground(new java.awt.Color(51, 102, 255));
        btnChonHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChonHD.setText("Chọn HD");
        btnChonHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonHDActionPerformed(evt);
            }
        });

        btnChonTT.setBackground(new java.awt.Color(51, 102, 255));
        btnChonTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChonTT.setText("Đồng ý thanh toán");
        btnChonTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonTTActionPerformed(evt);
            }
        });

        btnChonSP.setBackground(new java.awt.Color(51, 102, 255));
        btnChonSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChonSP.setText("Chọn SP");
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
            }
        });

        btnXoaHD.setBackground(new java.awt.Color(51, 102, 255));
        btnXoaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoaHD.setText("Xóa HD");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableHoaDon);

        jTabbedPane1.addTab("Hóa Đơn Chờ", jScrollPane2);

        tableHoaDonDaThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableHoaDonDaThanhToan);

        jDesktopPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Hóa đơn đã thanh toán", jDesktopPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnChonTT)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnChonHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnXoaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnChonSP)))
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnTaoHD)
                                .addGap(34, 34, 34)
                                .addComponent(btnChonHD)
                                .addGap(30, 30, 30)
                                .addComponent(btnXoaHD))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btnChonTT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonSP))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        String ma = ZenMA();
        LocalDate ngayTao = java.time.LocalDate.now();
        int trangThai = 0;
        tbHD.setRowCount(0);
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(ma);
        hd.setNgayLap(String.valueOf(ngayTao));
        hd.setTinhTrang(trangThai);
//            Object[] row = new Object[]{
//                hd.getMaHoaDon(),
//                hd.getNgayLap(),
//                hd.getTinhTrang()
//            };

        listHD.add(hd);
        List<HoaDon> listft = new HoaDonServiceImpl().searchByTrangThai(listHD, trangThai);
        showDataHD(listft);
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (Integer.valueOf(txtTienDu.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại!");
        } else {
            String ma = txtMaHD.getText();
            String ngayTao = txtNgayTao.getText();
            int trangThai = 1;
            int tongTien = Integer.valueOf(txtGiaTien.getText());
            LuuMa l = new LuuMa();
            String manv = "NV1";

            for (HoaDon hd : listHD) {
                if (hd.getMaHoaDon().equals(ma)) {
                    hd.setTinhTrang(trangThai);
                    listHD.add(hd);
                    break;
                }
            }

            HoaDon hd = new HoaDon(ma, manv, ngayTao, tongTien, trangThai);

            String add = hoaDonService.add(hd);
            JOptionPane.showMessageDialog(this, add);

//      them cthd
            int rowCount = tbGioHang.getRowCount();

            int selectrow = tableHoaDon.getSelectedRow();

//        String masp = txtMaSp.getText();
//        String sl = txtSl.getText();
//        ChiTietHoaDon ct = new ChiTietHoaDon(ma, masp, Integer.valueOf(sl), tongTien);
//        String addct = chiTietHDService.add(ct);
//        JOptionPane.showMessageDialog(this, addct);
            //update
//            int index = tableSanPham.getSelectedRow();
//            int slcon = tbSanPham.getValueAt(index, index);
            for (int x = 0; x < rowCount; x++) {
                String masp = tbGioHang.getValueAt(x, 1).toString();
                int soLuong = Integer.valueOf(tbGioHang.getValueAt(x, 2).toString());
                int slcon = 100 - soLuong;
                SanPhamCT_ViewModel spct = new SanPhamCT_ViewModel(masp, slcon);
                chiTietHDService.uodatesl(spct, masp);

            }
            fillTableSP();
//        int slsp = Integer.valueOf(slcon) - Integer.valueOf(sl);
//        SanPhamCT_ViewModel spct = new SanPhamCT_ViewModel(masp, slsp);
//        String update = chiTietHDService.uodatesl(spct, masp);
//        JOptionPane.showMessageDialog(this, update);
            listSP = hoaDonService.getAllsp();
            showDatasp(listSP);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            fillTableHDDaTT();
            fillTableHD();
            clear();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienMatKeyReleased
        // TODO add your handling code here:
        int traLai = (Integer.valueOf(txtTienMat.getText()) - Integer.valueOf(txtGiaTien.getText()));
        txtTienDu.setText(String.valueOf(traLai));
    }//GEN-LAST:event_txtTienMatKeyReleased

    private void txtTienDuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienDuKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienDuKeyReleased

    private void btnChonTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonTTActionPerformed
        // TODO add your handling code here:

        int tongTien = 0;
        for (int i = 0; i < tableGioHang.getRowCount(); i++) {

            tongTien = tongTien + Integer.parseInt(tableGioHang.getValueAt(i, 3).toString());
        }
//        String mahd = tbGioHang.getValueAt(1, 0).toString();
//        txtMaHD.setText(mahd);

        int ii = tableHoaDon.getSelectedRow();
        String ngayLap = tbHD.getValueAt(ii, 1).toString();
        String mahd = tbHD.getValueAt(ii, 0).toString();
        txtMaHD.setText(mahd);
        txtNgayTao.setText(ngayLap);
        txtGiaTien.setText(Integer.toString(tongTien));

    }//GEN-LAST:event_btnChonTTActionPerformed

    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed
        // TODO add your handling code here:
        int check = 0;
        int i = tableSanPham.getSelectedRow();
        String maSanPham = tbSanPham.getValueAt(i, 0).toString();
        String tenSP = tbSanPham.getValueAt(i, 1).toString();
        int donGia = Integer.valueOf(tbSanPham.getValueAt(i, 2).toString());
        int soLuong = 1;
        SanPhamCT_ViewModel sp = listSP.stream().filter(s -> s.getMaSP().equals(maSanPham)).findFirst().orElse(null);

        int selectHD = tableHoaDon.getSelectedRow();
        String mahd = tbHD.getValueAt(selectHD, 0).toString();
        ChiTietHoaDon list = new ChiTietHoaDon();
        list.setHd(mahd);
        list.setMasp(maSanPham);
        list.setDonGia(sp.getGiaBan());
        list.setSoLuong(soLuong);
        boolean isNotExisted = true;
        for (ChiTietHoaDon h : listGioHang) {
            if (h.getHd().equals(mahd)
                    && h.getMasp().equals(maSanPham)) {
                h.setSoLuong(h.getSoLuong() + list.getSoLuong());
                isNotExisted = false;
                break;
            }
        }
        if (isNotExisted) {
            listGioHang.add(list);
        }
        loadHoaDonChiTiet(mahd);

    }//GEN-LAST:event_btnChonSPActionPerformed

    private void btnChonHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonHDActionPerformed
        // TODO add your handling code here:
        int i = tableHoaDon.getSelectedRow();
        String mahd = tbHD.getValueAt(i, 0).toString();
        loadHoaDonChiTiet(mahd);
    }//GEN-LAST:event_btnChonHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        // TODO add your handling code here:
        int i = tableHoaDon.getSelectedRow();
        tbHD.removeRow(i);
    }//GEN-LAST:event_btnXoaHDActionPerformed
    public String ZenMA() {
        Random rd = new Random();
        int ranNub = rd.nextInt(99999);
        return "HD" + ranNub;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonHD;
    private javax.swing.JButton btnChonSP;
    private javax.swing.JButton btnChonTT;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tableHoaDonDaThanhToan;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTienDu;
    private javax.swing.JTextField txtTienMat;
    // End of variables declaration//GEN-END:variables
}
