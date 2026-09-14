class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.equals(t)) 
        {return true;}
        else if(s.length() != t.length())
        {
           return false;
        }

        int[] stringHash = new int[26];

        for(int i = 0 ; i < s.length() ; i++)
        {
            stringHash[s.charAt(i) - 'a']++;

            stringHash[t.charAt(i) - 'a']--;
        }

        int sum = 0;
        for(int count : stringHash)
        {
            if(count != 0)
            {
                return false;
            }
        }
       
    return true;
    }
}