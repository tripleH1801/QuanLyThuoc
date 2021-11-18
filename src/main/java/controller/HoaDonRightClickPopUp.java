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

import view.QuanLyHoaDonPanel;
import view.QuanLyKhachHangPanel;
import view.QuanLyNhanVienPanel;

/**
 *
 * @author HoangPC
 */
public class HoaDonRightClickPopUp extends JPopupMenu{
	private static final long serialVersionUID = -6676998227285162727L;

	public HoaDonRightClickPopUp(QuanLyHoaDonPanel qlhd) {
                JMenuItem xem = new JMenuItem("Xem chi tiết");
                xem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	qlhd.xemChiTiet();
                    }
                });
                add(xem);
                xem.setFont(new Font("Arial", Font.BOLD, 14));
    }
    
}
