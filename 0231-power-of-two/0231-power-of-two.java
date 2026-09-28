class Solution {

    public boolean powerCheck(int n) {
        // Base case
        if (n == 1) {
            return true;
        }

        // If n is not divisible by 2, it cannot be a power of 2
        if (n % 2 != 0) {
            return false;
        }

        return powerCheck(n / 2);
    }

    public boolean isPowerOfTwo(int n) {

        // Powers of 2 are positive
        if (n <= 0) {
            return false;
        }

        return powerCheck(n);
    }
}