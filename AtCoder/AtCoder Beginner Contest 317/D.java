import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static long rec(int level,int totalSeats,int[][] a,Map<Integer,Map<Integer,Long>> m){
        if(totalSeats > 0)return 0;
        if(a.length == level){
            return 1_000_000_000_00l;
        }
        if(m.get(level).containsKey(totalSeats))return m.get(level).get(totalSeats);
        if(a[level][0] > a[level][1]){
            long ans = rec(level+1,totalSeats,a,m);
            m.get(level).put(totalSeats,ans);
            return ans;
        }
        long take = (a[level][1] - a[level][0]+1)/2 + rec(level+1,totalSeats+a[level][2],a,m);
        long notTake = rec(level+1,totalSeats,a,m);
        long ans = Math.min(take,notTake);
        m.get(level).put(totalSeats,ans);
        return ans;
    }
    static void output() {
        int n = fs.nextInt();
        int[][] a = new int[n][3];
        for(int i=0;i<n;i++){
            a[i] = fs.readIntArray(3);
        }
        Map<Integer,Map<Integer,Long>> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(i, new HashMap<>());
        }
        int totalSeats = 0;
        for(int[] i:a){
            if(i[0] > i[1]){
                totalSeats += i[2];
            }else{
                totalSeats -= i[2];
            }
        }

        out.println(totalSeats > 0?0:rec(0,totalSeats/2,a,m));
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
