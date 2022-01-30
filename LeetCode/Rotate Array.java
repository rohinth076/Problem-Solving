/*
Question : https://leetcode.com/problems/rotate-array/
*/

class Solution {
    void rotate(int[] a,int s ,int e){
        for(int i=s,j=e-1;i<j;i++,j--){
            int c = a[i];
            a[i] = a[j];
            a[j] = c;
        }
    }
    public void rotate(int[] a, int k) {
        int n = a.length;
        k = k%n;
        rotate(a,0,n);
        rotate(a,0,k);
        rotate(a,k,n);
    }
}
