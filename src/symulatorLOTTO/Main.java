package symulatorLOTTO;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        lotto();

    }

    static void lotto() {

        Random rand = new Random();
        Integer[] numbers = new Integer[6];
        Integer[] guess = new Integer[6];
        int number = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(49) + 1;
        }

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < guess.length; i++) {

            System.out.println("Podaj liczbę");
            while (!in.hasNextInt()) {

                System.out.println("To nie jest liczba");
                System.out.println("Podaj liczbę");
                in.next();

            }
            number = in.nextInt();

            if (Arrays.asList(guess).contains(number) || (number > 49 || number < 1)) {

                System.out.println("Już podałeś tę liczbę lub nie należy do zakresu 1-49");
                i--;

            } else {

                guess[i] = number;

            }

        }

        Arrays.sort(guess);
        System.out.println(Arrays.toString(guess));
        System.out.println(Arrays.toString(numbers));

        AtomicInteger score = new AtomicInteger(0);
        Arrays.stream(guess).forEach(x -> {
            if (Arrays.asList(numbers).contains(x)) {
                score.getAndIncrement();
            }
        });

        switch (score.get()) {
            case 3:
                System.out.println("Trafiłeś 3!");
                break;
            case 4:
                System.out.println("Trafiłeś 4!");
                break;
            case 5:
                System.out.println("Trafiłeś 5!");
                break;
            case 6:
                System.out.println("Trafiłeś 6!");
                break;
            default:
                System.out.println("Nic nie trafiłeś :(");
                break;
        }
    }
}
