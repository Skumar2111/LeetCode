class Solution {
    public boolean checkInclusion(String s1, String s2) {
// Check if S1 > S2 return false without any check
        if(s1.length() > s2.length())
        {
            return false;
        }

        int[] s1Frequency = new int[26];
        int[] s2Frequency = new int[26];

        for(char c : s1.toCharArray())
        {
            s1Frequency[c - 'a']++;
        }

        int left = 0;

        for(int right = 0 ; right < s2.length(); right++)
        {
            s2Frequency[s2.charAt(right) - 'a'] ++;
        

        if(right - left + 1 > s1.length())
        {
            s2Frequency[s2.charAt(left) -'a'] --;
            left++;
        }

        if(Arrays.equals(s1Frequency,s2Frequency))
        {
            return true;
        }

        
    }

    return false;
}
}