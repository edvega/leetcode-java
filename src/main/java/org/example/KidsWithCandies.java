package org.example;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    static void main() {
        int[] candies = {12,1,12};
        System.out.println(kidsWithCandies(candies, 10));
    }

    /*
        Input: candies = [2,3,5,1,3], extraCandies = 3
        Output: [true,true,true,false,true]
        Explanation: If you give all extraCandies to:
        - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
        - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
        - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
        - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
        - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumOfCandies = 0;
        for (int i : candies) {
            if (i > maxNumOfCandies) {
                maxNumOfCandies = i;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            int candiesByKid = candy + extraCandies;
            result.add(candiesByKid >= maxNumOfCandies);
        }
        return result;
    }
}
