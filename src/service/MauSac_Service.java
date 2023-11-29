/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainModel.ThuocTinhSP;
import repository.MauSac_Repository;
import Service.Interface.IMauSacService;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class MauSac_Service implements IMauSacService{
    MauSac_Repository msRepo = new MauSac_Repository();

    @Override
    public List<ThuocTinh_ViewModel> getAllMauSac() {
        return msRepo.getAllThuocTinh();
    }

    @Override
    public int themMauSac(ThuocTinhSP tt) {
        return msRepo.themMauSac(tt);
    }

    @Override
    public int suaMauSac(ThuocTinhSP tt, String ma) {
        return msRepo.suaMauSac(tt, ma);
    }

    @Override
    public int xoaMauSac( String ma) {
        return msRepo.xoaMauSac(ma);
    }

    @Override
    public String getAllMaMauSacbyTen(String ma) {
        return this.msRepo.getAllMaMauSacbyTen(ma);
    }

    @Override
    public ThuocTinhSP getAllMauSacByMa(String ma) {
        return this.msRepo.getAllMauSacByMa(ma);
    }

    @Override
    public String getMaMauSac(String ten) {
        return this.msRepo.getMaMauSac(ten);
    }
    
}
