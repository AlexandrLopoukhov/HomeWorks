package homeWork1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random rand = new Random();

		int maxSeed = 100;

		int minSeed = 0;

		int lastNumber = rand.nextInt(maxSeed - minSeed) + minSeed;

		int steps = 0;

		System.out
				.println("Загадайте число от 0 до 100. Компьютер попробует отгадать его.");

		System.out.println(lastNumber);

		while (sc.hasNext()) {
			String userInput = sc.nextLine();
			if (userInput.equals("less")) {
				maxSeed = lastNumber;
				lastNumber = rand.nextInt(maxSeed - minSeed) + minSeed;
				System.out.println(lastNumber);
				steps++;
			} else if (userInput.equals("more")) {
				minSeed = lastNumber + 1;
				lastNumber = rand.nextInt(maxSeed - minSeed) + minSeed;
				System.out.println(lastNumber);
				steps++;
			} else if (userInput.equals("quit")) {
				break;
			} else if (userInput.equals("bingo")) {
				System.out.println("Компьютера угадала число за " + steps
						+ " шагов");
				break;
			} else if (steps > 7) {
				System.out
						.println("Компьютеру не удалось угадать ваше число за 7 попыток. Попробуйте еще раз.");
				break;
			} else {
				System.out.println("Неверная команда, повторите");
			}
		}

		sc.close();
	}
}
