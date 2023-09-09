import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        int x = fs.nextInt(),y = fs.nextInt();
        int[][] a = new int[n-1][2];
        for(int i=0;i<n-1;i++){
            a[i] = fs.readIntArray(2);
        }
        long[] ans = new long[840];
        for(int i=0;i<840;i++){
            long sum = i;
            for(int[] j:a){
                long dif = sum%j[0];
                if(dif != 0){
                    dif = j[0] - dif;
                }
                sum += j[1] + dif;
            }
            ans[i] = sum;
        }
        int q = fs.nextInt();
        //out.println(Arrays.toString(ans));
        for(int i=1;i<=q;i++){
            int val = fs.nextInt();
            long finalAns = ans[(val+x)%840]+y + x+val;
            //finalAns -= Math.min(840,val+x);
            finalAns -= ((val+x)%840);
            out.println(finalAns);
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
