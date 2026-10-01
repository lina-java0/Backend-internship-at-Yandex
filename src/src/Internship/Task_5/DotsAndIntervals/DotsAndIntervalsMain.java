package Internship.Task_5.DotsAndIntervals;

import java.io.*;
import java.util.Arrays;

public class DotsAndIntervalsMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int[] arrStartInterval = new int[n];
        int[] arrEndInterval = new int[n];

        for (int i = 0; i < n; i++) {
            String[] intervals = reader.readLine().split(" ");

            int a = Integer.parseInt(intervals[0]);
            int b = Integer.parseInt(intervals[1]);

            arrStartInterval[i] = Math.min(a, b);
            arrEndInterval[i] = Math.max(a, b);
        }

        String[] dots = reader.readLine().split(" ");
        int[] arrDots = new int[m];

        for (int i = 0; i < m; i++) {
            arrDots[i] = Integer.parseInt(dots[i]);
        }

        Arrays.sort(arrStartInterval);
        Arrays.sort(arrEndInterval);

        for (int i = 0; i < m; i++) {
            int x  = arrDots[i];

            int started = countLessOrEqual(arrStartInterval, x);
            int finished = countLess(arrEndInterval, x);

            int answer = started - finished;

            writer.write(answer + " ");
        }

        reader.close();
        writer.close();
    }

    static int countLessOrEqual(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static int countLess(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
