import java.math.BigInteger;
class Solution {
    long mod = 1_000_000_000+7;
    void reverse(int[] a){
        for(int i=0,j=25;i<j;i++,j--){
            int c = a[i];
            a[i] = a[j];
            a[j] = c;
        }
    }
    int comb(int n,int r){
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(r).multiply(factorial(n - r));
        BigInteger result = numerator.divide(denominator);
        return result.mod(BigInteger.valueOf(mod)).intValue();
    }
    BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] a = new int[26];
        for(char i:s.toCharArray()){
            a[i-'a']++;
        }
        Arrays.sort(a);
        reverse(a);
        if(k > 26 || a[k-1] == 0){
            return 0;
        }
        int end = k-1;
        for(int i=k;i<26;i++){
            if(a[i] == a[k-1]){
                end++;
            }else{
                break;
            }
        }
        Map<Integer,Integer> m = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>((i,j)->j-i);
        for(int i=0;i<=end;i++){
            m.merge(a[i],1,Integer::sum);
            set.add(a[i]);
        }
        long ans = 1;
        int rem= k;
        for(Integer i:set){
            int x = m.get(i);
            int key = i;
            if(key == a[k-1]){
                long val = comb(x,rem);
                //System.out.println(x+" "+rem+" "+val);
                ans *= val;
                ans %= mod;
                
                for(int j=1;j<=rem;j++){
                    ans *= key;
                    ans %= mod;
                }
            }else{
                for(int j=1;j<=x;j++){
                    ans *= key;
                    ans %= mod;
                }
            }
            rem -= x;
        }
        return (int)ans;
    }
}
