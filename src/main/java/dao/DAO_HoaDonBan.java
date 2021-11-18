package dao;

import javax.swing.JOptionPane;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connect.Connect;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDonBan {
	public HoaDonBan getHoaDonMoiNhat() {
		HoaDonBan HD = null;
		PreparedStatement s = null;
		String sql = "SELECT TOP 1 * FROM "
				+ "(SELECT dbo.KhachHang.maKhachHang, dbo.NhanVien.maNhanVien, dbo.HoaDonBan.maHoaDonBan, dbo.HoaDonBan.ngayLapHDBan "
				+ "FROM     dbo.HoaDonBan INNER JOIN "
				+ "dbo.KhachHang ON dbo.HoaDonBan.maKhachHang = dbo.KhachHang.maKhachHang INNER JOIN "
				+ "dbo.NhanVien ON dbo.HoaDonBan.maNhanVien = dbo.NhanVien.maNhanVien "
				+ "WHERE KhachHang.trangThai = 1 AND NhanVien.trangThaiLamViec = 1) AS HD "
				+ "ORDER BY HD.maHoaDonBan DESC";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(1);
				String maNV = rs.getString(2);
				String maHD = rs.getString(3);
				Date ngayLap = rs.getDate(4);

				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);
				HD = new HoaDonBan(maHD, ngayLap, nv, kh);
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
		return HD;
	}

	public String getMaHoaDonMoiNhat() {
		String strMaHD = null;

		PreparedStatement s = null;
		String sql = "select top 1 maHoaDonBan from HoaDonBan order by maHoaDonBan desc";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				strMaHD = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã HĐ");
			return "";
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return strMaHD;
	}

	private String taoMaNgauNhien() {
		String strMaHD = null;

		PreparedStatement s = null;
		String sql = "select top 1 maHoaDonBan from HoaDonBan order by maHoaDonBan desc";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				strMaHD = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã HĐ");
			return "";
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (strMaHD == null) {
			strMaHD = "BTAA000000";
		}

		String str = strMaHD.substring(2, 4);
		strMaHD = strMaHD.substring(4);
		long longMaHD = Long.parseLong(strMaHD);
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
		strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
		strMaHD = "BT" + str + strMaHD.substring(1);
		return strMaHD;
	}

	public boolean taoHoaDonBan(String maNV, String maKH) {

		String strMaHD = taoMaNgauNhien();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String strdate = formatter.format(date);
		int n = 0;
		PreparedStatement s = null;
		String sql = "insert into [dbo].[HoaDonBan] values ('" + strMaHD + "', '" + strdate + "', '" + maNV + "', '"
				+ maKH + "')";
		try {
			s = Connect.getCon().prepareStatement(sql);
			n = s.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	public boolean xoaHoaDonLoi(String ma) {
		String sql = "DELETE FROM [dbo].[HoaDonBan] WHERE [dbo].[HoaDonBan].maHoaDonBan = '" + ma + "'";
		PreparedStatement s = null;
		int n = 0;
		try {
			s = Connect.getCon().prepareStatement(sql);
			n = s.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	
	public ArrayList<HoaDonBan> getHoaDonByNgay(String ngay, String maNV) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan where ngayLapHDBan = '" + ngay + "' and maNhanVien like '%"+maNV+"%'"
		;
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String ma = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(ma);
				list.add(hd);
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
	
	public ArrayList<HoaDonBan> getHoaDonByNgayCuaNhanVien(String maNV, String ngay) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan hd join NhanVien n on n.maNhanVien = hd.maNhanVien where ngayLapHDBan = '"+ngay+"' and n.maNhanVien like '%"+maNV+"%'"
		;
		
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String ma = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(ma);
				list.add(hd);
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

	public ArrayList<HoaDonBan> getHoaDonByThang(String thang, String ma) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan where MONTH(ngayLapHDBan) = " + thang
				+ " and YEAR(ngayLapHDBan) = YEAR(GETDATE()) and maNhanVien like '%"+ma+"%'"
		;
		
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String mahd = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(mahd);
				list.add(hd);
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
	
	public ArrayList<HoaDonBan> getHoaDonByNam(String nam, String maNV) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan where Year(ngayLapHDBan) = " + nam + " and maNhanVien like '%"+maNV+"%'";
		
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String ma = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(ma);
				list.add(hd);
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
	
	public ArrayList<HoaDonBan> thongKeThang(String thang, String ngay, String manv) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan where MONTH(ngayLapHDBan) = " + thang
				+ " and day(ngayLapHDBan) = " + ngay
					+ " and YEAR(ngayLapHDBan) = YEAR(GETDATE()) and maNhanVien like '%"+manv+"%'"
		;
		
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String ma = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(ma);
				list.add(hd);
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
	
	public ArrayList<HoaDonBan> thongKeNam(String nam, String thang, String maNV) {
		ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
		String sql = "select maHoaDonBan from HoaDonBan where YEAR(ngayLapHDBan) = " + nam
				+ " and MONTH(ngayLapHDBan) = " + thang + " and maNhanVien like '%"+maNV+"%'";
		
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				String ma = rs.getString(1);

				HoaDonBan hd = new HoaDonBan(ma);
				list.add(hd);
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
}
