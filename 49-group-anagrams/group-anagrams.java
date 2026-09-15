class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,Integer> anagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++)
        {
            String hash = getHash(strs[i]);

            if(!anagramMap.containsKey(hash))
            {
                anagramMap.put(hash,result.size());
                result.add(new ArrayList<>());
            }


            result.get(anagramMap.get(hash)).add(strs[i]);
        }

        return result;
        
    }


    public String getHash(String string)
    {
        StringBuilder hash = new StringBuilder();
        int[] hashArray = new int[26];
        for(int i = 0 ; i < string.length() ; i++)
        {
            hashArray[string.charAt(i) - 'a'] ++;
        }

        for(int j = 0 ; j < 26 ; j++)
        {
            hash.append(hashArray[j]);
            hash.append("$");
        }

        return hash.toString();
    }
}