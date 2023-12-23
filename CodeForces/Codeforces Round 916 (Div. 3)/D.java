import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int[][] read(int n){
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0] = fs.nextInt();
            a[i][1] = i;
        }
        Arrays.sort(a,(i,j)->j[0]-i[0]);
        return a;
    }
    static void output() {
        int n = fs.nextInt();
        int[][] a = read(n);
        int[][] b = read(n);
        int[][] c = read(n);
        long ans = 0;
        int len = Math.min(n,5);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(a[i][1] != b[j][1]){
                    for(int k=0;k<len;k++){
                        if(a[i][1] != c[k][1] && b[j][1] != c[k][1]){
                            long cur = a[i][0];
                            cur += b[j][0];
                            cur += c[k][0];
                            ans = Math.max(cur,ans);
                        }
                    }
                }

            }
        }
        out.println(ans);

    }

    public static void main(String[] args) {
        int T = 1;
        T = fs.nextInt();
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
