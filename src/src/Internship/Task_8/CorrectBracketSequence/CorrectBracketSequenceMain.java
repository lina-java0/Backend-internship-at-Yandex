package Internship.Task_8.CorrectBracketSequence;

import java.io.*;
import java.util.Stack;

public class CorrectBracketSequenceMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();

        Stack<Character> stack = new Stack<>();

        boolean isCorrect = true;

        for (char current : s.toCharArray()) {
            switch (current) {
                case '(', '[', '{' -> stack.push(current);

                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isCorrect = false;
                    } else {
                        stack.pop();
                    }
                }

                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isCorrect = false;
                    } else {
                        stack.pop();
                    }
                }

                case '}' -> {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        isCorrect = false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        writer.write(isCorrect && stack.isEmpty() ? "yes" : "no");

        reader.close();
        writer.close();
    }
}
