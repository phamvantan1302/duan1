/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainModel.ThuocTinhSP;
import repository.HangSanXuat_Repository;
import Service.Interface.IHangSanXuatService;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class HangSanXuat_Service implements IHangSanXuatService{
    HangSanXuat_Repository SXRepo = new HangSanXuat_Repository();

    @Override
    public List<ThuocTinh_ViewModel> getAllHangSanXuat() {
        return SXRepo.getAllThuocTinh();
    }

    @Override
    public int themHangSanXuat(ThuocTinhSP tt) {
        return SXRepo.themHangSanXuat(tt);
    }

    @Override
    public int suaHangSanXuat(ThuocTinhSP tt, String ma) {
        return SXRepo.suaHangSanXuat(tt, ma);
    }

    @Override
    public int xoaHangSanXuat( String ma) {
        return SXRepo.xoaHangSanXuat(ma);
    }

    @Override
    public String getAllMaHangSanXuatbyTen(String ma) {
        return this.SXRepo.getAllMaHangSanXuatbyTen(ma);
    }

    @Override
    public ThuocTinhSP getAllHangSanXuatByMa(String ma) {
        return this.SXRepo.getAllHangSanXuatByMa(ma);
    }

    @Override
    public String getMaHangSanXuat(String ten) {
        return  this.SXRepo.getMaHangSanXuat(ten);
    }


  
}
