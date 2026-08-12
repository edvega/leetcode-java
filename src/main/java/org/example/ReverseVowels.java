package org.example;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }

    public static String reverseVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> vowelsFoundArr = new ArrayList<>();
        StringBuilder output = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.toLowerCase().charAt(i))) {
                vowelsFoundArr.add(s.charAt(i));
            }
        }

        int vowelsNum = vowelsFoundArr.size();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.toLowerCase().charAt(i))) {
                output.setCharAt(i, vowelsFoundArr.get(vowelsNum - 1));
                vowelsNum--;
            }
        }

        return output.toString();
    }
}
