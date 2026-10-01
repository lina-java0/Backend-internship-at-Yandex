package Internship.Task_3.IntervalMinimum;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class IntervalMinimumMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        String[] input = reader.readLine().split(" ");
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Remove indexes that have left the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Remove elements from the end that are greater than the new one
            while (!deque.isEmpty() && array[deque.peekLast()] >= array[i]) {
                deque.pollLast();
            }

            // 3. Add the index of the new element
            deque.addLast(i);

            // 4. When the first window is fully formed, we display the minimum
            if (i >= k - 1) {
                writer.write(array[deque.peekFirst()] + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
