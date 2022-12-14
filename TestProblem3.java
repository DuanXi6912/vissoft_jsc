package vissoft;

import java.util.Scanner;

public class TestProblem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Quanly menu = new Quanly();
		while (true) {
			menu.PrintMenu();
			System.out.println("Choose");
			int choose = Integer.parseInt(sc.nextLine());
			if (choose >= 1 && choose <= 4) {
				if (choose == 1) {
					System.out.println("Ma Hang Tim Kiem: ");
					String mh = sc.nextLine();
					if (mh.contains("TP") || mh.contains("DM") || mh.contains("SS")) {
						menu.PrintItem(mh, "TT");
					} else {
						System.out.println("Try Again");
					}
				} else if (choose == 2) {
					System.out.println("Thong tin san pham:");
					menu.PrintInfo();
				} else if (choose == 3) {
					menu.addHang();
				} else {
					System.out.println("Ma Hang Tim Kiem: ");
					String mh = sc.nextLine();
					if (mh.contains("TP") || mh.contains("DM") || mh.contains("SS")) {
						menu.PrintItem(mh, "DG");
					} else {
						System.out.println("Try Again");
					}
				}
			} else if (choose == -1) {
				System.out.println("Thank You");
				break;
			} else {
				System.out.println("Try Again");
			}
		}
		sc.close();
	}
}
