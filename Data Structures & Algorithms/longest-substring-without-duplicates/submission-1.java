class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0)
            return 0;

        int start=0, end=start+1, maxLength=0,count=1;

        Set<Character> dup = new HashSet<>();
        dup.add(s.charAt(start));

        while(end< s.length()) {
            char ch = s.charAt(end);
            if(dup.contains(ch)) {
                dup.remove(s.charAt(start));
                start++;
                maxLength=Math.max(maxLength, count);
                count--;
            } else {
                count++;
                dup.add(ch);
                end++;
            }
        }

        return maxLength = Math.max(maxLength, count);
        
    }
}
