// Question:
// Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
// An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

// Constraints:

// 1 <= strs.length <= 1000.
// 0 <= strs[i].length <= 100
// strs[i] is made up of lowercase English letters.

// Example:

// Input: strs = ["act","pots","tops","cat","stop","hat"]
// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> freq = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(char ch: str.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            freq.putIfAbsent(key, new ArrayList<>());
            freq.get(key).add(str);
        }
        return new ArrayList<>(freq.values());
    }
}
