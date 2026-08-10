package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MergeArraysAlternately {
    static void main() {

    }

    public static String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        StringBuilder mergedStr = new StringBuilder();

        if (word1Length > word2Length) {
            for (int i = 0; i < word2Length; i++) {
                mergedStr.append(word1.charAt(i));
                mergedStr.append(word2.charAt(i));
            }
            mergedStr.append(word1.substring(word2Length));
        }

        if (word1Length < word2Length) {
            for (int i = 0; i < word1Length; i++) {
                mergedStr.append(word1.charAt(i));
                mergedStr.append(word2.charAt(i));
            }
            mergedStr.append(word2.substring(word1Length));
        }

        if (word1Length == word2Length) {
            for (int i = 0; i < word1Length; i++) {
                mergedStr.append(word1.charAt(i));
                mergedStr.append(word2.charAt(i));
            }
        }
        return mergedStr.toString();
    }
}
