package homeWork1;

import java.util.Scanner;

public class FlippingBits {
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			// Multiply with longest unsigned 32bit int ( 2^32 or 1xFFFFFFFFFL
			// or 4294967295L)
			System.out.println(in.nextLong() ^ 4294967295L);
		}
	}
}