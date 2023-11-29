/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.DangNhapRepository;
import service.DangNhapService;
import viewmodel.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public class DangNhapServiceImpl implements DangNhapService{
    private DangNhapRepository dangNhapRepository = new DangNhapRepository();

    @Override
    public List<NhanVienModel> getAll() {
        return dangNhapRepository.getAll();
    }
    
}
