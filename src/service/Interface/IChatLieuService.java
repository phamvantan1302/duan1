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
public interface IChatLieuService {
        List<ThuocTinh_ViewModel> getAllChatLieuView();
    String getAllMaChatLieubyTen(String ma);
    ThuocTinhSP getAllChatLieuByMa(String ma);
    String getMaChatLieu(String ten);
    
    int themChatLieu(ThuocTinhSP tt);
    
    int suaChatLieu(ThuocTinhSP tt, String ma);
    
    int xoaChatLieu( String ma);
}
