import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static String a;
    static int n,len;
    static String b[][];
    static int[][] dp;
    static final int max = 10000;
    static boolean[][] hasCache;

    static boolean contains(int i,String c){
        int m = c.length();
        if(i+m > len)return false;
        for(int j=0;j<m;j++){
            if(a.charAt(i+j) != c.charAt(j)){
                return false;
            }
        }
        return true;
    }
    static int rec(int level,int in){
        if(level == len)return 0;
        if(in == n)return max;
        if(hasCache[level][in])return dp[level][in];

        int ans = rec(level,in+1);
        for(String i:b[in]){
            if(contains(level,i)){
                int val = rec(level+i.length(),in+1);
                if(val != max){
                    ans = Math.min(ans,1+val);
                }
            }
        }
        hasCache[level][in] = true;
        dp[level][in] = ans;
        return ans;
    }
    static void output() {
        a = fs.nextLine();
        len = a.length();
        n = fs.nextInt();
        b = new String[n][];
        for(int i=0;i<n;i++){
            int m = fs.nextInt();
            b[i] = new String[m];
            for(int j=0;j<m;j++){
                b[i][j] = fs.next();
            }
        }
        dp = new int[len][n];
        hasCache = new boolean[len][n];
        int val = rec(0,0);
        if(val == max)val = -1;
        out.println(val);
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
