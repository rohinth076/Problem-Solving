/*
Question : https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
*/

class Solution {
    public int lenLongestFibSubseq(int[] a) {
        int max = 0;
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int c = 2,cur = a[j],prev = a[i];
                while(Arrays.binarySearch(a,prev+cur) >= 0){
                    c++;
                    int next = prev+cur;
                    prev = cur;
                    cur = next;
                }
                if(c != 2)max = Math.max(c,max);
            }
        }
        return max;
    }
}
