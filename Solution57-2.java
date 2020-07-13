class Solution {
    public String reverseWords(String s) {
        String[] sArray = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sArray.length - 1; i >= 0; i--) {
            if (sArray[i].equals("")) {
                continue;
            }
            sb.append(sArray[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}