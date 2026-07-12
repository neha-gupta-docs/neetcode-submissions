class Solution {
    public int characterReplacement(String s, int k) {

        int result = 0;

        int left = 0, maxf=0;
        HashMap<Character,Integer> count = new HashMap<>();

        for(int right=0; right<s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right),0)+1);
            maxf = Math.max(maxf, count.get(s.charAt(right)));

            if((right-left+1) - maxf > k) {
                count.put(s.charAt(left), count.get(s.charAt(left))-1);
                left++;
            }

            result = Math.max(result, right-left+1);
        }

        return result;
        
    }
}
