/*
Question : https://leetcode.com/problems/4sum-ii/
*/

class Solution {
    Map<Integer,Integer> fun(int[] a,int[] b){
       Map<Integer,Integer> m = new HashMap<>();
        for(int i:a){
            for(int j:b)
                m.merge(i+j,1,Integer::sum);
        }
        return m;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> m1 = fun(nums1,nums2);
        Map<Integer,Integer> m2 = fun(nums3,nums4);
        int ans = 0;
        for(Map.Entry<Integer,Integer> i:m1.entrySet()){
            int k1 = i.getValue();
            int k2 = m2.getOrDefault(-i.getKey(),0);
            ans += (k1*k2);
        }
        return ans;
    }
}
