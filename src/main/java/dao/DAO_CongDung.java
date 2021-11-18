package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import connect.Connect;
import entity.CongDung;
import entity.DiaChi;
import entity.KhachHang;
import entity.Thuoc;

public class DAO_CongDung {
	public Vector<String> getAllNhomCongDung(String key) {
		Vector<String> v = new Vector<>();
		v.add("Tất cả");
		String sql = "select nhomCongDung from CongDung where nhomCongDung like N'%"+key+"%' group by nhomCongDung";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				v.add(r.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	public Vector<String> getAllNhomCongDung() {
		Vector<String> v = new Vector<>();
		v.add("Tất cả");
		String sql = "select nhomCongDung from CongDung  group by nhomCongDung";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				v.add(r.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public Vector<String> getAllCongDung(String nhomCongDung) {
		Vector<String> v = new Vector<>();
		v.add("Tất cả");
		String sql = "select congDung from CongDung where nhomCongDung = N'"+nhomCongDung+"' group by congDung";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				v.add(r.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Vector<String> getAllCongDung() {
		Vector<String> v = new Vector<>();
		v.add("Tất cả");
		String sql = "select congDung from CongDung group by congDung";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);

			ResultSet r = statement.executeQuery();

			while (r.next()) {
				v.add(r.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	
	public String getMaCongDungTheoLoaiVaCongDung(String nhomCongDung, String congDung) {
		String ma = "";
		String sql = "select maCongDung from CongDung where congDung = N'"+congDung+"' and nhomCongDung = N'"+nhomCongDung+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			ma = r.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ma;
	}
	public CongDung getNhomCongDungByMathuoc(String mathuoc) {
		CongDung cd = new CongDung();
		String sql = "select t.maCongDung, nhomCongDung, congDung from Thuoc t join CongDung c on t.maCongDung = c.maCongDung where maThuoc= ?";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			statement.setString(1, mathuoc);
			ResultSet r = statement.executeQuery();
			r.next();
			cd = new CongDung(r.getString(1), r.getString(2), r.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cd;
	}


	public CongDung getCongDungByMaCongDung(String maCongDung) {
		CongDung c = new CongDung();
		String sql = "select * from CongDung where maCongDung='"+maCongDung+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String ma = rs.getString(1);
				
				String congdung = rs.getString(2);
				
				String nhomcongdung = rs.getString(3);
				c= new CongDung(ma, nhomcongdung, congdung);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}
	
	//---------------------------------------------------------
	
	public String getTop1NhomCongDung(String hint) {
		String nhomCD = "";
		String sql = "select top 1 nhomCongDung from CongDung where nhomCongDung like N'"+hint+"%' group by nhomCongDung order by nhomCongDung ";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			rs.next();
			nhomCD = rs.getString(1);
		} catch (SQLException e) {
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nhomCD;
	}
	
	public String getTop1CongDung(String hint) {
		String congDung = "";
		String sql = "select top 1 congDung from CongDung where congDung like N'"+hint+"%' group by congDung order by congDung ";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
//			statement.setString(1, hint);
			ResultSet rs = statement.executeQuery();
			rs.next();
			congDung = rs.getString(1);
//			System.out.println("Cong dung +" + congDung);
		} catch (SQLException e) {
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return congDung;
	}
	
//	public static void main(String[] args) {
//		try {
//			Connect.getInstance().connect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		DAO_Thuoc dao_Thuoc= new DAO_Thuoc();
//		DAO_CongDung dao_CongDung= new DAO_CongDung();
////		
//		
//		System.out.println(dao_CongDung.getMaCongDungTheoLoaiVaCongDung("Giải độc", "Giải độc"));
//	}
}
