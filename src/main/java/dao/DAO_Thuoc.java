package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

import connect.Connect;
import entity.CT_HoaDonBan;
import entity.CongDung;
import entity.DiaChi;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class DAO_Thuoc {

	public Vector<String> getTenThuoc(String key) {
		PreparedStatement s = null;
		Vector<String> v = new Vector<String>();
		String sql = "select tenThuoc from Thuoc where tenThuoc like N'%" + key + "%'";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			// v.addElement("");
			while (r.next()) {
				String a = r.getString("tenThuoc");
				a.replaceAll("\\s{2,}", " ");
				v.addElement(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public List<Thuoc> getSearchSugestThuoc(String key) {
		PreparedStatement s = null;
		List<Thuoc> v = new ArrayList<>();
		String sql = "select * from Thuoc where tenThuoc like N'%" + key + "%'";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			// v.addElement("");
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String dvt = rs.getNString(4);
				String hoatChat = rs.getString(5);
				String quyCachDongGoi = rs.getString(6);
				String dangBaoChe = rs.getString(7);
				String hamLuong = rs.getString(8);
				String ctySanXuat = rs.getString(9);
				String nuocSanXuat = rs.getString(10);
				boolean trangThai = rs.getBoolean(11);
				float vat = rs.getFloat(12);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, hoatChat, quyCachDongGoi, dangBaoChe, hamLuong, ctySanXuat,
						nuocSanXuat, trangThai, vat);
				v.add(T);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return v;
	}

	public Thuoc getThuocTheoMa(String ma) {
		Thuoc t = new Thuoc();
		String sql = "select * from Thuoc where maThuoc = '" + ma + "'";
		PreparedStatement s = null;
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			rs.next();

			String ten = rs.getString(2);
			double gia = rs.getDouble(3);
			String dvt = rs.getNString(4);
			String hoatChat = rs.getString(5);
			String quyCachDongGoi = rs.getString(6);
			String dangBaoChe = rs.getString(7);
			String hamLuong = rs.getString(8);
			String ctySanXuat = rs.getString(9);
			String nuocSanXuat = rs.getString(10);
			boolean trangThai = rs.getBoolean(11);
			float vat = rs.getFloat(12);
			String soDK = rs.getString(13);
			String maCongDung = rs.getString(14);
			int soLuong = rs.getInt(15);

			DAO_CongDung dao = new DAO_CongDung();
			t = new Thuoc(ma, ten, gia, dvt, hoatChat, quyCachDongGoi, dangBaoChe, hamLuong, ctySanXuat, nuocSanXuat,
					trangThai, vat, soDK, dao.getCongDungByMaCongDung(maCongDung), soLuong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public List<Thuoc> timThuocTheoMa_Ten_HopChat(String ma, String ten, String hopchat) {

		String sql = "select * from Thuoc where maThuoc like '%" + ma + "%' or tenThuoc like '%" + ten
				+ "%' or hoatChat like '%" + hopchat + "%'";
		PreparedStatement statement = null;
		List<Thuoc> list = new ArrayList<Thuoc>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Thuoc thuoc = new Thuoc(rs.getString("maThuoc"), rs.getString("tenThuoc"), rs.getDouble("giaBan"),
						rs.getString("donViTinh"), rs.getString("hoatChat"), rs.getString("quyCachDongGoi"),
						rs.getString("dangBaoChe"), rs.getString("hamLuong"), rs.getString("cTySanXuat"),
						rs.getString("nuocSanXuat"), rs.getBoolean("trangThaiKD"), rs.getFloat("thueVAT"));

				list.add(thuoc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public boolean suaThuoc(Thuoc t) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		int n = 0;

		try {

			statement = con.prepareStatement(
					"update Thuoc set  tenThuoc=?, giaBan=?, donViTinh=?, thanhPhan=?, quyCachDongGoi=?, "
							+ "dangBaoChe=?, hamLuong=?, cTySanXuat=?, \r\n"
							+ "nuocSanXuat=?, trangThaiKD=?, thueVAT=? , maCongDung = ?\r\n" + "where maThuoc=?\r\n"
							+ "");

			statement.setString(1, t.getTenThuoc());
			statement.setDouble(2, t.getGiaBan());
			statement.setString(3, t.getDonViTinh());
			statement.setString(4, t.getThanhPhan());
			statement.setString(5, t.getQuyCachDongGoi());
			statement.setString(6, t.getDangBaoChe());
			statement.setString(7, t.getHamLuong());
			statement.setString(8, t.getcTySanXuat());
			statement.setString(9, t.getNuocSanXuat());
			statement.setBoolean(10, t.isTrangThaiKD());
			statement.setDouble(11, t.getThueVAT());
			statement.setString(12, t.getCongDung().getMaCongDung());
			statement.setString(13, t.getMaThuoc());

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

	public boolean setNgungKinhDoanh(Thuoc t) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		int n = 0;
		boolean tt = t.isTrangThaiKD();
		try {

			statement = con.prepareStatement("update Thuoc set trangThaiKD = ? where maThuoc=?");
			statement.setBoolean(1, !tt);
			statement.setString(2, t.getMaThuoc());

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

	public Thuoc timThuocTheoMa(String ma) {

		String sql = "select * from Thuoc where maThuoc=? ";
		PreparedStatement statement = null;
		Thuoc thuoc = new Thuoc();

		try {

			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String dvt = rs.getNString(4);
				String hoatChat = rs.getString(5);
				String quyCachDongGoi = rs.getString(6);
				String dangBaoChe = rs.getString(7);
				String hamLuong = rs.getString(8);
				String ctySanXuat = rs.getString(9);
				String nuocSanXuat = rs.getString(10);
				boolean trangThai = rs.getBoolean(11);
				float vat = rs.getFloat(12);
				String soDK = rs.getString(13);
				String maCongDung = rs.getString(14);
				int soluong = rs.getInt(15);

				DAO_CongDung dao_CongDung = new DAO_CongDung();
				thuoc = new Thuoc(ma, ten, gia, dvt, hoatChat, quyCachDongGoi, dangBaoChe, hamLuong, ctySanXuat,
						nuocSanXuat, trangThai, vat, soDK, dao_CongDung.getCongDungByMaCongDung(maCongDung), soluong);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return thuoc;
	}

	public Vector<String> getLoaiThuoc() {
		PreparedStatement s = null;
		Vector<String> v = new Vector<String>();
		String sql = "select [donViTinh] from [dbo].[Thuoc] group by [donViTinh]";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				String a = r.getString("donViTinh");
				v.addElement(a);
			}
		} catch (SQLException e) {
		}
		return v;
	}

	public Map<Thuoc, Integer> timTenSP(String tim) {
		Map<Thuoc, Integer> listThuoc = new LinkedHashMap<>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select top 20 * from [dbo].[Thuoc] where [tenThuoc] like N'%" + tim + "%' order by tenThuoc";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String dvt = rs.getNString(4);
				String hoatChat = rs.getString(5);
				String dangBaoChe = rs.getString(6);
				int tongSoLuong = rs.getInt(7);
				float vat = rs.getFloat(8);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, hoatChat, dangBaoChe, vat);
				listThuoc.put(T, tongSoLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public Map<Thuoc, Integer> timHoatChatSP(String tim) {
		Map<Thuoc, Integer> listThuoc = new LinkedHashMap<>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select top 20 * from [dbo].[CuaHang] where [hoatChat] like N'%" + tim
					+ "%' order by tenThuoc";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				double gia = rs.getDouble(3);
				String dvt = rs.getNString(4);
				String hoatChat = rs.getString(5);
				String dangBaoChe = rs.getString(6);
				int tongSoLuong = rs.getInt(7);
				float vat = rs.getFloat(8);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, hoatChat, dangBaoChe, vat);
				listThuoc.put(T, tongSoLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public Map<Thuoc, Integer> getAllThuoc() {
		Map<Thuoc, Integer> listThuoc = new LinkedHashMap<>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM Thuoc ORDER BY tenThuoc";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				double gia = rs.getDouble("giaBan");
				String dvt = rs.getNString("donViTinh");
				String thanhPhan = rs.getString("thanhPhan");
				String quyCachDongGoi = rs.getString("quyCachDongGoi");
				String dangBaoChe = rs.getString("dangBaoChe");
				String hamLuong = rs.getString("hamLuong");
				String cTySanXuat = rs.getString("cTySanXuat");
				String nuocSanXuat = rs.getString("nuocSanXuat");
				boolean trangThaiKD = rs.getBoolean("trangThaiKD");
				float vat = rs.getFloat("thueVAT");
				String soDK = rs.getString("soDK");
				String maCongDung = rs.getString("maCongDung");
				int soLuong = rs.getInt("soLuongBanDau");
				Date hanSuDung = rs.getDate("hanSuDung");

				DAO_CongDung dao_CD = new DAO_CongDung();
				CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
						nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

				listThuoc.put(T, T.tongSoLuong());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public Map<Thuoc, Integer> getDSBan(int page, String tenThuoc, String thanhPhanThuoc, String nhomCongDung,
			String dangBaoCheThuoc, String dvtThuoc, String CongDung) {
		int start = (page - 1) * 20 + 1;
		int end = page * 20;

		Map<Thuoc, Integer> listThuoc = new LinkedHashMap<>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER ( ORDER BY [tenThuoc]) AS STT,Thuoc.* FROM [QLThuoc].[dbo].[Thuoc] join CongDung c on c.maCongDung = Thuoc.maCongDung"
					+ " where tenThuoc like N'%" + tenThuoc + "%'\r\n" + "and thanhPhan like N'%" + thanhPhanThuoc
					+ "%' ";
			Statement statement;

			if (!nhomCongDung.equals("Tất cả"))
				sql += "and c.nhomCongDung = N'" + nhomCongDung + "' ";
			if (!dangBaoCheThuoc.equals("Tất cả"))
				sql += "and dangBaoChe = N'" + dangBaoCheThuoc + "' ";
			if (!dvtThuoc.equals("Tất cả"))
				sql += "and donViTinh = N'" + dvtThuoc + "' ";
			if (!CongDung.equals("Tất cả"))
				sql += "and c.congDung = N'" + CongDung + "' ";
			sql += "and DATEDIFF(day, GETDATE(), Thuoc.hanSuDung )> 90 )AS PhanTrang WHERE PhanTrang.STT BETWEEN "
					+ start + " AND " + end;

//			System.out.println("------code tim thuoc" + sql);
			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				double gia = rs.getDouble("giaBan");
				String dvt = rs.getNString("donViTinh");
				String thanhPhan = rs.getString("thanhPhan");
				String quyCachDongGoi = rs.getString("quyCachDongGoi");
				String dangBaoChe = rs.getString("dangBaoChe");
				String hamLuong = rs.getString("hamLuong");
				String cTySanXuat = rs.getString("cTySanXuat");
				String nuocSanXuat = rs.getString("nuocSanXuat");
				boolean trangThaiKD = rs.getBoolean("trangThaiKD");
				float vat = rs.getFloat("thueVAT");
				String soDK = rs.getString("soDK");
				String maCongDung = rs.getString("maCongDung");
				int soLuong = rs.getInt("soLuongBanDau");
				Date hanSuDung = rs.getDate("hanSuDung");

				DAO_CongDung dao_CD = new DAO_CongDung();
				CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
						nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);
				listThuoc.put(T, T.tongSoLuong());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public int getCountThuocTim(String tenThuoc, String thanhPhanThuoc, String nhomCongDung, String dangBaoCheThuoc,
			String dvtThuoc, String CongDung) {
		int soLuong = 1; // test thu bang 1

		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER ( ORDER BY [tenThuoc]) AS STT,Thuoc.* FROM [QLThuoc].[dbo].[Thuoc] join CongDung c on c.maCongDung = Thuoc.maCongDung"
					+ " where tenThuoc like N'%" + tenThuoc + "%'\r\n" + "and thanhPhan like N'%" + thanhPhanThuoc
					+ "%' ";
			Statement statement;

			if (!nhomCongDung.equals("Tất cả"))
				sql += "and c.nhomCongDung = N'" + nhomCongDung + "' ";
			if (!dangBaoCheThuoc.equals("Tất cả"))
				sql += "and dangBaoChe = N'" + dangBaoCheThuoc + "' ";
			if (!dvtThuoc.equals("Tất cả"))
				sql += "and donViTinh = N'" + dvtThuoc + "' ";
			if (!CongDung.equals("Tất cả"))
				sql += "and c.congDung = N'" + CongDung + "' ";
			sql += "and DATEDIFF(day, GETDATE(), Thuoc.hanSuDung )> 90 )AS PhanTrang";

//			System.out.println("==code so thuoc" + sql);
			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				soLuong = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuong;
	}

	public int getCountThuocTimCoNuocsx(String tenThuoc, String thanhPhanThuoc, String nhomCongDung,
			String dangBaoCheThuoc, String dvtThuoc, String CongDung, String nuoc) {
		int soLuong = 1; // test thu bang 1

		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER ( ORDER BY [tenThuoc]) AS STT,Thuoc.* FROM [QLThuoc].[dbo].[Thuoc] join CongDung c on c.maCongDung = Thuoc.maCongDung"
					+ " where tenThuoc like N'%" + tenThuoc + "%'\r\n" + "and thanhPhan like N'%" + thanhPhanThuoc
					+ "%' ";
			Statement statement;

			if (!nhomCongDung.equals("Tất cả"))
				sql += "and c.nhomCongDung = N'" + nhomCongDung + "' ";
			if (!dangBaoCheThuoc.equals("Tất cả"))
				sql += "and dangBaoChe = N'" + dangBaoCheThuoc + "' ";
			if (!dvtThuoc.equals("Tất cả"))
				sql += "and donViTinh = N'" + dvtThuoc + "' ";
			if (!CongDung.equals("Tất cả"))
				sql += "and c.congDung = N'" + CongDung + "' ";
			if (!nuoc.equals("Tất cả"))
				sql += "and c.nuocSanXuat = N'" + nuoc + "' ";
			sql += ")AS PhanTrang";

//			System.out.println("==code so thuoc" + sql);
			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				soLuong = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuong;
	}

	public int getCountThuocTimTrongDatabase(String tenThuoc, String thanhPhanThuoc, String nhomCongDung,
			String dangBaoCheThuoc, String dvtThuoc, String CongDung, String nuoc) {
		int soLuong = 1; // test thu bang 1

		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER ( ORDER BY [tenThuoc]) AS STT,Thuoc.* FROM [QLThuoc].[dbo].[Thuoc] join CongDung c on c.maCongDung = Thuoc.maCongDung"
					+ " where tenThuoc like N'%" + tenThuoc + "%'\r\n" + "and thanhPhan like N'%" + thanhPhanThuoc
					+ "%' ";
			Statement statement;

			if (!nhomCongDung.equals("Tất cả"))
				sql += "and c.nhomCongDung = N'" + nhomCongDung + "' ";
			if (!dangBaoCheThuoc.equals("Tất cả"))
				sql += "and dangBaoChe = N'" + dangBaoCheThuoc + "' ";
			if (!dvtThuoc.equals("Tất cả"))
				sql += "and donViTinh = N'" + dvtThuoc + "' ";
			if (!CongDung.equals("Tất cả"))
				sql += "and c.congDung = N'" + CongDung + "' ";
			if (!nuoc.equals("Tất cả"))
				sql += "and c.nuocSanXuat = N'" + nuoc + "' ";
			sql += ")AS PhanTrang";

//			System.out.println("==code so thuoc" + sql);
			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				soLuong = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuong;
	}

	public int getCountThuocBan() {
		int count = 0;
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select COUNT([maThuoc]) from [dbo].[Thuoc] where DATEDIFF(day, GETDATE(), Thuoc.hanSuDung ) > 90";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			if (rs != null) // moi them
				while (rs.next()) {
					count = rs.getInt(1);
				}
			else
				return -1; // moi them
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getCountAllThuoc() {
		int count = 0;
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select COUNT([maThuoc]) from [dbo].[Thuoc] ";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			if (rs != null) // moi them
				while (rs.next()) {
					count = rs.getInt(1);
				}
			else
				return -1; // moi them
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<String> getDVT() {
		ArrayList<String> listDVT = new ArrayList<String>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select donViTinh from thuoc group by donViTinh order by donViTinh";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String DVT = rs.getString(1);
				listDVT.add(DVT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDVT;
	}

	public ArrayList<String> getDBC() {
		ArrayList<String> listDBC = new ArrayList<String>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select dangBaoChe from thuoc group by dangBaoChe order by dangBaoChe";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String DBC = rs.getString(1);
				listDBC.add(DBC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDBC;
	}

	public ArrayList<String> getNuocSX() {
		ArrayList<String> listNuocSX = new ArrayList<String>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select nuocSanXuat from Thuoc group by nuocSanXuat order by nuocSanXuat";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String NuocSX = rs.getString(1);
				listNuocSX.add(NuocSX);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNuocSX;
	}

	public Map<Thuoc, Integer> timThuocByAllTxt(int page, String tenThuoc, String thanhPhanThuoc, String nhomCongDung,
			String dangBaoCheThuoc, String dvtThuoc, String CongDung, String nuoc) {
		int start = (page - 1) * 20 + 1;
		int end = page * 20;

		Map<Thuoc, Integer> listThuoc = new LinkedHashMap<>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER ( ORDER BY [tenThuoc]) AS STT,Thuoc.* FROM [QLThuoc].[dbo].[Thuoc] join CongDung c on c.maCongDung = Thuoc.maCongDung"
					+ " where tenThuoc like N'%" + tenThuoc + "%'\r\n" + "and thanhPhan like N'%" + thanhPhanThuoc
					+ "%' ";
			Statement statement;

			if (!nhomCongDung.equals("Tất cả"))
				sql += "and c.nhomCongDung = N'" + nhomCongDung + "' ";
			if (!dangBaoCheThuoc.equals("Tất cả"))
				sql += "and dangBaoChe = N'" + dangBaoCheThuoc + "' ";
			if (!dvtThuoc.equals("Tất cả"))
				sql += "and donViTinh = N'" + dvtThuoc + "' ";
			if (!CongDung.equals("Tất cả"))
				sql += "and c.congDung = N'" + CongDung + "' ";
			if (!nuoc.equals("Tất cả"))
				sql += "and c.nuocSanXuat = N'" + nuoc + "' ";
			sql += ")AS PhanTrang WHERE PhanTrang.STT BETWEEN " + start + " AND " + end;

//			System.out.println("------code tim thuoc" + sql);
			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				double gia = rs.getDouble("giaBan");
				String dvt = rs.getNString("donViTinh");
				String thanhPhan = rs.getString("thanhPhan");
				String quyCachDongGoi = rs.getString("quyCachDongGoi");
				String dangBaoChe = rs.getString("dangBaoChe");
				String hamLuong = rs.getString("hamLuong");
				String cTySanXuat = rs.getString("cTySanXuat");
				String nuocSanXuat = rs.getString("nuocSanXuat");
				boolean trangThaiKD = rs.getBoolean("trangThaiKD");
				float vat = rs.getFloat("thueVAT");
				String soDK = rs.getString("soDK");
				String maCongDung = rs.getString("maCongDung");
				int soLuong = rs.getInt("soLuongBanDau");
				Date hanSuDung = rs.getDate("hanSuDung");

				DAO_CongDung dao_CD = new DAO_CongDung();
				CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
						nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

				listThuoc.put(T, T.tongSoLuong());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public String getTop1DangBC(String hint) {
		String DangBC = "";
		String sql = "select top 1 dangBaoChe from getDangBaoChe where dangBaoChe like N'" + hint
				+ "%' order by dangBaoChe";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
//			statement.setString(1, hint);
			ResultSet rs = statement.executeQuery();
			rs.next();
			DangBC = rs.getString(1);
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
		return DangBC;
	}

	// ----------------------------
	public String taoMaNgauNhienHDN() {
		String strMaHD = null;

		PreparedStatement s = null;
		String sql = "select top 1 mathuoc from Thuoc order by maThuoc desc";
		try {
			s = Connect.getCon().prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				strMaHD = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Thuốc");
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
		strMaHD = "DP" + str + strMaHD.substring(1);
		return strMaHD;
	}

	@SuppressWarnings("static-access")
	public KhachHang layThongtinKhachhang(String maHd) {
		PreparedStatement s = null;
		String sql = "select tenKhachHang, kh.maKhachHang, tinhTP, gioiTinh from KhachHang kh join HoaDonBan hd on kh.maKhachHang = hd.maKhachHang join DiaChi dc on dc.maDC = kh.maDC where maHoaDonBan = '"
				+ maHd + "'";
		KhachHang kh = new KhachHang();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			r.next();
			String tenKh = r.getString("tenKhachHang");
			String diaChi = r.getString("tinhTP");
			boolean gioitinh = r.getBoolean("gioiTinh");
			kh = new KhachHang(tenKh, gioitinh, new DiaChi(diaChi, "", ""));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	@SuppressWarnings("static-access")
	public NhanVien layThongtinNhanvien(String maHd) {
		PreparedStatement s = null;
		String sql = "select tenNhanVien, nv.maNhanVien from NhanVien nv join HoaDonBan hd on nv.maNhanVien = hd.maNhanVien where maHoaDonBan = '"
				+ maHd + "'";
		NhanVien nv = new NhanVien();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			r.next();
			nv = new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}

	@SuppressWarnings("static-access")
	public List<HoaDonBan> getAllHdban() {
		PreparedStatement s = null;
		String sql = "select maHoaDonBan, ngayLapHDBan, kh.maKhachHang, tenKhachHang,tenNhanVien, nv.maNhanVien from HoaDonBan hdb join NhanVien nv on nv.maNhanVien = hdb.maNhanVien join KhachHang kh on hdb.maKhachHang = kh.maKhachHang order by maHoaDonBan desc";
		List<HoaDonBan> list = new ArrayList<HoaDonBan>();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				list.add(new HoaDonBan(r.getString("maHoaDonBan"), r.getDate("ngayLapHDBan"),
						new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien")),
						new KhachHang(r.getString("maKhachHang"), r.getString("tenKhachHang"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("static-access")
	public String tongGiaHoaDon(String maHdban) {
		String gia = "";
		PreparedStatement s = null;
		String sql = "select t.giaBan*soLuong*(ct.thueVAT+1) from CT_HoaDonBan ct join HoaDonBan hd on ct.maHoaDonBan = hd.maHoaDonBan join Thuoc t on ct.maThuoc = t.maThuoc where hd.maHoaDonBan = '"
				+ maHdban + "'";
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			r.next();
			gia = String.valueOf(r.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gia;
	}

	@SuppressWarnings("static-access")
	public HoaDonBan getHdban(String maHd) {
		PreparedStatement s = null;
		String sql = "select maHoaDonBan, ngayLapHDBan, kh.maKhachHang, tenKhachHang,tenNhanVien, nv.maNhanVien from HoaDonBan hdb join NhanVien nv on nv.maNhanVien = hdb.maNhanVien join KhachHang kh on hdb.maKhachHang = kh.maKhachHang join DiaChi dc on dc.maDC = kh.maDC where maHoaDonBan = '"
				+ maHd + "'";
		HoaDonBan hd = new HoaDonBan();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			r.next();
			hd = new HoaDonBan(r.getString("maHoaDonBan"), r.getDate("ngayLapHDBan"),
					new NhanVien(r.getString("maNhanVien")), new KhachHang(r.getString("maKhachHang")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}

	@SuppressWarnings("static-access")
	public List<CT_HoaDonBan> getCtHdBan(String maHd) {
		PreparedStatement s = null;
		String sql = "select t.maThuoc, tenThuoc, thanhPhan, t.giaBan, t.thueVAT, ct.soLuong, ct.giaBan, maHoaDonBan from CT_HoaDonBan ct join Thuoc t on t.maThuoc = ct.maThuoc where maHoaDonBan = '"
				+ maHd + "'";
		List<CT_HoaDonBan> list = new ArrayList<CT_HoaDonBan>();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				list.add(new CT_HoaDonBan(r.getInt("soLuong"), r.getDouble(7),
						new Thuoc(r.getString("maThuoc"), r.getString("tenThuoc"), r.getDouble(4),
								r.getString("thanhPhan"), r.getFloat("thueVAT")),
						new HoaDonBan(r.getString("maHoaDonBan")), r.getFloat("thueVAT")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("static-access")
	public List<HoaDonBan> getAllHdbanByHint(String maHd, String sdtKH, String tenKh, String sdtNV) {
		PreparedStatement s = null;
		String sql = "select maHoaDonBan, ngayLapHDBan, kh.maKhachHang, tenKhachHang,tenNhanVien, nv.maNhanVien from HoaDonBan hdb join NhanVien nv on nv.maNhanVien = hdb.maNhanVien join KhachHang kh on hdb.maKhachHang = kh.maKhachHang where hdb.maHoaDonBan like '%"
				+ maHd + "%' and kh.soDienThoai like '%" + sdtKH + "%' and tenKhachHang like N'%" + tenKh
				+ "%' and nv.soDienThoaiNV like '%" + sdtNV + "%' order by maHoaDonBan desc";
		List<HoaDonBan> list = new ArrayList<HoaDonBan>();
		try {
			s = Connect.getInstance().getCon().prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				list.add(new HoaDonBan(r.getString("maHoaDonBan"), r.getDate("ngayLapHDBan"),
						new NhanVien(r.getString("tenNhanVien"), r.getString("maNhanVien")),
						new KhachHang(r.getString("maKhachHang"), r.getString("tenKhachHang"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Thuoc> getThuocHetHan() {
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM Thuoc WHERE DATEDIFF(day, GETDATE(), hanSuDung ) BETWEEN 1 AND 90  ORDER BY hanSuDung";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				double gia = rs.getDouble("giaBan");
				String dvt = rs.getNString("donViTinh");
				String thanhPhan = rs.getString("thanhPhan");
				String quyCachDongGoi = rs.getString("quyCachDongGoi");
				String dangBaoChe = rs.getString("dangBaoChe");
				String hamLuong = rs.getString("hamLuong");
				String cTySanXuat = rs.getString("cTySanXuat");
				String nuocSanXuat = rs.getString("nuocSanXuat");
				boolean trangThaiKD = rs.getBoolean("trangThaiKD");
				float vat = rs.getFloat("thueVAT");
				String soDK = rs.getString("soDK");
				String maCongDung = rs.getString("maCongDung");
				int soLuong = rs.getInt("soLuongBanDau");
				Date hanSuDung = rs.getDate("hanSuDung");

				DAO_CongDung dao_CD = new DAO_CongDung();
				CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

				Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
						nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

				list.add(T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Thuoc> getThuocHetSL() {
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		try {
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "SELECT * FROM\r\n" + 
					"					(SELECT Thuoc.*, ISNULL(hd.soLuong,0) AS SL FROM Thuoc FULL OUTER JOIN\r\n" + 
					"					(SELECT sum(soLuong) as soLuong, maThuoc FROM HoaDonBan JOIN CT_HoaDonBan ON CT_HoaDonBan.maHoaDonBan = HoaDonBan.maHoaDonBan group by maThuoc) AS hd\r\n" + 
					"					ON hd.maThuoc = Thuoc.maThuoc) AS T WHERE T.soLuongBanDau - T.SL < 10 order by T.tenThuoc";
			Statement statement;

			statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				double gia = rs.getDouble("giaBan");
				String dvt = rs.getNString("donViTinh");
				String thanhPhan = rs.getString("thanhPhan");
				String quyCachDongGoi = rs.getString("quyCachDongGoi");
				String dangBaoChe = rs.getString("dangBaoChe");
				String hamLuong = rs.getString("hamLuong");
				String cTySanXuat = rs.getString("cTySanXuat");
				String nuocSanXuat = rs.getString("nuocSanXuat");
				boolean trangThaiKD = rs.getBoolean("trangThaiKD");
				float vat = rs.getFloat("thueVAT");
				String soDK = rs.getString("soDK");
				String maCongDung = rs.getString("maCongDung");
				int soLuong = rs.getInt("soLuongBanDau");
				Date hanSuDung = rs.getDate("hanSuDung");

				DAO_CongDung dao_CD = new DAO_CongDung();
				CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);
				Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
						nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);
				list.add(T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
