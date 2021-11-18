/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import view.QuanLyKhachHangPanel;
import view.QuanLyNhanVienPanel;

/**
 *
 * @author HoangPC
 */
public class KhachHangRightClickPopUp extends JPopupMenu{

    public KhachHangRightClickPopUp(String loaiMuc, QuanLyKhachHangPanel qlkh) {
                JMenuItem sua = new JMenuItem("Cập nhật");
                JMenuItem xoa = new JMenuItem("Xóa");
                sua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        qlkh.hienGDSua();
                    }
                });
                add(sua);
                sua.setFont(new Font("Arial", Font.BOLD, 14));
                
                xoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        qlkh.xoaKH();
                    }
                });
                add(new JSeparator());
                add(xoa);
                xoa.setFont(new Font("Arial", Font.BOLD, 14));
    }
    
}
