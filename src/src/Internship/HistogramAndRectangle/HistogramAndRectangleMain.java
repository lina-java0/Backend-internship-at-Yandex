package Internship.HistogramAndRectangle;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class HistogramAndRectangleMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());

        int[] heights = new int[n + 1];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // The last element is a virtual column with a height of 0
        heights[n] = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        long maxArea = 0;

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        writer.write(String.valueOf(maxArea));

        reader.close();
        writer.close();
    }
}
