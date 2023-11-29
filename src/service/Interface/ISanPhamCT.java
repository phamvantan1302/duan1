/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import domainModel.SanPhamCT;
import viewmodel.SanPhamCT_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ISanPhamCT {
    List<SanPhamCT_ViewModel> getAllSanPhamCT();
    List<SanPhamCT_ViewModel> getAllSP();
    List<SanPhamCT_ViewModel> getAllSanPham(String input);
    int insert(SanPhamCT sp);
    int update(SanPhamCT sp,String ma);
    int delete(String ma);
}
