/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.SanPhamCT;
import java.util.List;
import viewmodel.HoaDon;
import viewmodel.KhachHang;
import viewmodel.NhanVienModel;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public interface HoaDonService {
    List<HoaDon> getAll();
    
    List<KhachHang> getAllkh();
    
    List<HoaDon> getAllhd();
    
    List<SanPhamCT_ViewModel> getAllsp();

    String add(HoaDon hd);
    
    String delete(String ma);
    List<HoaDon> searchByTrangThai(List<HoaDon> listHD, int trangThai);
}
