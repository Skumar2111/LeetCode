class Solution {
    public int characterReplacement(String s, int k) {

        int[] frequency = new int[26];
        int left = 0 ;
        int right = 0;

        int maxLength = 0;
        int maxCount = 0;



        while(right < s.length())
        {
            frequency[s.charAt(right) - 'A']  ++;
            maxCount = Math.max(maxCount , frequency[s.charAt(right) - 'A']);

            if((right - left + 1) - maxCount > k)
            {
                frequency[s.charAt(left) - 'A'] --;
                left++;
            }

            maxLength = Math.max(maxLength , right - left +1);
            right++;

        }

        return maxLength;
    }
}