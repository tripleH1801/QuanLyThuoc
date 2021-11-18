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
import entity.NhanVien;

public class DAO_NhanVien {

	// đăng nhập
	private static DAO_DiaChi daoDC = new DAO_DiaChi();

	public NhanVien dangNhap(String tk, String mk) {
		PreparedStatement s = null;
		NhanVien nv = new NhanVien();
		String sql = "select maNhanVien, tenNhanVien, loaiNV from NhanVien where soDienThoaiNV = '" + tk
				+ "' and passLogin = '" + mk + "' and trangThaiLamViec = 1";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			r.next();
			String ma = r.getString("maNhanVien");
			String ten = r.getString("tenNhanVien");
			boolean loai = r.getBoolean("loaiNV");
			nv = new NhanVien(ten, ma, loai);
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
			}
		}
		return nv;
	}

	// thêm nhân viên
	/**
	 * 1 thanh cong -1 trung cmnd -2 trung sdt 0 loi khi them
	 */
	@SuppressWarnings("static-access")
	public int themNV(NhanVien nv) {
		Connection con = Connect.getInstance().getCon();
		String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement s = null;
		if (getMaNVTheoCMND(nv.getCmnd()) != "")
			return -1;
		if (getMaNVTheoSDT(nv.getSdt()) != "")
			return -2;
		int n = 0;
		try {
			s = con.prepareStatement(sql);
			s.setString(1, nv.getMaNV());
			s.setString(2, nv.getTenNV());
			s.setBoolean(3, nv.isGioiTinh());
			s.setString(4, nv.getSdt());
			s.setString(5, nv.getMatKhau());
			s.setBoolean(6, nv.isTrangThaiLam());
			s.setBoolean(7, nv.isLoaiNhanVien());
			s.setString(8, nv.getCmnd());
			s.setString(9, daoDC.getMaDCTheoTinhHuyenXa(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(),
					nv.getDiaChi().getPhuongXa()));
			try {
				n = s.executeUpdate();
				if (n > 0)
					n = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	// lấy tất cả nhân viên
	/**
	 * ------tao view getNV------- create view getNV as select maNhanVien,
	 * tenNhanVien, gioiTinh, soDienThoai, trangThaiLamViec, loaiNV, cmnd, tinhTP,
	 * quanHuyen, phuongXa from NhanVien n join DiaChi d on n.maDC = d.maDC where
	 * loaiNV = 0
	 */
	public List<NhanVien> getAllNVThongKe() {
		String sql = "select * from nhanvien";
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				NhanVien nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<NhanVien> getAllNV() {

		String sql = "select * from getNV";
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				NhanVien nv = new NhanVien(r.getString("tenNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), r.getBoolean("trangThaiLamViec"), r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// thôi việc hoặc cho nhân viên làm lại
	public boolean thoiViecNV(String sdt, int trangThai) {
		int n = 0;
		String sql = "update NhanVien set trangThaiLamViec = " + trangThai + " where soDienThoaiNV = '" + sdt + "'";
		PreparedStatement s = null;
		try {
			s = Connect.getCon().prepareStatement(sql);
			n = s.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	// lấy mã NV theo sdt
	@SuppressWarnings("static-access")
	public String getMaNVTheoSDT(String sdt) {
//		String sql = "select maNhanVien from NhanVien where soDienThoaiNV = '" + sdt + "' and trangThaiLamViec = 1";
		String sql = "select maNhanVien from NhanVien where soDienThoaiNV = ? and trangThaiLamViec = 1";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		String ma = "";
		try {
			s = con.prepareStatement(sql);
			s.setString(1, sdt);
			ResultSet r = s.executeQuery();
			r.next();
			ma = r.getString(1);
		} catch (SQLException e) {
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ma;
	}

	public String getMaNVTheoCMND(String cmnd) {
		String sql = "select maNhanVien from NhanVien where cmnd = ? and trangThaiLamViec = 1";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		String ma = "";
		try {
			s = con.prepareStatement(sql);
			s.setString(1, cmnd);
			ResultSet r = s.executeQuery();
			r.next();
			ma = r.getString("maNhanVien");
		} catch (SQLException e) {
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ma;
	}

	// tìm nhân viên theo sdt
	@SuppressWarnings("static-access")
	public NhanVien getNhanVienBySdt(String sdt) {
		NhanVien nv = new NhanVien();

		String sql = "select maNhanVien, tenNhanVien, gioiTinh, soDienThoaiNV, trangThaiLamViec, loaiNV, cmnd, tinhTP,"
				+ " quanHuyen, phuongXa from NhanVien n join DiaChi d on n.maDC = d.maDC where soDienThoaiNV = '" + sdt
				+ "'";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		try {
			s = con.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			if (r.next())
				nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), "", r.getBoolean("trangThaiLamViec"), r.getBoolean("loaiNV"),
						r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
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

		return nv;
	}

	public List<NhanVien> getNhanVienByAll(String ten, int trangthai, int gioiTinh) {
		NhanVien nv = new NhanVien();
		List<NhanVien> list = new ArrayList<NhanVien>();
		String sql = "select n.maNhanVien, n.tenNhanVien, n.gioiTinh, n.soDienThoaiNV, n.trangThaiLamViec, n.loaiNV, n.cmnd, d.tinhTP, d.quanHuyen, d.phuongXa FROM dbo.NhanVien AS n INNER JOIN dbo.DiaChi AS d ON n.maDC = d.maDC where tenNhanVien like N'%"+ten+"%' ";
		if (trangthai == 1)
			sql += "and trangThaiLamViec = 1";
		else if (trangthai == 2)
			sql += "and trangThaiLamViec = 0";
		if (gioiTinh == 1)
			sql += " and gioiTinh = 1";
		else if (gioiTinh == 2)
			sql += " and gioiTinh = 0";
		System.out.println(sql);
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		try {
			s = con.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), "", r.getBoolean("trangThaiLamViec"), r.getBoolean("loaiNV"),
						r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
				list.add(nv);
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

	public NhanVien getByMa(String ma) {
		NhanVien nv = new NhanVien();

		String sql = "select maNhanVien, tenNhanVien, gioiTinh, soDienThoaiNV, trangThaiLamViec, loaiNV, cmnd, tinhTP,"
				+ " quanHuyen, phuongXa, passLogin from NhanVien n join DiaChi d on n.maDC = d.maDC where maNhanVien = '"
				+ ma + "'";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		try {
			s = con.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			if (r.next())
				nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), r.getString("passLogin"), r.getBoolean("trangThaiLamViec"),
						r.getBoolean("loaiNV"), r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
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

		return nv;
	}

	@SuppressWarnings("static-access")
	public NhanVien getNhanVienByMa(String ma) {
		NhanVien nv = new NhanVien();

		String sql = "select tenNhanVien from NhanVien where maNhanVien = '" + ma + "'";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		try {
			s = con.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			if (r.next())
				nv = new NhanVien(r.getString("tenNhanVien"), ma);
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

		return nv;
	}

	public List<NhanVien> getNVBygioiTinh(int gioiTinh) {

		String sql = "select * from getNV where gioiTinh =" + gioiTinh;
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				NhanVien nv = new NhanVien(r.getString("tenNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), r.getBoolean("trangThaiLamViec"), r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<NhanVien> getNVByTrangThaiAndGioiTinh(int gt1, int gt2, int tt1, int tt2) {

		String sql = "select * from getNV where (gioiTinh = " + gt1 + " or gioiTinh = " + gt2
				+ ") and (trangThaiLamViec = " + tt1 + " or trangThaiLamViec = " + tt2 + ")";
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				NhanVien nv = new NhanVien(r.getString("tenNhanVien"), r.getBoolean("gioiTinh"),
						r.getString("soDienThoaiNV"), r.getBoolean("trangThaiLamViec"), r.getString("cmnd"),
						new DiaChi(r.getString("tinhTP"), r.getString("quanHuyen"), r.getString("phuongXa")));
				list.add(nv);
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
		return list;
	}

	@SuppressWarnings("static-access")
	public boolean updateNV(NhanVien nv) {
		String sql = "update NhanVien set tenNhanVien = N'" + nv.getTenNV() + "', cmnd ='" + nv.getCmnd()
				+ "', gioiTinh = " + (nv.isGioiTinh() == true ? 1 : 0) + ", soDienThoaiNV ='" + nv.getSdt()
				+ "', maDC = (select maDC from DiaChi where tinhTP = N'" + nv.getDiaChi().getTinhTP()
				+ "' and quanHuyen = N'" + nv.getDiaChi().getQuanHuyen() + "' and phuongXa = N'"
				+ nv.getDiaChi().getPhuongXa() + "') where maNhanVien = '" + nv.getMaNV() + "'";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		int n = 0;
		try {
			s = con.prepareStatement(sql);
			n = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public String taoMaNgauNhienHDN() {
		String strMaHD = null;

		PreparedStatement s = null;
		String sql = "select top 1 maNhanVien from NhanVien order by maNhanVien desc";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				strMaHD = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Nhân viên");
			return "";
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		strMaHD = "NV" + str + strMaHD.substring(1);
		return strMaHD;
	}

	// chi quan ly moi su dung ham nay, su dung de tu cap nhat thong tin ca nhan
	// thieu cap nhat cmnd
	public boolean capNhatSdtMk(String sdt, String mk, String maNV) {
//		if(getMaNVTheoSDT(sdt).equals(""))
//			return false;

		int n = 0;
		String sql = "update [dbo].[NhanVien] set soDienThoaiNV = ?, passLogin = ? where maNhanVien = ?";
		PreparedStatement s = null;
		Connection con = Connect.getInstance().getCon();
		n = 0;
		try {
			s = con.prepareStatement(sql);
			s.setString(1, sdt);
			s.setString(2, mk);
			s.setString(3, maNV);
			n = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public List<NhanVien> timNVTheoTenVaSdt(String ten, String sdt) {
		String sql = "select * from NhanVien where soDienThoaiNV like '%"+sdt+"%' and tenNhanVien like N'%"+ten+"%'";
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				NhanVien nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
