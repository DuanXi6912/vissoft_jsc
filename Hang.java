package vissoft;

import java.util.Calendar;

abstract class Hang {
	private String maHang;
	private String tenHang;
	private double donGia;
	private int soLuongTon;
	public final int[] DaysInMonth = { 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public Calendar toDay = Calendar.getInstance();

	public Hang(String mH, String tH, double dG, int sL) {
		this.maHang = mH;
		this.tenHang = tH;
		this.donGia = dG;
		this.soLuongTon = sL;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String thongTin() {
		String str = "[MaHang= " + this.getMaHang() + " TenHang= " + this.getTenHang() + ", SoLuongTon= "
				+ this.getSoLuongTon() + " donGia= " + this.getDonGia();
		return str;
	}

	abstract void danhGia();
}
