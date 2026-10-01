package Internship.Task_9.PrettyLine;

import java.io.*;

public class PrettyLineMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine());
        String s = reader.readLine();

        // The left boundary of the window
        int left = 0;

        // The maximum length of the window
        int maxLength = 0;

        // The maximum number of identical characters
        int maxCount = 0;

        // count[i] stores the number of characters
        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            count[index]++;

            // The maximum number of identical characters in the window
            maxCount = Math.max(maxCount, count[index]);

            int replacement = (right - left + 1) - maxCount;

            while (replacement > k) {
                count[s.charAt(left) - 'a']--;
                left++;

                replacement = (right - left + 1) - maxCount;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        writer.write(String.valueOf(maxLength));

        reader.close();
        writer.close();
    }
}
