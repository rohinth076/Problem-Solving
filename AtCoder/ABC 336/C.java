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
    static List<Long> l,value,sum;
    static int size;
    static long rec(long val){
        int in = 0;
        for(in = 0;in<size;in++){
            if(val < l.get(in)){
                in--;
                break;
            }
        }
       // out.println(in);
        if(in == -1){
            return 2*(val);
        }
        long rem = val - l.get(in);
        //out.println(rem);
        return value.get(in)+(rem != 0?rec(rem-1)+sum.get(in):0);
    }
    static void output() {
        long n = fs.nextLong();
        if(n == 1){
            out.println(0);
            return;
        }
        l = new ArrayList<>();
        value = new ArrayList<>();
        sum = new ArrayList<>();
        long val = 1,x=8;
        String y = "12";
       // l.add(val);
        for(int i=1;i<=18;i++){
            val*=5;
            l.add(val-1);
            value.add(x);
            sum.add(Long.valueOf(y));
            y = "1"+y;
            x = x*10+8;
        }
        //l.set(0,4l);
        //sum.set(0,2l);
        size = l.size();
//        out.println(l);
//        out.println(value);
//        out.println(sum);
//        for(int i=1;i<=n-1;i++)
//             out.println(i+" "+rec(i));
        out.println(rec(n-1));
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
