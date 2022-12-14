package vissoft;

import java.util.Calendar;

public class HangSS extends Hang {
	private final double VATSS = 0.1;
	private String ngaySanSuat;
	private String ngayNhapKho;

	public HangSS(String mH, String tH, double dG, int sL, String ngaySanSuat, String ngayNhapKho) {
		super(mH, tH, dG, sL);
		this.ngaySanSuat = ngaySanSuat;
		this.ngayNhapKho = ngayNhapKho;
	}

	public String getNgaySanSuat() {
		return ngaySanSuat;
	}

	public void setNgaySanSuat(String ngaySanSuat) {
		this.ngaySanSuat = ngaySanSuat;
	}

	public String getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(String ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	public double getVAT() {
		return VATSS;
	}

	public int dayDiff() {
		String[] nTN = this.getNgayNhapKho().split("/");
		int dayDiff = 0;
		if (toDay.get(Calendar.YEAR) > Integer.parseInt(nTN[2])) {
			for (int i = 1; i < toDay.get(Calendar.MONTH); i++) {
				dayDiff += DaysInMonth[i - 1];
			}
			for (int k = Integer.parseInt(nTN[2]); k < 12; k++) {
				dayDiff += DaysInMonth[k - 1];
			}
			dayDiff += (DaysInMonth[Integer.parseInt(nTN[2])] - Integer.parseInt(nTN[1]) + 1) + toDay.get(Calendar.DATE);
		} else {
			if (toDay.get(Calendar.MONTH) == Integer.parseInt(nTN[2])) {
				dayDiff = toDay.get(Calendar.DATE) - Integer.parseInt(nTN[2]);
			} else {
				for (int i = Integer.parseInt(nTN[2]) + 1; i < toDay.get(Calendar.MONTH); i++) {
					dayDiff += DaysInMonth[i - 1];
				}
				dayDiff += (DaysInMonth[Integer.parseInt(nTN[2])] - Integer.parseInt(nTN[1]) + 1) + toDay.get(Calendar.DATE);
			}
		}
		return dayDiff;

	}

	@Override
	public String thongTin() {
		// TODO Auto-generated method stub
		return super.thongTin() + ", nSX = " + this.getNgayNhapKho() + ", nNK = " + this.getNgayNhapKho() + ", VAT = "
				+ this.getVAT() + "]";
	}

	@Override
	void danhGia() {
		// TODO Auto-generated method stub
		if (this.getSoLuongTon() > 50 && this.dayDiff() > 10) {
			System.out.println("Ban Cham");
		} else {
			System.out.println("UNKNOW");
		}
	}

}
