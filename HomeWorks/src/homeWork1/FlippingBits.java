package homeWork1;

import java.util.Scanner;

public class FlippingBits {
    public static void main(final String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // Multiply with longest unsigned 32bit int ( 2^32 or 1xFFFFFFFFFL
            // or 4294967295L)
            System.out.println(sc.nextLong() ^ 4294967295L);
        }
        sc.close();
    }
}
