package entity;

import java.sql.Date;
import dao.DAO_CT_HoaDonBan;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private double giaBan;
	private String donViTinh;
	private String thanhPhan;
	private String quyCachDongGoi;
	private String dangBaoChe;
	private String hamLuong;
	private String cTySanXuat;
	private String nuocSanXuat;
	private boolean trangThaiKD;
	private float thueVAT;
	private String soDK;
	private CongDung congDung;
	private long soLuonBanDau;
	private Date hanSuDung;
	
	
	/**
	 * @return the soLuong
	 */
	public long getSoLuongBanDau() {
		return soLuonBanDau;
	}

	/**
	 * @param soLuongBanDau the soLuong to set
	 */
	public void setSoLuongBanDau(long soLuongBanDau) {
		this.soLuonBanDau = soLuongBanDau;
	}

	/**
	 * @return the maThuoc
	 */
	public String getMaThuoc() {
		return maThuoc;
	}

	/**
	 * @param maThuoc the maThuoc to set
	 */
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	/**
	 * @return the tenThuoc
	 */
	public String getTenThuoc() {
		return tenThuoc;
	}

	/**
	 * @param tenThuoc the ten to set
	 */
	public void setTen(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	/**
	 * @return the giaBan
	 */
	public double getGiaBan() {
		return giaBan;
	}

	/**
	 * @param giaBan the giaBan to set
	 */
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	/**
	 * @return the donViTinh
	 */
	public String getDonViTinh() {
		return donViTinh;
	}

	/**
	 * @param donViTinh the donViTinh to set
	 */
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	/**
	 * @return the hoatChat
	 */
	public String getThanhPhan() {
		return thanhPhan;
	}

	/**
	 * @param hoatChat the hoatChat to set
	 */
	public void setThanhPhan(String hoatChat) {
		this.thanhPhan = hoatChat;
	}

	/**
	 * @return the quyCachDongGoi
	 */
	public String getQuyCachDongGoi() {
		return quyCachDongGoi;
	}

	/**
	 * @param quyCachDongGoi the quyCachDongGoi to set
	 */
	public void setQuyCachDongGoi(String quyCachDongGoi) {
		this.quyCachDongGoi = quyCachDongGoi;
	}

	/**
	 * @return the dangBaoChe
	 */
	public String getDangBaoChe() {
		return dangBaoChe;
	}

	/**
	 * @param dangBaoChe the dangBaoChe to set
	 */
	public void setDangBaoChe(String dangBaoChe) {
		this.dangBaoChe = dangBaoChe;
	}

	/**
	 * @return the hamLuong
	 */
	public String getHamLuong() {
		return hamLuong;
	}

	/**
	 * @param hamLuong the hamLuong to set
	 */
	public void setHamLuong(String hamLuong) {
		this.hamLuong = hamLuong;
	}

	/**
	 * @return the cTySanXuat
	 */
	public String getcTySanXuat() {
		return cTySanXuat;
	}

	/**
	 * @param cTySanXuat the cTySanXuat to set
	 */
	public void setcTySanXuat(String cTySanXuat) {
		this.cTySanXuat = cTySanXuat;
	}

	/**
	 * @return the nuocSanXuat
	 */
	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	/**
	 * @param nuocSanXuat the nuocSanXuat to set
	 */
	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	/**
	 * @return the trangThaiKD
	 */
	public boolean isTrangThaiKD() {
		return trangThaiKD;
	}

	/**
	 * @param trangThaiKD the trangThaiKD to set
	 */
	public void setTrangThaiKD(boolean trangThaiKD) {
		this.trangThaiKD = trangThaiKD;
	}

	/**
	 * @return the thueVAT
	 */
	public float getThueVAT() {
		return thueVAT;
	}

	/**
	 * @param vat the thueVAT to set
	 */
	public void setThueVAT(float vat) {
		this.thueVAT = vat;
	}

	/**
	 * @return the soDK
	 */
	public String getSoDK() {
		return soDK;
	}

	/**
	 * @param soDK the soDK to set
	 */
	public void setSoDK(String soDK) {
		this.soDK = soDK;
	}

	/**
	 * @return the congDung
	 */
	public CongDung getCongDung() {
		return congDung;
	}

	/**
	 * @param congDung the congDung to set
	 */
	public void setCongDung(CongDung congDung) {
		this.congDung = congDung;
	}
	
	
	
	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	/**
	 * 
	 */
	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param hoatChat
	 * @param vat
	 */
	public Thuoc(String ma, String ten, double giaBan, String hoatChat, float vat) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.thanhPhan = hoatChat;
		this.thueVAT = vat;
	}

	/**
	 * @param ma
	 * @param ten
	 * @param hoatChat
	 */
	public Thuoc(String ma, String ten, String hoatChat) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.thanhPhan = hoatChat;
	}
	
	

	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param donViTinh
	 * @param hoatChat
	 * @param quyCachDongGoi
	 * @param dangBaoChe
	 * @param hamLuong
	 * @param cTySanXuat
	 * @param nuocSanXuat
	 * @param trangThaiKD
	 * @param vat
	 * @param soLuong
	 */
	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float vat,
			long soLuong) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKD = trangThaiKD;
		this.thueVAT = vat;
		this.soLuonBanDau = soLuong;
	}

	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param donViTinh
	 * @param hoatChat
	 * @param quyCachDongGoi
	 * @param dangBaoChe
	 * @param hamLuong
	 * @param cTySanXuat
	 * @param nuocSanXuat
	 * @param trangThaiKD
	 * @param phanLoai
	 * @param vat
	 */
	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float vat) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKD = trangThaiKD;
		this.thueVAT = vat;
	}
	
	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param donViTinh
	 * @param hoatChat
	 * @param quyCachDongGoi
	 * @param dangBaoChe
	 * @param hamLuong
	 * @param cTySanXuat
	 * @param nuocSanXuat
	 * @param trangThaiKD
	 * @param vat
	 * @param soDK
	 * @param congDung
	 * @param soLuong
	 */
	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float vat,
			String soDK, CongDung congDung, long soLuong) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKD = trangThaiKD;
		this.thueVAT = vat;
		this.soDK = soDK;
		this.congDung = congDung;
		this.soLuonBanDau = soLuong;
	}

	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param donViTinh
	 * @param hoatChat
	 * @param quyCachDongGoi
	 * @param dangBaoChe
	 * @param hamLuong
	 * @param cTySanXuat
	 * @param nuocSanXuat
	 * @param trangThaiKD
	 * @param vat
	 * @param soDK
	 * @param congDung
	 */
	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float vat,
			String soDK, CongDung congDung) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKD = trangThaiKD;
		this.thueVAT = vat;
		this.soDK = soDK;
		this.congDung = congDung;
	}

	/**
	 * @param ma
	 * @param giaBan
	 * @param hoatChat
	 * @param quyCachDongGoi
	 * @param dangBaoChe
	 * @param hamLuong
	 * @param cTySanXuat
	 * @param nuocSanXuat
	 * @param phanLoai
	 */
	public Thuoc(String ma, double giaBan, String hoatChat, String quyCachDongGoi, String dangBaoChe, String hamLuong,
			String cTySanXuat, String nuocSanXuat) {
		super();
		this.maThuoc = ma;
		this.giaBan = giaBan;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
	}

	/**
	 * @param ma
	 * @param ten
	 * @param giaBan
	 * @param donViTinh
	 * @param hoatChat
	 * @param dangBaoChe
	 * @param vat
	 */
	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String dangBaoChe,
			float vat) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.dangBaoChe = dangBaoChe;
		this.thueVAT = vat;
	}
	
	/**
	 * @param ma
	 */
	public Thuoc(String ma) {
		super();
		this.maThuoc = ma;
	}
	
	

	public Thuoc(String ma, String ten, double giaBan, String donViTinh, String hoatChat, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float vat,
			String soDK, CongDung congDung, long soLuong, Date hanSuDung) {
		super();
		this.maThuoc = ma;
		this.tenThuoc = ten;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = hoatChat;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.cTySanXuat = cTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKD = trangThaiKD;
		this.thueVAT = vat;
		this.soDK = soDK;
		this.congDung = congDung;
		this.soLuonBanDau = soLuong;
		this.hanSuDung = hanSuDung;
	}

	@Override
	public String toString() {
		return "Thuoc [ma=" + maThuoc + ", ten=" + tenThuoc + ", giaBan=" + giaBan + ", donViTinh=" + donViTinh + ", hoatChat="
				+ thanhPhan + ", quyCachDongGoi=" + quyCachDongGoi + ", dangBaoChe=" + dangBaoChe + ", hamLuong="
				+ hamLuong + ", cTySanXuat=" + cTySanXuat + ", nuocSanXuat=" + nuocSanXuat + ", trangThaiKD="
				+ trangThaiKD + ", vat=" + thueVAT + ", soDK=" + soDK + ", congDung=" + congDung + ", soLuong=" + soLuonBanDau
				+ ", hanSuDung=" + hanSuDung + "]";
	}
	
	public int tongSoLuong() {
		DAO_CT_HoaDonBan dao = new DAO_CT_HoaDonBan();
		return (int) (this.soLuonBanDau - dao.getSoLuongThuocBan(this.maThuoc));
	}
}