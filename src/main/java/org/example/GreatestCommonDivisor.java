package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GreatestCommonDivisor {
    static void main() {
        System.out.println(gcdOfStrings("ababab", "abab"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd2(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static int gcd2(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd2(y, x % y);
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
