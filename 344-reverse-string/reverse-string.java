class Solution {
    public void reverseString(char[] s) {
        
        int start = 0;
        int end = s.length - 1;
        
        reverseStringRecur(s, start , end);
      
    }
    
    public void reverseStringRecur(char[] s , int start , int end)
    {
        if(start >= end)
        {
            return;
        }
        
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        reverseStringRecur(s,start+1 , end -1);
        
    }
    
}