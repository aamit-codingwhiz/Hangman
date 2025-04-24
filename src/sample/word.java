package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class word {
    BufferedReader read;
    ArrayList<String> list;

    word() {
        try {
            read = new BufferedReader(new FileReader("src/sample/wordList.txt"));
            list = new ArrayList<>();

            String s = read.readLine();
            while (s != null) {
                s = s.trim();
                list.add(s);
                s = read.readLine();
//                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        int index = (int) ((Math.random() * 10000) % list.size());
        String s = list.get(index);

        if (s.length() >= 5)
            return s;

        return getRandomWord();
    }

    public static void main(String[] args) {
        String s = (new word().getRandomWord());
        System.out.println(s);
        System.out.println(s.length());
    }
}
