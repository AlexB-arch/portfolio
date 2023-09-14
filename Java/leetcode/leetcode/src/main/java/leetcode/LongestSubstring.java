package leetcode;

public class LongestSubstring {

    /*
     * Given a string s, find the length of the longest substring
     * without repeating characters.
     */

     public int lenghtOfSubstring(String s){
            int n = s.length();
            int ans = 0;
            int[] index = new int[128];
    
            for(int j = 0, i = 0; j < n; j++){
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
     }
}
