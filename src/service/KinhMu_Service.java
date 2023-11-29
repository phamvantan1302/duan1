/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainModel.ThuocTinhSP;
import repository.KinhMu_Repository;
import Service.Interface.IKinhMuService;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class KinhMu_Service implements IKinhMuService{
    KinhMu_Repository muRepo = new KinhMu_Repository();

    @Override
    public List<ThuocTinh_ViewModel> getAllKinhMu() {
        return muRepo.getAllthuocTinh();
    }

    @Override
    public int themKinhMu(ThuocTinhSP tt) {
        return this.muRepo.themKinhMu(tt);
    }

    @Override
    public int suaKinhMu(ThuocTinhSP tt, String ma) {
        return this.muRepo.suaKinhMu(tt, ma);
    }

    @Override
    public int xoaKinhMu( String ma) {
        return this.muRepo.xoaKinhMu(ma);
    }

    @Override
    public String getAllMaKinhMubyTen(String ma) {
        return this.muRepo.getAllMaKinhMubyTen(ma);
    }

    @Override
    public ThuocTinhSP getAllKinhMuByMa(String ma) {
        return this.muRepo.getAllKinhMuByMa(ma);
    }

    @Override
    public String getMaKinhMu(String ten) {
        return this.muRepo.getMaKinhMu(ten);
    }
    
}
