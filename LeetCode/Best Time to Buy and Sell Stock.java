/*
Question : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/


class Solution {
    public int maxProfit(int[] a) {
        
        int ans = 0,min = a[0];
        for(int i:a){
                min = Math.min(i,min);
                ans = Math.max(ans,i-min);
            }
        return ans;
    }
}
