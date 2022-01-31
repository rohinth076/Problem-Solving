/*
Question : https://leetcode.com/problems/richest-customer-wealth/
*/

class Solution {
    int sum(int[] a){
        int s = 0;
        for(int i:a)
            s += i;
        return s;
    }
    public int maximumWealth(int[][] a) {
        int max = 0;
        for(int[] i:a)
            max = Math.max(max,sum(i));
        return max;
    }
}
