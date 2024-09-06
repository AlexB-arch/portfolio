package leetcode;

public class PalindromicSubstring {

    /*
     * Given a string s, return the longest palindromic substring in s.
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * 
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: "bb"
     * 
     */

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            int len1 = expandAroundCenter(s, i, i); // odd length
            int len2 = expandAroundCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            } 
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1; // R - L + 1 - 2
    }
    
}
