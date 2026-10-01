package Internship.Task_4.TreeHeight;

import java.io.*;
import java.util.StringTokenizer;

public class TreeHeightMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Node root = null;
        int height = 0;

        while (tokenizer.hasMoreTokens()) {
            int value = Integer.parseInt(tokenizer.nextToken());

            if (value == 0) {
                break;
            }

            if (root == null) {
                root = new Node(value);
                height = 1;
            } else {
                height = Math.max(height, insert(root, value));
            }
        }

        writer.write(String.valueOf(height));

        writer.close();
        reader.close();
    }

    static int insert (Node root, int value) {
        Node current = root;
        int depth = 1;

        while (true) {
            if (value == current.value) {
                return depth;
            }

            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    return depth + 1;
                }
                current = current.left;
            }
            if (value > current.value) {
                if (current.right == null) {
                    current.right = new Node(value);
                    return depth + 1;
                }
                current = current.right;
            }
            depth++;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }
    }
}
