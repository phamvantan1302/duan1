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
public interface IMauSacService {
    List<ThuocTinh_ViewModel> getAllMauSac();
    String getAllMaMauSacbyTen(String ma);
    ThuocTinhSP getAllMauSacByMa(String ma);
    String getMaMauSac(String ten);
    int themMauSac(ThuocTinhSP tt);
    
    int suaMauSac(ThuocTinhSP tt, String ma);
    
    int xoaMauSac( String ma);
}
