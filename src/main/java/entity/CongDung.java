package entity;

public class CongDung {
	private String maCongDung;
	private String nhomCongDung;
	private String congDung;

	/**
	 * @return the maCongDung
	 */
	public String getMaCongDung() {
		return maCongDung;
	}

	/**
	 * @param maCongDung the maCongDung to set
	 */
	public void setMaCongDung(String maCongDung) {
		this.maCongDung = maCongDung;
	}

	/**
	 * @return the loaiCongDung
	 */
	public String getNhomCongDung() {
		return nhomCongDung;
	}

	/**
	 * @param loaiCongDung the loaiCongDung to set
	 */
	public void setNhomCongDung(String loaiCongDung) {
		this.nhomCongDung = loaiCongDung;
	}

	/**
	 * @return the congDung
	 */
	public String getCongDung() {
		return congDung;
	}

	/**
	 * @param congDung the congDung to set
	 */
	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}

	/**
	 * @param maCongDung
	 * @param loaiCongDung
	 * @param congDung
	 */
	public CongDung(String maCongDung, String loaiCongDung, String congDung) {
		super();
		this.maCongDung = maCongDung;
		this.nhomCongDung = loaiCongDung;
		this.congDung = congDung;
	}

	/**
	 * 
	 */
	public CongDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CongDung [maCongDung=" + maCongDung + ", loaiCongDung=" + nhomCongDung + ", congDung=" + congDung + "]";
	}
}
