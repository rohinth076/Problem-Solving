import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int r,c;
    static int[][] b;
    static char[][] a;
    static int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    static void dfs(int i,int j,int val){
        if(i < 0 || j < 0 || i >= r || j >= c || a[i][j] == '.' || b[i][j] != 0)return;
        b[i][j] = val;
        for(int[] x:dir){
            dfs(i+x[0],j+x[1],val);
        }
    }
    static long inv(int a,int m) {
        return a <= 1 ? a : m - (long)(m/a) * inv(m % a,m) % m;
    }
    static int fun(int i,int j){
        Set<Integer> s = new HashSet<>();
        for(int[] x:dir){
            int ni = i+x[0],nj = j+x[1];
            if(ni >=0 && ni< r && nj >=0 && nj < c && a[ni][nj] == '#'){
                s.add(b[ni][nj]);
            }
        }
        int size = s.size();
        if(size == 0)return 1;
        return -(size-1);
    }
    static void output() {
        r = fs.nextInt();
        c = fs.nextInt();
        a = new char[r][c];
        for(int i=0;i<r;i++){
            a[i] = fs.next().toCharArray();
        }
        b = new int[r][c];
        int count = 0;
        int len = 0;
        long total = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == '#' && b[i][j] == 0){
                    count++;
                    dfs(i,j,count);
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == '.'){
                    total += (count+fun(i,j));
                    len++;
                }
            }
        }
       // out.println(count+" "+total);

        long ans = 0;
        int mod = 998244353;
        if(len != 0){
            ans = ((total%mod) * (inv(len,mod))%mod)%mod;
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
