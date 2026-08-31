class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] digitChar = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> response = new ArrayList<>();
        formStrings(digits, response, new StringBuilder(), 0, digitChar);
        return response;
    }

    private void formStrings(String digits, List<String> response, StringBuilder curr, int index, String[] digitChar) {

        if(index == digits.length()) {
            response.add(curr.toString());
            return;
        }

        if(index > digits.length()) {
            return;
        }
        
        int currIndex = digits.charAt(index) - '0';
        String str = digitChar[currIndex];
        for(int i=0; i<str.length(); i++) {
            curr.append(str.charAt(i));
            formStrings(digits,response,curr,index+1, digitChar);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
