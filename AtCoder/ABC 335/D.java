import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    public static int[][] spiralOrder(List<Integer> l,int n) {
        int[][] a = new int[n][n];
        int r = a.length;
        int c = a[0].length;
        int i=0,j=0;
        int cur = 0;
        while(i<r && j<c){
            for(int k=j;k<c;k++)
                a[i][k] = l.get(cur++);
            i++;
            for(int k=i;k<r;k++)
                a[k][c-1] = l.get(cur++);
            c--;
            if(i<r){
                for(int k=c-1;k>=j;k--)
                    a[r-1][k] = l.get(cur++);
                r--;
            }
            if(j<c){
                for(int k=r-1;k>=i;k--)
                    a[k][j] = l.get(cur++);
                j++;
            }
        }
        return a;
    }
    static void output() {
        int n = fs.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<=n*n;i++){
            l.add(i);
        }
        int[][] a = spiralOrder(l,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j && i == n/2){
                    out.print("T ");
                }else{
                    out.print(a[i][j]+" ");
                }
            }
            out.println();
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
