package entity;

public class NhanVien {
	private String tenNV;
	private String maNV;
	private boolean gioiTinh;
	private String sdt;
	private String matKhau;
	private boolean trangThaiLam;
	private boolean loaiNhanVien;
	private String cmnd;
	private DiaChi diaChi;
	/**
	 * @return the tenNV
	 */
	public String getTenNV() {
		return tenNV;
	}
	/**
	 * @param tenNV the tenNV to set
	 */
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	/**
	 * @return the maNV
	 */
	public String getMaNV() {
		return maNV;
	}
	/**
	 * @param maNV the maNV to set
	 */
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	/**
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @return the trangThaiLam
	 */
	public boolean isTrangThaiLam() {
		return trangThaiLam;
	}
	/**
	 * @param trangThaiLam the trangThaiLam to set
	 */
	public void setTrangThaiLam(boolean trangThaiLam) {
		this.trangThaiLam = trangThaiLam;
	}
	/**
	 * @return the loaiNhanVien
	 */
	public boolean isLoaiNhanVien() {
		return loaiNhanVien;
	}
	/**
	 * @param loaiNhanVien the loaiNhanVien to set
	 */
	public void setLoaiNhanVien(boolean loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}
	/**
	 * @return the cmnd
	 */
	public String getCmnd() {
		return cmnd;
	}
	/**
	 * @param cmnd the cmnd to set
	 */
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	/**
	 * @return the diaChi
	 */
	public DiaChi getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @param tenNV
	 * @param maNV
	 * @param gioiTinh
	 * @param sdt
	 * @param matKhau
	 * @param trangThaiLam
	 * @param loaiNhanVien
	 * @param cmnd
	 * @param diaChi
	 */
	public NhanVien(String tenNV, String maNV, boolean gioiTinh, String sdt, String matKhau, boolean trangThaiLam,
			boolean loaiNhanVien, String cmnd, DiaChi diaChi) {
		super();
		this.tenNV = tenNV;
		this.maNV = maNV;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.matKhau = matKhau;
		this.trangThaiLam = trangThaiLam;
		this.loaiNhanVien = loaiNhanVien;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
	}
	/**
	 * @param tenNV
	 * @param maNV
	 * @param loaiNhanVien
	 */
	public NhanVien(String tenNV, String maNV, boolean loaiNhanVien) {
		super();
		this.tenNV = tenNV;
		this.maNV = maNV;
		this.loaiNhanVien = loaiNhanVien;
	}
	/**
	 * @param tenNV
	 * @param gioiTinh
	 * @param sdt
	 * @param trangThaiLam
	 * @param loaiNhanVien
	 * @param cmnd
	 * @param diaChi
	 */
	
	
	/**
	 * 
	 */
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param tenNV
	 * @param maNV
	 */
	public NhanVien(String tenNV, String maNV) {
		super();
		this.tenNV = tenNV;
		this.maNV = maNV;
	}
	/**
	 * @param tenNV
	 * @param gioiTinh
	 * @param sdt
	 * @param trangThaiLam
	 * @param cmnd
	 * @param diaChi
	 */
	public NhanVien(String tenNV, boolean gioiTinh, String sdt, boolean trangThaiLam, String cmnd, DiaChi diaChi) {
		super();
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.trangThaiLam = trangThaiLam;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
	}
	
	
	/**
	 * @param tenNV
	 * @param maNV
	 * @param gioiTinh
	 * @param sdt
	 * @param cmnd
	 * @param diaChi
	 */
	public NhanVien(String tenNV, String maNV, boolean gioiTinh, String sdt, String cmnd, DiaChi diaChi) {
		super();
		this.tenNV = tenNV;
		this.maNV = maNV;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
	}
	
	/**
	 * @param maNV
	 */
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	@Override
	public String toString() {
		return "NhanVien [tenNV=" + tenNV + ", maNV=" + maNV + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", matKhau="
				+ matKhau + ", trangThaiLam=" + trangThaiLam + ", loaiNhanVien=" + loaiNhanVien + ", cmnd=" + cmnd
				+ ", diaChi=" + diaChi + "]";
	}
	
}
