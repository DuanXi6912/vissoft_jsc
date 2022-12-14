package vissoft;

import java.io.*;

public class Problem2 {
	public static void main(String args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("C:/Users/nguye/OneDrive/Desktop/input.txt");
			out = new FileOutputStream("C:/Users/nguye/OneDrive/Desktop/output.txt");
			int c;
			while ((c = in.read()) != -1) {
				String s = Character.toString(c);
				if(s.contains(" ")) {
					s = "_";
				}
				c = s.charAt(0);
				out.write(c);
			}
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
		} finally {
			in.close();
			out.close();
			System.out.println("Done");
		}
	}
}
