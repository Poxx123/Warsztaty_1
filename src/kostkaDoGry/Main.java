package kostkaDoGry;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println(rzucaj("2D10-5"));
        System.out.println(rzucaj("D1+1"));
        System.out.println(rzucaj("D2"));

    }

    static int rzucaj(String kod) {

        String amount = "";
        String type = "";
        String factor = "";
        String sign = "";
        int amountInt, typeInt, factorInt;

        int i = 0;
        //Get amount
        for (; i < kod.length(); i++) {

            if ('D' == kod.charAt(i)) {
                i++;
                break;
            } else {
                amount += kod.charAt(i);
            }

        }
        //Get type
        for (; i < kod.length(); i++) {

            if ('+' == kod.charAt(i)) {
                i++;
                sign = "+";
                break;
            } else if ('-' == kod.charAt(i)) {
                i++;
                sign = "-";
                break;
            } else {
                type += kod.charAt(i);
            }

        }
        //Get factor
        for (; i < kod.length(); i++) {

            factor += kod.charAt(i);

        }

        //convert
        if (amount.equals("")) {
            amountInt = 1;
        } else {
            amountInt = Integer.parseInt(amount);
        }
        if (factor.equals("")) {
            factorInt = 0;
        } else {
            factorInt = Integer.parseInt(sign + factor);
        }
        typeInt = Integer.parseInt(type);

        Random rand = new Random();
        int result = 0;
        for (int j = 0; j < amountInt; j++) {

            result += rand.nextInt(typeInt) + 1;

        }
        return result + factorInt;

    }
}
