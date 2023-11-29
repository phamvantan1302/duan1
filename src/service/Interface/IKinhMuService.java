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
public interface IKinhMuService {
    List<ThuocTinh_ViewModel> getAllKinhMu();
    String getAllMaKinhMubyTen(String ma);
    ThuocTinhSP getAllKinhMuByMa(String ma);
    String getMaKinhMu(String ten);
    int themKinhMu(ThuocTinhSP tt);
    
    int suaKinhMu(ThuocTinhSP tt, String ma);
    
    int xoaKinhMu(String ma);
}
