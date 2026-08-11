package org.example;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {0,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(flowerbed, 3));
    }

    /*
        Input: flowerbed = [1,0,0,0,1], n = 1
       Output: true
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftPlotEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isRightPlotEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (isLeftPlotEmpty && isRightPlotEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
