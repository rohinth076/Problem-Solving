/*
Question : https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int max = Integer.MIN_VALUE,sum = 0;
        System.out.println(max);
        for(int i=0;i<n;i++){
            sum = Math.max(a[i],sum+a[i]);
            max = Math.max(sum,max);
        }
        return max;
    }
}
