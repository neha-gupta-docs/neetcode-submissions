class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;

        while(start<end) {
            while(start < end && !isAlphaNumeric(s.charAt(start))) {
                start++;
            }

            while(start < end && !isAlphaNumeric(s.charAt(end))) {
                end--;
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z') || ( ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
