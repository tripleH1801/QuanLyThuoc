/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: HP
* @date: 10 Nov 2020
* @version: 1.0
*/
package entity;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private boolean gioiTinh;
	private String soDienThoai;
	private DiaChi diaChi;
	private boolean trangThai;
	public KhachHang(String maKhachHang, String tenKhachHang, boolean gioiTinh, String soDienThoai, DiaChi diaChi,
			boolean trangThai) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
	}
	
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	

	public KhachHang(String tenKhachHang, boolean gioiTinh, String soDienThoai, DiaChi diaChi, boolean trangThai) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
	}
	
	public String getMaKhachHang() {
		return maKhachHang;
	}
	
	
	/**
	 * @param maKhachHang
	 * @param tenKhachHang
	 */
	public KhachHang(String maKhachHang, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
	}

	/**
	 * @param tenKhachHang
	 * @param gioiTinh
	 * @param diaChi
	 */
	public KhachHang(String tenKhachHang, boolean gioiTinh, DiaChi diaChi) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", trangThai=" + trangThai + "]";
	}
	
	
	
}
