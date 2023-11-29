/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import repository.HangSanXuat_Repository;
import domainModel.ThuocTinhSP;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IHangSanXuatService {

    List<ThuocTinh_ViewModel> getAllHangSanXuat();
String getAllMaHangSanXuatbyTen(String ma);
    ThuocTinhSP getAllHangSanXuatByMa(String ma);
    String getMaHangSanXuat(String ten);
    int themHangSanXuat(ThuocTinhSP tt);

    int suaHangSanXuat(ThuocTinhSP tt, String ma);

    int xoaHangSanXuat( String ma);
}
