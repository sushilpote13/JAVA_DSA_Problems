class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // If str1 + str2 != str2 + str1,
        // then there is no common divisor string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}