import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt(),m = fs.nextInt();
        List<List<int[]>> l = new ArrayList<>();
        boolean[] visited = new boolean[n];
        long[][] ans = new long[n][2];
        for(int i=1;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=1;i<=m;i++){
            int u = fs.nextInt()-1,v = fs.nextInt()-1,x = fs.nextInt(),y = fs.nextInt();
            l.get(u).add(new int[]{v,x,y});
            l.get(v).add(new int[]{u,-x,-y});
        }
        TreeSet<Integer> t = new TreeSet<>();
        t.add(0);
        visited[0] = true;
        while(!t.isEmpty()){
            int u = t.pollFirst();
            for(int[] i:l.get(u)){
                if(!visited[i[0]]){
                    int v = i[0],x = i[1],y = i[2];
                    visited[v] = true;
                    ans[v][0] = ans[u][0]+x;
                    ans[v][1] = ans[u][1]+y;
                    t.add(v);
                }
            }
        }
        for(int i=0;i<n;i++){
           if(visited[i]){
               out.println(ans[i][0]+" "+ans[i][1]);
           }else{
               out.println("undecidable");
           }
        }
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
