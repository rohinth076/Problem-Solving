import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static long dfs(List<List<int[]>> l,int cur,boolean[] visited){
        long ans = 0;
        visited[cur] = true;
        for(int[] i:l.get(cur)){
            if(!visited[i[0]]){
                ans = Math.max(ans,i[1]+dfs(l,i[0],visited));
            }
        }
        visited[cur] = false;
        return ans;
    }
    static void output() {
        int n = fs.nextInt(),m = fs.nextInt();
        List<List<int[]>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=1;i<=m;i++){
            int u = fs.nextInt()-1,v = fs.nextInt()-1,w = fs.nextInt();
            l.get(u).add(new int[]{v,w});
            l.get(v).add(new int[]{u,w});
        }
        long ans = 0;

        for(int i=0;i<n;i++){
            ans = Math.max(ans,dfs(l,i,new boolean[n]));
        }
        out.println(ans);
    }

    public static void main(String[] args) {
        int T = 1;
       // T = fs.nextInt();
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
