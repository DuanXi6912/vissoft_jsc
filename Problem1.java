package vissoft;

public class Problem1 {
	public static void getSum() {
		// ta co cong thuc 1 + 2 + ... + n = n(n+1)/2
		// 2 + 4 + 6 + ... + 2n = 2.(1 + 2 + ... + n) = n(n+1)
		int sum = 9 * (9 + 1);
		System.out.println("Tong 10 chu so chan dau : " + sum);
	}

	public static boolean checkPrime(int k) {
		if (k < 2) {
			return false;
		} else if (k == 2)
			return true;

		if (k % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(k); i += 2) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void printPrime(int n) {
		int count = 1;
		int numberStart = 2;
		while (count <= n && numberStart <= Integer.MAX_VALUE) {
			if (checkPrime(numberStart)) {
				System.out.print(count + ".\t");
				System.out.print(numberStart);
				System.out.println();
				count++;
			}
			numberStart++;
		}
	}

	public static void printTri(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if( i == j || j == 1 || i == n) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// tong 10 so chan
		getSum();
		// in N so nguyen to dau tien
		printPrime(10);
		// tam giac vuong can rong
		printTri(10);
	}
}
