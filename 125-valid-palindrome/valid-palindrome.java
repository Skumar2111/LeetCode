class Solution {
    public boolean isPalindrome(String s) {

        String str;
        str = s.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
       

        int left = 0;
        int right = str.length()-1;

        while(left <= right)
        {
            if(str.charAt(left) != str.charAt(right)) return false;
            else
            { 
                left++;
                right--;
            }


        }
        return true;
        
    }
}