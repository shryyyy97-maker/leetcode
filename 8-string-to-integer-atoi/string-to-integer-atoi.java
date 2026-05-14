class Solution {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        
        int sign = 1;
        int i = 0;
        long num = 0;
        int n = s.length();
        
        // Handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        
        // Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i++) - '0');
            
            // Check overflow
            if (num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        
        return (int)(sign * num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("1337sos")); // Output: 1337
        System.out.println(myAtoi("-91283472332")); // Output: -2147483648
    }
}