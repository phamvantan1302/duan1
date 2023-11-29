/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Service.Interface.IChatLieuService;
import domainModel.ThuocTinhSP;
import repository.ChatLieu_Repository;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class ChatLieu_Service implements IChatLieuService{
    ChatLieu_Repository ClRepo = new ChatLieu_Repository();

    @Override
    public List<ThuocTinh_ViewModel> getAllChatLieuView() {
        return ClRepo.getAllThuocTinh();
    }

    @Override
    public int themChatLieu(ThuocTinhSP tt) {
        return ClRepo.themChatLieu(tt);
    }

    @Override
    public int suaChatLieu(ThuocTinhSP tt, String ma) {
        return this.ClRepo.suaChatLieu(tt, ma);
    }

    @Override
    public int xoaChatLieu( String ma) {
        return this.ClRepo.xoaChatLieu(ma);
    }

    @Override
    public String getAllMaChatLieubyTen(String ma) {
        return this.ClRepo.getAllMaChatLieubyTen(ma);
    }

    @Override
    public String getMaChatLieu(String ten) {
        return this.ClRepo.getMaChatLieu(ten);
    }

    @Override
    public ThuocTinhSP getAllChatLieuByMa(String ma) {
        return this.ClRepo.getAllChatLieuByMa(ma);
    }

}
