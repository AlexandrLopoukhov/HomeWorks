package homeWork2_LSDsort;

import java.util.Arrays;
import java.util.Random;

public class LSDsorting {

	public static void main(String[] args) {

		int[] mass = new int[1000000];

		Random random = new Random();

		for (int i = 0; i < mass.length; i++) {
			mass[i] = random.nextInt(Integer.MAX_VALUE); // put random numbers
															// from 0 to
			// 10000
		}

		/*
		 * for (int i = 0; i < mass.length; i++) { System.out.print(mass[i] +
		 * " "); }
		 */

		int[] massDupl1 = mass.clone();
		int[] massDupl2 = mass.clone();

		// sort by LSD with time count in nanoseconds
		long timeout1 = System.nanoTime();
		sortLSD(massDupl1);
		timeout1 = System.nanoTime() - timeout1;

		// sort by Arrays.sort with time count in nanoseconds
		long timeout2 = System.nanoTime();
		Arrays.sort(massDupl2);
		timeout2 = System.nanoTime() - timeout2;

		System.out.println("\n" + "Сортировка методом lsd за время " + timeout1
				+ " нсек");
		/*
		 * for (int i = 0; i < mass.length; i++) { System.out.print(massDupl1[i]
		 * + " "); }
		 */

		System.out.println("\n" + "Сортировка методом Arrays.sort за время "
				+ timeout2 + " нсек");
		/*
		 * for (int i = 0; i < mass.length; i++) { System.out.print(massDupl2[i]
		 * + " "); }
		 */

	}

	public static void sortLSD(int[] a) {
		final int BITS_PER_BYTE = 8;
		int BITS = 32; // each int is 32 bits
		int W = BITS / BITS_PER_BYTE; // each int is 4 bytes
		int R = 1 << BITS_PER_BYTE; // each bytes is between 0 and 255
		int MASK = R - 1; // 0xFF

		int N = a.length;
		int[] aux = new int[N];

		for (int d = 0; d < W; d++) {

			// compute frequency counts
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
				count[c + 1]++;
			}

			// compute cumulates
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// for most significant byte, 0x80-0xFF comes before 0x00-0x7F
			if (d == W - 1) {
				int shift1 = count[R] - count[R / 2];
				int shift2 = count[R / 2];
				for (int r = 0; r < R / 2; r++) {
					count[r] += shift1;
				}
				for (int r = R / 2; r < R; r++) {
					count[r] -= shift2;
				}
			}

			// move data
			for (int i = 0; i < N; i++) {
				int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
				aux[count[c]++] = a[i];
			}

			// copy back
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}
}
