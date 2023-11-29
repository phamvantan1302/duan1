/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import repository.HoaDonRepository;
import service.HoaDonService;
import viewmodel.HoaDon;
import viewmodel.KhachHang;
import viewmodel.NhanVienModel;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public class HoaDonServiceImpl implements HoaDonService{
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public String add(HoaDon hd) {
        boolean add = hoaDonRepository.add(hd);
        if (add) {
            return "Thanh toan thanh cong";
        } else {
            return "Thanh toan that bai";
        }
    }

    @Override
    public List<KhachHang> getAllkh() {
        return hoaDonRepository.getAllkh();
    }

    @Override
    public String delete(String ma) {
        boolean add = hoaDonRepository.delete(ma);
        if (add) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

    @Override
    public List<SanPhamCT_ViewModel> getAllsp() {
        return hoaDonRepository.getAllsp();
    }

    @Override
    public List<HoaDon> searchByTrangThai(List<HoaDon> listHD, int trangThai) {
        List<HoaDon> lists = new ArrayList<>();
        for (HoaDon x : listHD) {
            if (x.getTinhTrang()== trangThai) {
                lists.add(x);
            }
        }
        return lists;
    }

    @Override
    public List<HoaDon> getAllhd() {
        return hoaDonRepository.getAllhd();
    }

    
    
}
