class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int count = 0;
        int[] a = new int[n];
        for(int i=0;i<n-1;i++){
            int val = 0;
            if(nums[i] < nums[i+1]){
                val = 1;
            }else if(nums[i] > nums[i+1]){
                val = -1;
            }
            a[i] = val;
        }
        int k = pattern.length;
        //System.out.println(Arrays.toString(a));
        outer:for(int i=0;i<n-k;i++){
            for(int j=0;j<k;j++){
                if(a[i+j] != pattern[j]){
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }// 1 2 3 4 5 6
}
