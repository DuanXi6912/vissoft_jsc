package vissoft;

import java.util.Calendar;
import java.util.Scanner;

public class Quanly {
	
	private Hang[] hangHoa = new Hang[100];
	private int count = 0;
	public Calendar toDay = Calendar.getInstance();
	public Quanly() {
		// TODO Auto-generated constructor stub

		hangHoa[0] = new HangTP("TP01", "Thit Lon", 55, 10, "BigC", "10/12/2022", "12/12/2022");
		count++;
		hangHoa[1] = new HangTP("TP02", "Thit Bo", 65, 15, "BigC", "9/12/2022", "12/12/2022");
		count++;
		hangHoa[2] = new HangTP("TP03", "Thit De", 60, 12, "BigC", "8/12/2022", "10/12/2022");
		count++;
		hangHoa[3] = new HangSS("SS01", "Bat", 15, 30, "3/12/2022", "12/12/2022");
		count++;
		hangHoa[4] = new HangSS("SS02", "Binh", 50, 2, "5/12/2022", "12/12/2022");
		count++;
		hangHoa[5] = new HangDM("DM01", "May Lanh", 1500, 1, 3, 300);
		count++;
		hangHoa[6] = new HangDM("DM02", "Ti Vi", 4000, 15, 5, 150);
		count++;
	}

	public void PrintMenu() {
		System.out.println("1. Xem Thong Tin San Pham");
		System.out.println("2. In Toan Bo Danh Sach Cac Hang Hoa");
		System.out.println("3. Them Hang Hoa");
		System.out.println("4. Danh Gia Muc Do Ban");
		System.out.println("5. -1 to exit");
	}

	public void PrintItem(String k, String o) {
		int index = -1;
		boolean search = false;
		for (int i = 0; i < count; i++) {
			if (hangHoa[i].getMaHang().equals(k)) {
				search = true;
				index = i;
				break;
			}
		}
		if (search && index != -1) {
			if (o.equals("TT")) {
				System.out.println(hangHoa[index].thongTin());
			} else if (o.equals("DG")) {
				hangHoa[index].danhGia();
			}
		} else {
			System.out.println("UNKNOW");
		}
	}

	public void PrintInfo() {
		for (int i = 0; i < count; i++) {
			System.out.println(hangHoa[i].thongTin());
		}
	}

	public void addHang() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma Hang: ");
		String mH = sc.nextLine();
		if (checkMH(mH) && (mH.contains("TP") || mH.contains("SS") || mH.contains("DM"))) {
			System.out.println("Ten Hang: ");
			String tH = sc.nextLine();
			System.out.println("Don Gia: ");
			double dG = sc.nextDouble();
			System.out.println("So Luong: ");
			int sL = sc.nextInt();
			if (mH.contains("TP")) {
				System.out.println("Nha Cung Cap: ");
				String nCC = sc.nextLine();
				System.out.println("Ngay San Xuat (dd/mm/yy): ");
				String nSX = sc.nextLine();
				System.out.println("Ngay Het Han (dd/mm/yy): ");
				String nHH = sc.nextLine();
				
				if (count < hangHoa.length && checkTime(nSX) != 1 && checkTime(nHH) != -1) {
					hangHoa[count] = new HangTP(mH, tH, dG, sL, nCC, nSX, nHH);
					count++;
					System.out.println("Done");
				} else {
					System.out.println("Something Wrong");
				}

			} else if (mH.contains("SS")) {
				System.out.println("Ngay San Xuat (dd/mm/yy): ");
				String nSX = sc.nextLine();
				System.out.println("Ngay Nhap Kho (dd/mm/yy): ");
				String nNK = sc.nextLine();
				if (count < hangHoa.length && checkTime(nSX) != 1 && checkTime(nNK) != 1) {
					hangHoa[count] = new HangSS(mH, tH, dG, sL, nSX, nNK);
					count++;
					System.out.println("Done");
				} else {
					System.out.println("Full Box");
				}
			} else {
				System.out.println("Bao Hanh (thang): ");
				int bH = sc.nextInt();
				System.out.println("Cong Suat (w): ");
				int cS = sc.nextInt();
				if (count < hangHoa.length) {
					hangHoa[count] = new HangDM(mH, tH, dG, sL, bH, cS);
					count++;
					System.out.println("Done");
				} else {
					System.out.println("Full Box");
				}
			}
		} else {
			System.out.println("Try Again");
		}
	}

	public boolean checkMH(String mH) {
		for (int i = 0; i < count; i++) {
			if (hangHoa[i].getMaHang().equals(mH)) {
				return false;
			}
		}
		return true;
	}
	public int checkTime(String time) {
		String[] day = time.split("/");
		if(Integer.parseInt(day[2]) > toDay.get(Calendar.YEAR)||
				Integer.parseInt(day[2]) == toDay.get(Calendar.YEAR) && Integer.parseInt(day[1]) > toDay.get(Calendar.MONTH)
				|| Integer.parseInt(day[2]) == toDay.get(Calendar.YEAR) && Integer.parseInt(day[1]) == toDay.get(Calendar.MONTH) && Integer.parseInt(day[0]) > toDay.get(Calendar.DATE) ) {
			return 1;
		} 
		if(Integer.parseInt(day[2]) == toDay.get(Calendar.YEAR) && Integer.parseInt(day[1]) == toDay.get(Calendar.MONTH) && Integer.parseInt(day[0]) == toDay.get(Calendar.DATE)) {
			return 0;
		}
		return -1;
	}
	
}
