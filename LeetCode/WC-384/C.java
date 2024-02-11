class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] count = new int[26];
        int n = words.length;
        int[] len = new int[n];
        for(int i=0;i<n;i++){
            len[i] = words[i].length();
            for(char j:words[i].toCharArray()){
                count[j-'a']++;
            }
        }
        Arrays.sort(len);
        int ans = 0;
        for(int val:len){
            int[] clone = count.clone();
            int half = val/2;
            for(int i=0;i<26 && half != 0;i++){
                while(half != 0 && clone[i] > 1){
                    clone[i] -= 2;
                    half--;
                }
            }
            if(half != 0) continue;
            if(val %2 != 0){
                int in = -1;
                for(int i=0;i<26;i++){
                    if(clone[i] != 0){
                        in = i;
                        if(clone[i]%2 != 0){
                            break;
                        }
                    }
                }
                if(in == -1)continue;
                clone[in]--;
            }
            ans++;
            count = clone;
        }
        
        return ans;
        
    }
}
