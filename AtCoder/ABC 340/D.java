import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        int[][] a = new int[n-1][3];
        for(int i=0;i<n-1;i++){
            a[i] = fs.readIntArray(3);
            a[i][2]--;
        }
        long[] ans = new long[n];
        Arrays.fill(ans,Long.MAX_VALUE);
        TreeSet<long[]> set = new TreeSet<>((i,j)->{
            if(i[1] != j[1])return Long.compare(i[1],j[1]);
            return Long.compare(i[0],j[0]);
        });
        set.add(new long[]{0,0});
        while(!set.isEmpty()){
            long[] x = set.pollFirst();
            int in = (int)x[0];
            long val = x[1];
            if(ans[in] <= val)continue;
            ans[in] = val;
            if(in == n -1)continue;
            if(ans[in+1] > val+a[in][0])set.add(new long[]{in+1,val+a[in][0]});
            if(ans[a[in][2]] > val+a[in][1])set.add(new long[]{a[in][2],val+a[in][1]});
        }
        out.println(ans[n-1]);
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
