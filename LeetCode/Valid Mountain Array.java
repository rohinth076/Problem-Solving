/*
Question URL : https://leetcode.com/problems/valid-mountain-array/
*/
class Solution {
    
    int findMax(int[] a,int n){
        int[] b = a.clone();
        Arrays.sort(b);
        int ans = 0;
        for(int i=0;i<n;i++)
            if(b[n-1] == a[i]){
                ans = i;
                break;
            }
        return ans;
    }
    public boolean validMountainArray(int[] a) {
        int n = a.length;
        if(n <= 2)return false;
        int maxIndex = findMax(a,n);
        if(maxIndex == 0 || maxIndex == n-1)return false;
        for(int i=0;i<maxIndex;i++)
            if(a[i] >= a[i+1])
                return false;
        for(int i=maxIndex;i<n-1;i++)
            if(a[i] <= a[i+1])
                return false;
        return true;
    }
}
