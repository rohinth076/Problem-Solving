/*
Question : https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
*/

class Solution {
    public List<Integer> maxScoreIndices(int[] a) {
        
        int n = a.length;
        int s1 = 0,s2 = 0;
        for(int i:a)
            s1 += i;
        int max = s1;
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i=0;i<n;i++){
            if(a[i] == 1)s1--;
            if(a[i] == 0)s2++;
            
            if(s1 + s2 > max){
                ans.clear();
                max = s1+s2;
            }
            if(s1 + s2 == max)ans.add(i+1);
        }
        return ans;
    }
}
