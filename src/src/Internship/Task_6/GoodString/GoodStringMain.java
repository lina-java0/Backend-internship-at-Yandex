package Internship.Task_6.GoodString;

import java.io.*;

public class GoodStringMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] letters = new int[n];

        for (int i = 0; i < n; i++) {
            letters[i] = Integer.parseInt(reader.readLine());
        }

        long answer = 0;

        for (int i = 0; i < n - 1; i++) {
            answer += Math.min(letters[i], letters[i + 1]);
        }

        writer.write(String.valueOf(answer));

        reader.close();
        writer.close();
    }
}
