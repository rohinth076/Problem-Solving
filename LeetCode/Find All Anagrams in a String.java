/*
Question : https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(char i:p.toCharArray())
            b[i-97]++;
        int n = s.length();
        int m = p.length();
        List<Integer> l = new ArrayList<>();
        if(m>n)return l;
        for(int i=0;i<m-1;i++)
            a[s.charAt(i)-97]++;
        int c = 0;
        for(int i=m-1;i<n;i++){
            a[s.charAt(i)-97]++;
            if(Arrays.equals(a,b))
                l.add(i-m+1);
            a[s.charAt(i-m+1)-97]--;
        }
        
        return l;
    }
}
