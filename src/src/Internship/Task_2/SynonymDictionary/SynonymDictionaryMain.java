package Internship.Task_2.SynonymDictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SynonymDictionaryMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Map<String, String> synonyms = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] pair = reader.readLine().split(" ");

            synonyms.put(pair[0], pair[1]);
            synonyms.put(pair[1], pair[0]);
        }

        String word = reader.readLine();

        writer.write(synonyms.get(word));

        reader.close();
        writer.close();
    }
}
