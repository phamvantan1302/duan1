/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainModel.ThuocTinhSP;
import repository.KieuMu_Repository;
import Service.Interface.IKieuMuService;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class KieuMu_Service implements IKieuMuService{
    KieuMu_Repository KMRepo = new KieuMu_Repository();

    @Override
    public List<ThuocTinh_ViewModel> getAllKieuMu() {
        return KMRepo.getAllthuocTinh();
    }
    @Override
    public int themKieuMu(ThuocTinhSP tt) {
        return KMRepo.themKieuMu(tt);
    }
    @Override
    public int suaKieuMu(ThuocTinhSP tt, String ma) {
        return KMRepo.suaKieuMu(tt, ma);
    }
    @Override
    public int xoaKieuMu(String ma) {
        return KMRepo.xoaKieuMu(ma);
    }

    @Override
    public String getAllMaKieuMubyTen(String ma) {
        return this.KMRepo.getAllMaKieuMubyTen(ma);
        }

    @Override
    public ThuocTinhSP getAllKieuMuByMa(String ma) {
        return this.KMRepo.getAllKieuMuByMa(ma);
    }

    @Override
    public String getMaKieuMu(String ten) {
        return this.KMRepo.getMaKieuMu(ten);
    }

}
