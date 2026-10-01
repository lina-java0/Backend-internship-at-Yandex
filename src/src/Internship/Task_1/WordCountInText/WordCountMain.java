package Internship.Task_1.WordCountInText;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordCountMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder text = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }

        String[] words = text.toString().split("\\s+");

        Set<String> uniqueWords = new HashSet<>();

        Collections.addAll(uniqueWords, words);

        writer.write(String.valueOf(uniqueWords.size()));

        reader.close();
        writer.close();
    }
}
