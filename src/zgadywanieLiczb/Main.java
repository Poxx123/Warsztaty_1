package zgadywanieLiczb;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        play();
    }

    static void play() {

        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = 0;

        Scanner in = new Scanner(System.in);
        while (true) {

            System.out.println("Zgadnij liczbę");
            while (!in.hasNextInt()) {

                System.out.println("To nie jest liczba");
                System.out.println("Zgadnij liczbę");
                in.next();

            }
            guess = in.nextInt();

            if (guess < number) {

                System.out.println("Za mało!");

            } else if (guess > number) {

                System.out.println("Za dużo!");

            } else {

                System.out.println("Zgadłeś!");
                break;

            }
        }
    }
}
