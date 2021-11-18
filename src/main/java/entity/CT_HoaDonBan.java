package entity;

public class CT_HoaDonBan {
	private int soLuong;
	private double giaBan;
	private Thuoc thuoc;
	private HoaDonBan hoaDonBan;
	private float vat;

	public CT_HoaDonBan(int soLuong, double giaBan, Thuoc thuoc, HoaDonBan hoaDonBan, float vat) {
		super();
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thuoc = thuoc;
		this.hoaDonBan = hoaDonBan;
		this.vat = vat;
	}

	public CT_HoaDonBan() {
		super();
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public Thuoc getThuoc() {
		return thuoc;
	}

	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}

	public HoaDonBan getHoaDonBan() {
		return hoaDonBan;
	}

	public void setHoaDonBan(HoaDonBan hoaDonBan) {
		this.hoaDonBan = hoaDonBan;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDonBan == null) ? 0 : hoaDonBan.hashCode());
		result = prime * result + ((thuoc == null) ? 0 : thuoc.hashCode());
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
		CT_HoaDonBan other = (CT_HoaDonBan) obj;
		if (hoaDonBan == null) {
			if (other.hoaDonBan != null)
				return false;
		} else if (!hoaDonBan.equals(other.hoaDonBan))
			return false;
		if (thuoc == null) {
			if (other.thuoc != null)
				return false;
		} else if (!thuoc.equals(other.thuoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CT_HoaDonBan [soLuong=" + soLuong + ", giaBan=" + giaBan + ", thuoc=" + thuoc + ", hoaDonBan="
				+ hoaDonBan + ", vat=" + vat + "]";
	}
	

	public CT_HoaDonBan(Thuoc thuoc, int soLuong, double giaBan, float vat) {
		super();
		this.thuoc = thuoc;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.vat = vat;
	}

	public double thanhTien() {
		return (this.giaBan * (1 + this.vat) * this.soLuong);
	}
}
