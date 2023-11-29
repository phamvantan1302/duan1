/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import repository.KhachHangRepository;
import service.Interface.IkhachHangService;
import viewmodel.KhachHang;

/**
 *
 * @author Dell
 */
public class KhachHangServiceImpl implements IkhachHangService {

    KhachHangRepository rep = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return rep.getALl();
    }

    @Override
    public String add(KhachHang kh) {
        boolean add = rep.add(kh);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = rep.delete(ma);
        if (add) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }

    @Override
    public String update(KhachHang kh, String ma) {
        boolean add = rep.update(kh, ma);
        if (add) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public List<KhachHang> searchByLoai(List<KhachHang> listKH, String ten) {
        List<KhachHang> lists = new ArrayList<>();
        for (KhachHang x : listKH) {
            if (x.getTen().contains(ten)) {
                lists.add(x);
            }
        }
        return lists;
    }

}
