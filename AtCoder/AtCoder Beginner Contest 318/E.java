import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        int[] a = fs.readIntArray(n);
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> last  = new HashMap<>();
        Map<Integer,Long> prev = new HashMap<>();
        long ans = 0;
        for(int i=0;i<n;i++){
            if(count.containsKey(a[i])){
                int cnt = count.get(a[i]);
                int dif = i - last.get(a[i]) - 1;
                long p = prev.get(a[i]);
                p += ((long)cnt*dif);
                //out.println(dif+" "+p+" "+cnt);
                ans += p;
                //p += dif;
                last.put(a[i],i);
                count.put(a[i],cnt+1);
                prev.put(a[i],p);
            }else{
                last.put(a[i],i);
                count.put(a[i],1);
                prev.put(a[i],0l);
            }
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
