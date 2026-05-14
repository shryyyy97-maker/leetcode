class Solution {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // Check overflow BEFORE updating rev
            if (rev > Integer.MAX_VALUE / 10 || 
                (rev == Integer.MAX_VALUE / 10 && digit > 7) ||
                rev < Integer.MIN_VALUE / 10 || 
                (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); // Output: 321
        System.out.println(reverse(-123)); // Output: -321
        System.out.println(reverse(1534236469)); // Output: 0 (overflow)
    }
}