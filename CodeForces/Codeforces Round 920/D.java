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

    static void output() {
        int n = fs.nextInt(),m = fs.nextInt();
        int[] a = fs.readIntArray(n);
        int[] b = fs.readIntArray(m);
        sortA(a);
        sortD(b);
        long ans = 0;
        for(int i=0,j=n-1,l=0,r=m-1;i<=j;){

            int[][] val = new int[4][2];
            for(int k=0;k<4;k++)val[k][1] = k;
            val[0][0] = Math.abs(a[i]-b[l]);
            val[1][0] = Math.abs(a[i]-b[r]);
            val[2][0] = Math.abs(a[j]-b[l]);
            val[3][0] = Math.abs(a[j]-b[r]);

            Arrays.sort(val,(ii,jj)->{
                return Integer.compare(ii[0],jj[0]);
            });
            switch (val[3][1]){
                case 0:
                    i++;
                    l++;
                    break;
                case 1:
                    i++;
                    r--;
                    break;
                case 2:
                    j--;
                    l++;
                    break;
                case 3:
                    j--;
                    r--;
                    break;
            }
//            out.println(val[3][0]+" "+val[3][1]);
            ans += val[3][0];
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
