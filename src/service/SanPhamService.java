/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainModel.SanPhamCT;
import repository.SanPhamCT_Repository;
import Service.Interface.ISanPhamCT;
import viewmodel.SanPhamCT_ViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class SanPhamService implements ISanPhamCT{
    SanPhamCT_Repository SPSer = new SanPhamCT_Repository();

    @Override
    public List<SanPhamCT_ViewModel> getAllSanPhamCT() {
        return this.SPSer.getAllSanPhamCT();
    }

    @Override
    public int insert(SanPhamCT sp) {
        return SPSer.insert(sp);
    }

    @Override
    public int update(SanPhamCT sp, String ma) {
        return SPSer.update(sp, ma);
    }

    @Override
    public int delete(String ma) {
        return SPSer.delete(ma);
    }
    @Override
    public List<SanPhamCT_ViewModel> getAllSanPham(String input) {
                if(input==null){
            return SPSer.getAllSanPhamCT();
        }
        List<SanPhamCT_ViewModel> l = new  ArrayList<>();
        for (var x : SPSer.getAllSanPhamCT()) {
            if(x.getMaSP().toLowerCase().contains(input.toLowerCase())||
                    x.getTenMu().toLowerCase().contains(input.toLowerCase())||
                    x.getTenHang().toLowerCase().contains(input.toLowerCase())||
                    x.getTenChatLieu().toLowerCase().contains(input.toLowerCase())||
                    x.getTenMauSac().toLowerCase().contains(input.toLowerCase())||
                    
                    x.getTenKieuMu().toLowerCase().contains(input.toLowerCase())||
                    x.getTenKinh().toLowerCase().contains(input.toLowerCase())||
                    String.valueOf(x.getGiaBan()).toLowerCase().contains(input.toLowerCase())|| 
                    String.valueOf(x.getSoLuong()).toLowerCase().contains(input.toLowerCase())){
                l.add(x);
                System.out.println(x.getTenMu().concat(x.getTenChatLieu()).toLowerCase().contains(input.toLowerCase()));
            }
        }
        
        return l;
    }

    @Override
    public List<SanPhamCT_ViewModel> getAllSP() {
        return SPSer.getAllSP();
    }


    
}
