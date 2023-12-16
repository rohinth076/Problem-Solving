import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int dfs(List<List<Integer>> l,int cur,int par){
        int ans = 1;

        for(Integer i:l.get(cur)){
            if(i != par){
                ans += dfs(l,i,cur);
            }
        }
        return ans;
    }
    static void output() {
        int n = fs.nextInt();
        int ans = 0;
        List<List<Integer>> l = new ArrayList<>();
        for(int i=1;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=1;i<=n-1;i++){
            int u = fs.nextInt()-1,v = fs.nextInt()-1;
            l.get(u).add(v);
            l.get(v).add(u);
        }
        List<Integer> val = new ArrayList<>();
        ans = 1;
        for(Integer i:l.get(0)){
            int x = dfs(l,i,0);
            val.add(x);
        }
        Collections.sort(val);
        for(int i=0;i<val.size()-1;i++){
            ans += val.get(i);
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
