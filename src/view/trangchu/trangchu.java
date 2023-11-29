/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.trangchu;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import view.component.Header;
import view.component.menu;
import view.duan.icon.GoogleMaterialDesignIcons;
import view.duan.icon.IconFontSwing;
import view.duan.swing.MenuItem;
import view.duan1.event.EventMenuSelected;
import view.duan1.event.EventShowPopupMenu;
import view.form.FormHoaDon;
import view.form.FormSanPham;
import view.form.ViewEmail;
import view.form.ViewHoaDonAll;
import view.form.ViewSanPham;
import view.form.ViewsKhachHang;
import view.form.ViewsNhanVien;

import view.form.form_home;
import view.form.mainform;
import view.logiin.DangNhapForm;

/**
 *
 * @author ADMIN
 */
public class trangchu extends javax.swing.JFrame {

    private MigLayout layout;
    private menu menuBar;
    private Header header;
    private Animator animator;
    private mainform main;

    public trangchu() {
        initComponents();
        init();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void showForm(JFrame frame) {
        frame.setVisible(true);
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menuBar = new menu();
        header = new Header();
        main = new mainform();
        menuBar.addEvent(new EventMenuSelected() {

            @Override
            public void menuSelect(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 1) {
                    if (subMenuIndex == -1) {
                        main.showForm(new FormHoaDon());
                    }
                } else if (menuIndex == 2) {
                    if (subMenuIndex == -1) {
                        main.showForm(new FormSanPham());
                    }

                } else if (menuIndex == 4) {
                    if (subMenuIndex == -1) {
                        main.showForm(new ViewsNhanVien());
                    }

                } else if (menuIndex == 3) {
                    if (subMenuIndex == -1) {
                        main.showForm(new ViewsKhachHang());

                    }
                } else if (menuIndex == 6) {
                    if (subMenuIndex == -1) {
                        DangNhapForm dn = new DangNhapForm();
                        dn.setVisible(true);
                        trangchu tc = new trangchu();
                        tc.setVisible(false);

                    }
                } else if (menuIndex == 0) {
                    if (subMenuIndex == -1) {
                        main.showForm(new form_home());
                    }

                }

            }
        });
        menuBar.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                //PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                view.duan.swing.PopupMenu popup = new view.duan.swing.PopupMenu(trangchu.this, item.getIndex(), item.getEnventSelect(), item.getMenu().getSubMenu());
                int x = trangchu.this.getX() + 52;
                int y = trangchu.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menuBar.initMenuItem();
        bg.add(menuBar, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuBar.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menuBar, "w " + width + "!, spany2");
                menuBar.revalidate();
            }

            @Override
            public void end() {
                menuBar.setShowMenu(!menuBar.isShowMenu());
                menuBar.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menuBar.setEnableMenu(false);
                if (menuBar.isShowMenu()) {
                    menuBar.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new form_home());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trangchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
