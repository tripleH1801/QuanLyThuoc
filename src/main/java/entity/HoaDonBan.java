package entity;

import java.sql.Date;
import java.util.ArrayList;

import dao.DAO_CT_HoaDonBan;

public class HoaDonBan {
	private String maHoaDonBan;
	private Date ngayLapHDBan;
	private NhanVien nv;
	private KhachHang kh;
	/**
	 * @return the maHoaDonBan
	 */
	public String getMaHoaDonBan() {
		return maHoaDonBan;
	}
	/**
	 * @param maHoaDonBan the maHoaDonBan to set
	 */
	public void setMaHoaDonBan(String maHoaDonBan) {
		this.maHoaDonBan = maHoaDonBan;
	}
	/**
	 * @return the ngayLapHDBan
	 */
	public Date getNgayLapHDBan() {
		return ngayLapHDBan;
	}
	/**
	 * @param ngayLapHDBan the ngayLapHDBan to set
	 */
	public void setNgayLapHDBan(Date ngayLapHDBan) {
		this.ngayLapHDBan = ngayLapHDBan;
	}
	/**
	 * @return the nv
	 */
	public NhanVien getNv() {
		return nv;
	}
	/**
	 * @param nv the nv to set
	 */
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	/**
	 * @return the kh
	 */
	public KhachHang getKh() {
		return kh;
	}
	/**
	 * @param kh the kh to set
	 */
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	/**
	 * @param maHoaDonBan
	 * @param ngayLapHDBan
	 * @param nv
	 * @param kh
	 */
	public HoaDonBan(String maHoaDonBan, Date ngayLapHDBan, NhanVien nv, KhachHang kh) {
		super();
		this.maHoaDonBan = maHoaDonBan;
		this.ngayLapHDBan = ngayLapHDBan;
		this.nv = nv;
		this.kh = kh;
	}
	
	/**
	 * @param maHoaDonBan
	 */
	public HoaDonBan(String maHoaDonBan) {
		super();
		this.maHoaDonBan = maHoaDonBan;
	}
	/**
	 * 
	 */
	public HoaDonBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HoaDonBan [maHoaDonBan=" + maHoaDonBan + ", ngayLapHDBan=" + ngayLapHDBan + ", maNhanVien=" + nv.getMaNV() + ", maKhachHang=" + kh.getMaKhachHang()
				+ "]";
	}
	public double tongTien() {
		DAO_CT_HoaDonBan dao = new DAO_CT_HoaDonBan();
		ArrayList<CT_HoaDonBan> list = dao.getDSCT_HdByMaHD(this.maHoaDonBan);
		double tt = 0;
		for (CT_HoaDonBan t : list) {
			tt += t.thanhTien();
		}
		return tt;
	}
	
}
