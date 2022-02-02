/*
Question : https://leetcode.com/problems/two-sum/
*/

class Solution {
    public int[] twoSum(int[] a, int t) {
        int n = a.length;
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int ch = t - a[i];
            if(map.containsKey(ch)){
                ans[0] = map.get(ch);
                ans[1] = i;
                break;
            }
            map.put(a[i],i);
        }
        return ans;
    }
}

