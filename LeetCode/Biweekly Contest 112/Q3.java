class Solution {
    public long maxSum(List<Integer> nums, int lim, int k) {
        long ans = 0,sum = 0;
        int n = nums.size();
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0,j=0;i<n;i++){
            int val = nums.get(i);
            m.put(val,m.getOrDefault(val,0)+1);
            sum += val;
            if(i+1 >= k){
                int x = nums.get(j);
                if(lim <= m.size()){
                    ans = Math.max(ans,sum);
                }
                m.put(x,m.getOrDefault(x,0)-1);
                if(m.get(x) == 0){
                    m.remove(x);
                }
                sum -= x;
                j++;
            }
        }
        return ans;
    }
}
