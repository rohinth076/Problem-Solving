import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
//    static int rec(char[] a,int l,int r,int[][] dp){
//        if(l > r){
//            return 0;
//        }
//        if(dp[l][r] != -1)return dp[l][r];
//        int notTake = rec(a,l+1,r,dp);
//        int take = 1;
//        while(a[l] != a[r]){
//            r--;
//        }
//        take += rec(a,l+1,r-1,dp) + ((l != r)?1:0);
//        dp[l][r] = Math.max(notTake,take);
//        return dp[l][r];
//    }
    static boolean isValid(String a){
        return a.equals((new StringBuilder(a).reverse().toString()));
    }
    static void output() {
        String a = fs.next();
        int n = a.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isValid(a.substring(i,j+1))){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) {
        int T = 1;
        //T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            output();
            out.flush();
        }
    }

    static void printArray(int[] a) {
        for (int i : a) out.print(i + " ");
        out.println();
    }

    static void printlnArray(int[] a) {
        for (int i : a) out.println(i);
    }

    static void printMatrix(int[][] a) {
        for (int[] i : a)
            printArray(i);
    }

    static void sortA(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static void sortD(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l, (i, j) -> j - i);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class QuickReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
