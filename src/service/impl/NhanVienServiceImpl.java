/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import repository.NhanVienRepository;
import service.NhanVienService;
import viewmodel.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public class NhanVienServiceImpl implements NhanVienService{
    
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    
    @Override
    public List<NhanVienModel> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public String add(NhanVienModel nv) {
        boolean add = nhanVienRepository.add(nv);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = nhanVienRepository.delete(ma);
        if (add) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }

    @Override
    public String update(NhanVienModel nv, String ma) {
        boolean add = nhanVienRepository.update(nv, ma);
        if (add) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public List<NhanVienModel> searchByLoai(List<NhanVienModel> listNV, String ten) {
        List<NhanVienModel> lists = new ArrayList<>();
        for (NhanVienModel x : listNV) {
            if (x.getTen().contains(ten)) {
                lists.add(x);
            }
        }
        return lists;
    }

    @Override
    public List<NhanVienModel> searchByTrangThai(List<NhanVienModel> listNV, boolean trangThai) {
        List<NhanVienModel> lists = new ArrayList<>();
        for (NhanVienModel x : listNV) {
            if (x.isTrangThai() == trangThai) {
                lists.add(x);
            }
        }
        return lists;
    }
    
}
