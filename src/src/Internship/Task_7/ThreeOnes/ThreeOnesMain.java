package Internship.Task_7.ThreeOnes;

import java.io.*;

public class ThreeOnesMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int f_1 = 2;
        int f_2 = 4;
        int f_3 = 7;

        if (n == 1) {
            writer.write(String.valueOf(f_1));
        } else if (n == 2) {
            writer.write(String.valueOf(f_2));
        } else if (n == 3) {
            writer.write(String.valueOf(f_3));
        } else {
            for (int i = 4; i < n; i++) {
                int f_next = f_1 + f_2 + f_3;
                f_1 = f_2;
                f_2 = f_3;
                f_3 = f_next;
            }
            writer.write(String.valueOf(f_3));
        }
        reader.close();
        writer.close();
    }
}
