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
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import view.QuanLyNhanVienPanel;

/**
 *
 * @author HoangPC
 */
public class NhanVienRightClickPopUp extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NhanVienRightClickPopUp(String loaiBtnXoa, QuanLyNhanVienPanel qlnv) {
		JMenuItem sua = new JMenuItem("Cập nhật");
		sua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qlnv.thaoTacKhiSua();
			}
		});
		add(sua);
		sua.setFont(new Font("Arial", Font.BOLD, 14));
		
		JMenuItem xoa = new JMenuItem(loaiBtnXoa);
		xoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qlnv.doiTrangThaiNhanVien();
			}
		});

		add(new JSeparator());
		add(xoa);
		xoa.setFont(new Font("Arial", Font.BOLD, 14));
	}

}
