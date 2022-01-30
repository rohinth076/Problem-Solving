/*
Question : https://leetcode.com/problems/keep-multiplying-found-values-by-two/
*/

class Solution {
    public int findFinalValue(int[] a, int t) {
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n;i++){
            if(a[i] == t)
                t = t*2;
        }
        return t;
    }
}
