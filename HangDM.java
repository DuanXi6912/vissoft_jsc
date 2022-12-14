package vissoft;

public class HangDM extends Hang {
	private int baoHanh;
	private final double VATDM = 0.1;
	private int congSuat;

	public HangDM(String mH, String tH, double dG, int sL, int baoHanh, int congSuat) {
		super(mH, tH, dG, sL);
		this.baoHanh = baoHanh;
		this.congSuat = congSuat;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) {
		this.congSuat = congSuat;
	}

	public double getVAT() {
		return VATDM;
	}

	@Override
	public String thongTin() {
		// TODO Auto-generated method stub
		return super.thongTin() + ", baoHanh : " + this.getBaoHanh() + ", congSuat = " + this.getCongSuat() + ", VAT = "
				+ this.getVAT() + "]";
	}

	@Override
	void danhGia() {
		// TODO Auto-generated method stub
		if (this.getSoLuongTon() < 3) {
			System.out.println("Ban Duoc");
		} else {
			System.out.println("UNKNOW");
		}

	}

}
