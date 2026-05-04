// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

class Solution {

    private char demiliter= '#';

    public String encode(List<String> strs) {

        StringBuilder strBuilder = new StringBuilder();
        for(String str : strs) {
            strBuilder.append(str.length()).append('#').append(str);
        }
        return strBuilder.toString();

    }

    public List<String> decode(String str) {

        List<String> output = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            int j=i;
            while(str.charAt(j)!= '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));
            i=j+1+length;
            output.add(str.substring(j+1, i));
            
        }
        return output;
    }
}
