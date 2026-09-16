class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, maxLen=0, maxFreq=0;
        int n = s.length();
        int[] freq = new int[26];

        for(int r=0; r<n; r++){
            char ch = s.charAt(r);

            freq[ch-'A']++;

            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            while((r-l+1)-maxFreq >k ){
                char x = s.charAt(l);
                freq[x-'A']--;
                l++;
            }

            maxLen = Math.max(r-l+1, maxLen);
        }
        
        return maxLen;
    }
}