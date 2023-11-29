/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ChiTietHoaDon;
import viewmodel.HoaDon;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public interface ChiTietHDService {

    List<ChiTietHoaDon> getAll();

    String add(ChiTietHoaDon cthd);
    
    String addSP(ChiTietHoaDon nv, String ma);
    
    String uodatesl(SanPhamCT_ViewModel nv, String ma);
    
    HoaDon getOne(String ma);
}
