class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count=0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen,-1);

        int r=0;
        while(r<n){
            char ch = s.charAt(r);
            lastSeen[ch-'a']=r;
            if(lastSeen[0] !=  -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count= count+(1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
            r++;
        }
        return count;
    }
}
