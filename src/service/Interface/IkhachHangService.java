/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import java.util.List;
import viewmodel.KhachHang;

/**
 *
 * @author Dell
 */
public interface IkhachHangService {
    List<KhachHang> getAll();

    String add(KhachHang kh);

    String delete(String ma);

    String update(KhachHang kh, String ma);
    
     List<KhachHang> searchByLoai(List<KhachHang> listKH, String ten);
}
