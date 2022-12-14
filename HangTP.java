package vissoft;

import java.util.Calendar;

public class HangTP extends Hang {
	private final double VATTP = 0.05;
	private String nhaCungCap;
	private String ngaySanXuat;
	private String ngayHetHan;

	public HangTP(String mH, String tH, double dG, int sL, String nCC, String nSX, String nHH) {
		super(mH, tH, dG, sL);
		this.nhaCungCap = nCC;
		this.ngaySanXuat = nSX;
		this.ngayHetHan = nHH;
		// TODO Auto-generated constructor stub
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(String ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public double getVAT() {
		return VATTP;
	}

	public boolean checkOutDate() {
		String[] nTN = this.getNgayHetHan().split("/");
		if (Integer.parseInt(nTN[2]) > toDay.get(Calendar.YEAR)
			|| Integer.parseInt(nTN[2]) == toDay.get(Calendar.YEAR)	&& Integer.parseInt(nTN[1]) < toDay.get(Calendar.MONTH)				
			|| Integer.parseInt(nTN[2]) == toDay.get(Calendar.YEAR) && Integer.parseInt(nTN[1]) == toDay.get(Calendar.MONTH) 
			&& Integer.parseInt(nTN[0]) < toDay.get(Calendar.DATE)) {
			return true;
		}
		return false;
	}

	@Override
	public String thongTin() {
		// TODO Auto-generated method stub
		return super.thongTin() + ", nCC = " + this.getNhaCungCap() + ", nSX = " + this.getNgaySanXuat() + ", nHH = "
				+ this.ngayHetHan + ", VAT = " + this.getVAT() + "]";
	}

	@Override
	void danhGia() {
		// TODO Auto-generated method stub
		if (this.getSoLuongTon() > 0 && checkOutDate()) {
			System.out.println("Kho ban");
		} else {
			System.out.println("UNKNOW");
		}
	}

}
