/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.ChiTietHDRepository;
import service.ChiTietHDService;
import viewmodel.ChiTietHoaDon;
import viewmodel.HoaDon;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public class ChiTietHDSerivceImpl implements ChiTietHDService{
    private ChiTietHDRepository chiTietHDRepository = new ChiTietHDRepository();
    @Override
    public List<ChiTietHoaDon> getAll() {
        return chiTietHDRepository.getAll();
    }

    @Override
    public String add(ChiTietHoaDon cthd) {
        boolean add = chiTietHDRepository.add(cthd);
        if (add) {
            return "them thanh cong";
        } else {
            return "them that bai";
        }
    }

    @Override
    public HoaDon getOne(String ma) {
        return null;
    }

    @Override
    public String addSP(ChiTietHoaDon nv, String ma) {
        boolean add = chiTietHDRepository.addSP(nv, ma);
        if (add) {
            return "them thanh cong";
        } else {
            return "them that bai";
        }
    }

    @Override
    public String uodatesl(SanPhamCT_ViewModel nv, String ma) {
        boolean add = chiTietHDRepository.updatesl(nv, ma);
        if (add) {
            return "upadte thanh cong";
        } else {
            return "update that bai";
        }
    }
    
}
