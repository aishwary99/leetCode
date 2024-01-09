// link
/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * https://www.youtube.com/watch?v=3ZuLKFPsYv8
 */
// code
class Solution {
    // Utility method to calculate GCD
    private int calculateGCD(int first, int second) {
        while (second % first != 0) {
            int remainder = second % first;
            second = first;
            first = remainder;
        }
        
        return first;
    }
    
    // Shell function to calculate GCD of strings
    public String gcdOfStrings(String inputOne, String inputTwo) {
        if ((inputOne + inputTwo).equals(inputTwo + inputOne)) {
            int inputOneLength = inputOne.length();
            int inputTwoLength = inputTwo.length();
            int greatestCommonDivisor = calculateGCD(inputOneLength, inputTwoLength);
            return inputOne.substring(0, greatestCommonDivisor);
        } else {
            return "";
        }
    }
}