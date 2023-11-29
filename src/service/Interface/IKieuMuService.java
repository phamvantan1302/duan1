/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import domainModel.ThuocTinhSP;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IKieuMuService {
    List<ThuocTinh_ViewModel> getAllKieuMu();
    String getAllMaKieuMubyTen(String ma);
    ThuocTinhSP getAllKieuMuByMa(String ma);
    String getMaKieuMu(String ten);
    int themKieuMu(ThuocTinhSP tt);
    
    int suaKieuMu(ThuocTinhSP tt, String ma);
    
    int xoaKieuMu(String ma);
}
