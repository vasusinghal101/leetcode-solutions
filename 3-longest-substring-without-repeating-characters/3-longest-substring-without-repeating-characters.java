class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //no match
            if(!hs.contains(ch)){
                hs.add(ch);
                ans= Math.max(ans,hs.size());
            }else{
                int j = i - hs.size();
                while(ch!=s.charAt(j)){
                    hs.remove(s.charAt(j));
                    j++;
                }
            }
        }
        
        return ans;
    }
}