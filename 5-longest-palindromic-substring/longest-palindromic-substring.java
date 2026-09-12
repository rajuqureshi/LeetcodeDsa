class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int center = 0; center < s.length(); center++) {
            int oddLength = expand(s, center, center);
            int evenLength = expand(s, center, center + 1);
            int length = Math.max(oddLength, evenLength);

            if (length > end - start + 1) {
                start = center - (length - 1) / 2;
                end = center + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}