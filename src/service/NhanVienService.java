/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public interface NhanVienService {

    List<NhanVienModel> getAll();

    String add(NhanVienModel nv);

    String delete(String ma);

    String update(NhanVienModel nv, String ma);

    List<NhanVienModel> searchByLoai(List<NhanVienModel> listNV, String ten);
    
    List<NhanVienModel> searchByTrangThai(List<NhanVienModel> listNV, boolean trangThai);
}
