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
import view.BanThuocJPanel;

/**
 *
 * @author HoangPC
 */
public class RightClickPopUp extends JPopupMenu{

    public RightClickPopUp(String loaiMuc, BanThuocJPanel banThuocPanel) {
        switch(loaiMuc){
            case("btdsthuoc"):
                JMenuItem add = new JMenuItem("Thêm thuốc vào giỏ hàng");
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banThuocPanel.showDialogThem();
                    }
                });
                add.setFont(new Font("Arial", Font.BOLD, 14));
                add(add);
                
                JMenuItem details = new JMenuItem("Chi tiết thuốc");
                details.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banThuocPanel.xemChiTiet();
                    }
                });
                details.setFont(new Font("Arial", Font.BOLD, 14));
                add(details);
                break;
            
            case("bthd"):
                JMenuItem change = new JMenuItem("Đổi số lượng");
                change.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banThuocPanel.doiVaShowDialog();
                    }
                });
                change.setFont(new Font("Arial", Font.BOLD, 14));
                add(change);
                add(new JSeparator());
                
                JMenuItem delete = new JMenuItem("Trả lại");
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banThuocPanel.traLaiThuoc();
                    }
                });
                delete.setFont(new Font("Arial", Font.BOLD, 14));
                add(delete);
                JMenuItem details1 = new JMenuItem("Chi tiết thuốc");
                details1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banThuocPanel.xemChiTiet();
                    }
                });
                details1.setFont(new Font("Arial", Font.BOLD, 14));
                add(details1);
                break;
          
        }
    }
    
}
