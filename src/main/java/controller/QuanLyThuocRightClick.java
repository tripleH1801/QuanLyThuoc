package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import view.QuanLyThuocJPanel;

public class QuanLyThuocRightClick extends JPopupMenu{
	
	public QuanLyThuocRightClick(String loaiBtnXoa, QuanLyThuocJPanel qlt) {
		JMenuItem btnXemChiTiet = new JMenuItem("Chi tiết");
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlt.xemChiTiet();
			}
		});
		btnXemChiTiet.setFont(new Font("Arial", Font.BOLD, 14));
		
		JMenuItem btnsuaThuoc = new JMenuItem("Cập nhật");
		btnsuaThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlt.suaThuoc();
			}
		});
		btnsuaThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		
		JMenuItem btnXoa = new JMenuItem(loaiBtnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlt.ngungKinhDoanh();
			}
		});
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(btnXemChiTiet);
		add(btnXoa);
		add(btnsuaThuoc);
	}
	
}
