class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }

        if(sMap.size() != tMap.size())
            return false;
            
        for(char ch: sMap.keySet()) {
            if(!sMap.get(ch).equals(tMap.get(ch)))
                return false;
        }

        // In Java, sMap.get(ch) returns an Integer object wrapper.
        // The != operator compares the memory references of objects rather than their primitive values.
        // For small integers (typically -128 to 127), Java's integer caching makes != appear to work. However, for larger frequencies (as seen in the failed test case), the comparison returns false because the objects are at different memory locations.
        // Changing the comparison to use .equals() ensures we are comparing the numerical values inside the Integer objects.

        return true;

    }
}