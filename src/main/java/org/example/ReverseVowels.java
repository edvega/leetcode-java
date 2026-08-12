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
        List<Integer> vowelsPositions = new ArrayList<>();
        StringBuilder output = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.toLowerCase().charAt(i))) {
                vowelsFoundArr.add(s.charAt(i));
                vowelsPositions.add(i);
            }
        }

        int vowelsNum = vowelsFoundArr.size();
        for (Integer vowelsPosition : vowelsPositions) {
            output.setCharAt(vowelsPosition, vowelsFoundArr.get(vowelsNum - 1));
            vowelsNum--;
        }

        return output.toString();
    }
}
