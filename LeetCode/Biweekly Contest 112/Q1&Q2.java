class Solution {
    public boolean canBeEqual(String s1, String s2) {
       int[] a = new int[26],b = new int[26];
        int n = s1.length();
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                a[s1.charAt(i) -'a']++;
                a[s2.charAt(i) -'a']--;
            }else{
                b[s1.charAt(i) -'a']++;
                b[s2.charAt(i) -'a']--;
            }
        }
        for(int i=0;i<26;i++){
            if(a[i] != 0 || b[i] != 0){
                return false;
            }
        }
        return true;
    }
}
