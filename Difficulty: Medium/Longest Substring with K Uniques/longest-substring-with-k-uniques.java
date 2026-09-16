class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        Map <Character, Integer>  map = new HashMap<>();
        int maxLen=-1;
        
        int l=0, r=0;
        
        while(r<n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            if(map.size()==k){
                maxLen=Math.max(r-l+1, maxLen);
            }
            while(map.size() > k){
                char x = s.charAt(l);
                map.put(x, map.get(x)-1);
                
                if(map.get(x)==0) map.remove(x);
                l++;
            }
            r++;
        }
        return maxLen;
    }
}