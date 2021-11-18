/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: HP
* @date: 10 Nov 2020
* @version: 1.0
*/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connect.Connect;
import entity.DiaChi;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_KhachHang {
	DAO_DiaChi DAO_DiaChi = new DAO_DiaChi();

	public List<KhachHang> getAllKH() {

		String sql = "select * from KhachHang where trangThai=1 order by tenKhachHang";
		PreparedStatement statement = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
//				KhachHang kh= new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),rs.getString("soDienThoai"), new DiaChi(rs.getString("maDC")),rs.getBoolean("trangThai"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),
						rs.getBoolean("gioiTinh"), rs.getString("soDienThoai"),
						DAO_DiaChi.timDiaChiTheoMa(rs.getString("maDC")), rs.getBoolean("trangThai"));
				list.add(kh);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
	public List<KhachHang> getKHTheoGioiTinh(int gt) {

		String sql = "select * from KhachHang where gioiTinh = "+gt+" order by tenKhachHang";
		PreparedStatement statement = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
//				KhachHang kh= new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),rs.getString("soDienThoai"), new DiaChi(rs.getString("maDC")),rs.getBoolean("trangThai"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),
						rs.getBoolean("gioiTinh"), rs.getString("soDienThoai"),
						DAO_DiaChi.timDiaChiTheoMa(rs.getString("maDC")), rs.getBoolean("trangThai"));
				list.add(kh);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
	
	public KhachHang timKHTheoSDT(String sdt) {

		String sql = "select * from KhachHang where soDienThoai = ? ";
		PreparedStatement statement = null;
		KhachHang kh = new KhachHang();

		try {

			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),
						rs.getString("soDienThoai"), DAO_DiaChi.timDiaChiTheoMa(rs.getString("maDC")),
						rs.getBoolean("trangThai"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return kh;
	}
	//danh sach cac khach hang có cùng sdt (do viec xoa Kh)
	public List<KhachHang> timDSKHTheoSDT(String sdt) {

		String sql = "select * from KhachHang where soDienThoai = ? order by tenKhachHang";
		PreparedStatement statement = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),
						rs.getString("soDienThoai"), DAO_DiaChi.timDiaChiTheoMa(rs.getString("maDC")),
						rs.getBoolean("trangThai"));
				if(kh.isTrangThai()) {
					list.add(kh);
					System.out.println(kh);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public KhachHang timKHTheoMa(String ma) {

		String sql = "select * from KhachHang where maKhachHang=? order by tenKhachHang";
		PreparedStatement statement = null;
		KhachHang kh = new KhachHang();

		try {

			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),
						rs.getString("soDienThoai"), DAO_DiaChi.timDiaChiTheoMa(rs.getString("maDC")),
						rs.getBoolean("trangThai"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return kh;
	}
	
	public boolean themKH(KhachHang kh) {
		Connect.getInstance();
		Connection con = Connect.getCon();

		List<KhachHang> list = timDSKHTheoSDT(kh.getSoDienThoai());
		if(list.size() > 0){
			System.out.println("sdt nay có kh ");
			return false;
		}
		PreparedStatement statement = null;
		int n = 0;
		
		try {

			statement = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
			statement.setString(1, kh.getMaKhachHang());
			statement.setString(2, kh.getTenKhachHang());
			statement.setBoolean(3, kh.isGioiTinh());
			statement.setString(4, kh.getSoDienThoai());
			statement.setString(6, kh.getDiaChi().getMaDC());
			statement.setBoolean(5, kh.isTrangThai());
			try {
				n = statement.executeUpdate();
				if (n > 0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}
	public String taoMaNgauNhienKH() {
		String strMaNCC = null;
		
		PreparedStatement s = null;
		String sql = "select top 1 [maKhachHang] from [QLThuoc].[dbo].[KhachHang] order by [maKhachHang] desc";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				strMaNCC = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Khách hàng");
			return "";
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String str = strMaNCC.substring(2, 4);
		strMaNCC = strMaNCC.substring(4);
		long longMaHD = Long.parseLong(strMaNCC);
		if (longMaHD == 999999) {
			if (str.equals("ZZ")) {
				return "error! (out of memory)";
			} else if (str.codePointAt(1) == 90) {
				int temp = str.codePointAt(0) + 1;
				str = (char) temp + "A";
				longMaHD = 0;
			} else {
				int temp = str.codePointAt(0);
				int temp1 = str.codePointAt(1) + 1;
				str = (char) temp + "" + (char) temp1;
				longMaHD = 0;
			}
		} else {
			longMaHD += 1;
		}
		strMaNCC = longMaHD == 0? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
		strMaNCC = "KH" + str + strMaNCC.substring(1);
		return strMaNCC;
	}
	
	public boolean suaKH(KhachHang kh, String tinhTP, String quanHuyen, String phuongXa) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		int n = 0;

		try {

			statement = con.prepareStatement(
					"update KhachHang set tenKhachHang=?, gioiTinh=?, soDienThoai=?, trangThai=? ,maDC=? where maKhachHang=?");
			statement.setString(6, kh.getMaKhachHang());
			statement.setString(1, kh.getTenKhachHang());
			statement.setBoolean(2, kh.isGioiTinh());
			statement.setString(3, kh.getSoDienThoai());
			statement.setBoolean(4, kh.isTrangThai());
			statement.setString(5, DAO_DiaChi.getMaDCTheoTinhHuyenXa(tinhTP, quanHuyen, phuongXa));

			try {
				n = statement.executeUpdate();
				if (n > 0)
					return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean xoaKH(KhachHang kh) {
		String sql = "update KhachHang set trangThai=0 where maKhachHang=?";
		PreparedStatement statement = null;
		int n = 0;

		try {

			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, kh.getMaKhachHang());
			n = statement.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}
	
	public KhachHang get1KhachHang(String sdt) {
		PreparedStatement s = null;
		KhachHang KH = null;
		String sql = "select * from "
				+ "(SELECT dbo.KhachHang.maKhachHang, dbo.KhachHang.tenKhachHang, dbo.KhachHang.gioiTinh, dbo.KhachHang.soDienThoai, dbo.KhachHang.trangThai, dbo.DiaChi.phuongXa, dbo.DiaChi.quanHuyen, dbo.DiaChi.tinhTP "
				+ "FROM dbo.DiaChi INNER JOIN "
				+ "dbo.KhachHang ON dbo.DiaChi.maDC = dbo.KhachHang.maDC) as KH "
				+ "where soDienThoai = " + sdt + " and KH.trangThai = 1";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String soDienThoai = rs.getString(4);
				String phuongXa = rs.getString(6);
				String quanHuyen = rs.getString(7);
				String tinhTP = rs.getString(8);
				boolean trangThai = true;
				DiaChi dc = new DiaChi(tinhTP, quanHuyen, phuongXa);
				
				KH = new KhachHang(ma, ten, gioiTinh, soDienThoai, dc, trangThai);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return KH;
	}
	
	public List<KhachHang> getKhachHangByAll(String ten, int gioiTinh) {
		KhachHang kh = new KhachHang();
		List<KhachHang> list = new ArrayList<KhachHang>();
		String sql = "select n.maKhachHang, n.tenKhachHang, n.gioiTinh, n.soDienThoai, d.tinhTP, d.quanHuyen, d.phuongXa FROM dbo.KhachHang AS n INNER JOIN dbo.DiaChi AS d ON n.maDC = d.maDC where tenKhachHang like N'%"+ten+"%' and trangThai=1 ";
		if (gioiTinh == 1)
			sql += " and gioiTinh = 1";
		else if (gioiTinh == 2)
			sql += " and gioiTinh = 0";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		try {
			s = con.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				kh = new KhachHang(r.getString("maKhachHang"), r.getString("tenKhachHang"), r.getBoolean("gioiTinh"), r.getString("soDienThoai"), new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")), true);
				list.add(kh);
			}
		} catch (SQLException e) {
			System.out.println("Loi o ham getMaNVTheoSDT Dao_NhanVien");
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
