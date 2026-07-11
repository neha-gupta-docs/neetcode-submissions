class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCounts = new int[128];
        int start = 0, maxLength = 0;
        
        for (int end = 0; end < s.length(); end++) {
            charCounts[s.charAt(end)]++;
            
            // O(1) array lookups instead of HashMap hashing
            while (charCounts[s.charAt(end)] > 1) {
                charCounts[s.charAt(start)]--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}