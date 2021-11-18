/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMucBean;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.QuanLyThuocJPanel;
import view.ThongKe;
import view.ThongKeQuanLy;
import view.BanThuocJPanel;
import view.QuanLyKhachHangPanel;
import view.QuanLyHoaDonPanel;
import view.QuanLyNhanVienPanel;
import view.QuanLyTaiKhoan;
import view.gui_Chinh;

/**
 *
 * @author HoangPC
 */
public class ChuyenManHinh {
	private JPanel root;
	private String kindSelected = "";
	private List<DanhMucBean> list = null;
	private gui_Chinh gui;

	public ChuyenManHinh(JPanel root, gui_Chinh gui) {
		this.root = root;
		this.gui = gui;
	}

	public void setView(JPanel jpnItem, JLabel jlbItem) {
		kindSelected = "banthuoc";
		jpnItem.setBackground(new Color(1, 128, 145)); // mau khi nut dc chon
		jlbItem.setBackground(new Color(1, 128, 145));

		root.removeAll();
		root.add(new BanThuocJPanel(gui, "", ""), kindSelected);
		root.validate(); // ?
		root.repaint(); // reload
	}

	public void setEvent(List<DanhMucBean> list) { // set event cho cac btn(lbl + panel)
		this.list = list;
		for (DanhMucBean i : list) {
			i.getJlb().addMouseListener(new LableEvent(i.getKind(), i.getJpn(), i.getJlb()));
		}
	}

	class LableEvent implements MouseListener {

		private JPanel node;
		private String kind;

		private JPanel jpnItem;
		private JLabel jlbItem;

		public LableEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		// tim cach su dung thread
		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
			case "banthuoc":
//                    node = new BanThuocJPanel(gui, "", "", "", "", "", "", "", "", "", "", "");
				node = new BanThuocJPanel(gui, "", "");
				break;
			case "quanlythuoc":
				node = new QuanLyThuocJPanel();
				break;
			case "quanlykhachhang":
//                    node = new QuanLyKhachHangPanel(new gui_Chinh(), false, new BanThuocJPanel(), list, "", "", "", "", "", "", "", "", "", "", "");
				node = new QuanLyKhachHangPanel(gui, false);
				break;
			case "quanlyhoadon":
				node = new QuanLyHoaDonPanel();
				break;
			case "quanlynv":
				node = new QuanLyNhanVienPanel();
				break;
			case "thongke":
				node = new ThongKe(gui);
				break;
			case "thongkequanly":
				node = new ThongKeQuanLy(gui);
				break;
			case "quanlytk":
                node = new QuanLyTaiKhoan(gui, "");
                break;
			default:
				break;
			}
			setBackgorund(kind);// moi them
			root.removeAll();
			root.add(node, kind);
			root.validate();
			root.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			kindSelected = kind;
			jpnItem.setBackground(new Color(1, 128, 145));// mau sau khi chon
			jlbItem.setBackground(new Color(1, 128, 145));
			setBackgorund(kind);// moi them
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (!kindSelected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(66, 87, 117)); // mau khi hover
				// jlbItem.setBackground(new Color (66,87,117));
			} else {
				jpnItem.setBackground(new Color(1, 128, 145));// mau sau khi chon
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!kindSelected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(29, 53, 87)); // mau ban dau luc chua chon
				// jlbItem.setBackground(new Color(29,53,87));
			} else {
				jpnItem.setBackground(new Color(1, 128, 145));// khi hover qua nut da chon se ko tra ve 'mau luc chon'
																// cua nut
				// jlbItem.setBackground(new Color (1,128,145));
			}
		}
	}

	private void setBackgorund(String kind) {
		for (DanhMucBean i : list) {
			if (i.getKind().equalsIgnoreCase(kind)) {
				// i.getJlb().setBackground(new Color (1,128,145)); // mau khi chon xong
				i.getJpn().setBackground(new Color(1, 128, 145));
			} else {
				i.getJpn().setBackground(new Color(29, 53, 87));
				// i.getJlb().setBackground(new Color(29,53,87));
			}
		}
	}
}
