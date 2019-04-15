package zgadywanieLiczb2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        play();

    }

    static void play() {

        Scanner in = new Scanner(System.in);
        int min = 0, max = 1000;

        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        while (true) {

            int guess = ((max - min) / 2) + min;

            while (true) {

                System.out.println("Zgaduję: " + guess);

                System.out.println("Jak mi poszlo? (mniej, wiecej, zgadles)");
                String answer = in.nextLine();

                if ("zgadles".equals(answer)) {

                    System.out.println("Wygrałem!");
                    return;

                } else if ("mniej".equals(answer)) {

                    max = guess;
                    break;

                } else if ("wiecej".equals(answer)) {

                    min = guess;
                    break;

                } else {

                    System.out.println("Nie oszukuj!");
                }

            }
        }

    }
}
