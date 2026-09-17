class Solution {
    public boolean isPalindrome(String s) {

        String str;
        str = s.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while(left <= right)
        {
            if(chars[left] != chars[right]) return false;
            else
            { 
                left++;
                right--;
            }


        }
        return true;
        
    }
}