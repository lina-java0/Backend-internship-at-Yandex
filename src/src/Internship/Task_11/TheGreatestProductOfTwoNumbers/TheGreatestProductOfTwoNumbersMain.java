package Internship.Task_11.TheGreatestProductOfTwoNumbers;

import java.io.*;

public class TheGreatestProductOfTwoNumbersMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = reader.readLine().split(" ");

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else {
                max2 = Math.max(max2, num);
            }

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else {
                min2 = Math.min(min2, num);
            }
        }
        long productMax = (long) max1 * max2;
        long productMin = (long) min1 * min2;

        if (productMax >= productMin) {
            writer.write(max1 + " " + max2);
        } else {
            writer.write(min1 + " " + min2);
        }

        reader.close();
        writer.close();
    }
}
