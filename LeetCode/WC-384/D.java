class Solution {
    int[] ZAlgo(int[] a){
        int n = a.length;
        int[] Z = new int[n];
        int l = 0,r = 0;
        for(int i=1;i<n;i++){
            // Using already find Value
            if(r > i){
                Z[i] = Z[i-l];

                // Not to take unseen value
                if(i+Z[i] > r){
                    Z[i] = r-i;
                }
            }
            //Seeing new value
            while(i+Z[i] < n && a[Z[i]] ==a[i+Z[i]]){
                Z[i]++;
            }
            //Increasing the gab
            if(i+Z[i] > r){
                l = i;
                r = i+Z[i];
            }
        }
        
        return Z;
    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
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
        int[] merge = new int[n+k];
        for(int i=0;i<k;i++){
            merge[i] = pattern[i];
        }
        merge[k] = 5;// To ignore while finding z-index
        for(int i=0,j=k+1;i<n-1;i++,j++){
            merge[j] = a[i];
        }
        int[] Z = ZAlgo(merge);
        int count = 0;
        for(int i=k+1;i<n+k;i++){
            if(Z[i] >= k){
                count++;
            }
        }
        return count;
    }
}
