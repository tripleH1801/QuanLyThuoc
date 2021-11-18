package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;
import entity.CT_HoaDonBan;

import entity.Thuoc;

public class DAO_CT_HoaDonBan {
	public boolean taoCTHDBAN(CT_HoaDonBan ct_HD) {
		PreparedStatement s = null;
		int n = 0;
		String sql = "insert into CT_HoaDonBan values(" + ct_HD.getSoLuong() + ", '" + ct_HD.getThuoc().getMaThuoc()
				+ "', '" + ct_HD.getHoaDonBan().getMaHoaDonBan() + "', " + ct_HD.getGiaBan() + ", " + ct_HD.getVat()
				+ ")";
		try {
			Connection con = Connect.getCon();
			s = con.prepareStatement(sql);
			n = s.executeUpdate();
		} catch (Exception e) {
			n = 0;
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return n > 0;
	}

	public int getSoLuongThuocBan(String maThuoc) {
		PreparedStatement s = null;
		String sql = "select soLuong from CT_HoaDonBan where maThuoc = '" + maThuoc + "'";
		int sl = 0;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			// v.addElement("");
			while (r.next()) {
				sl += r.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sl;
	}

	public ArrayList<CT_HoaDonBan> getDSCT_HdByMaHD(String maHD) {
		ArrayList<CT_HoaDonBan> list = new ArrayList<CT_HoaDonBan>();
		PreparedStatement s = null;
		String sql = "select * from CT_HoaDonBan where maHoaDonBan = '" + maHD + "'";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			// v.addElement("");
			while (r.next()) {
				int sl = r.getInt(1);
				String maThuoc = r.getString(2);
				double gia = r.getDouble(4);
				float vat = r.getFloat(5);

				DAO_Thuoc dao = new DAO_Thuoc();
				Thuoc t = dao.getThuocTheoMa(maThuoc);

				CT_HoaDonBan cthd = new CT_HoaDonBan(t, sl, gia, vat);
				list.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

//	public static void main(String[] args) {
//		try {
//			Connect.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DAO_CT_HoaDonBan dao = new DAO_CT_HoaDonBan();
//		System.out.println(dao.getSoLuongThuocBan("DPAA000001"));
//	}
}
