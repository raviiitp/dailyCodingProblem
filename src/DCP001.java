/*
*
* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*
*
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DCP001 {

    public boolean twoElementsSumMatches_approach1(double[] numbers, int k) {
        boolean twoElementsSumMatches = false;
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == k) {
                twoElementsSumMatches = true;
                break;
            } else if (numbers[i] + numbers[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return twoElementsSumMatches;
    }

    public boolean twoElementsSumMatches_approach2(double[] numbers, int k) {
        Set<Double> seenNumbers = new HashSet<>();

        for (double number : numbers) {
            if (seenNumbers.contains(number)) {
                return true;
            } else {
                seenNumbers.add(k - number);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DCP001 dcp001 = new DCP001();
        System.out.println(dcp001.twoElementsSumMatches_approach1(new double[]{10, 15, 3, 7}, 4));
        System.out.println(dcp001.twoElementsSumMatches_approach1(new double[]{10, 15, 3, 7}, 17));
        System.out.println(dcp001.twoElementsSumMatches_approach1(new double[]{-10, 15, -3, 7}, -13));
        System.out.println(dcp001.twoElementsSumMatches_approach1(new double[]{-10, 15, -3, 7}, -3));
        System.out.println();
        System.out.println(dcp001.twoElementsSumMatches_approach2(new double[]{10, 15, 3, 7}, 4));
        System.out.println(dcp001.twoElementsSumMatches_approach2(new double[]{10, 15, 3, 7}, 17));
        System.out.println(dcp001.twoElementsSumMatches_approach2(new double[]{-10, 15, -3, 7}, -13));
        System.out.println(dcp001.twoElementsSumMatches_approach2(new double[]{-10, 15, -3, 7}, -3));
    }
}
