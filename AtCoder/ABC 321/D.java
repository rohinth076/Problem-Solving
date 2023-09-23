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
    static int search(long[] c,long tar,int n){
        int left = 0,right = n-1;
        int ans = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(c[mid] <= tar){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return ans;
    }
    static void output() {
        int n = fs.nextInt(),m  = fs.nextInt();
        long p = fs.nextLong();
        long[] a = fs.readLongArray(n),b = fs.readLongArray(m);
        Arrays.sort(b);
        long[] c = b.clone();
        for(int i=1;i<m;i++){
            b[i] += b[i-1];
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            long val = p - a[i];
            int in = search(c,val,m);
            //out.println(val+" "+in);
            if(in == -1){
                ans += (p*m);
            }else{
                ans += b[in];
                ans += (p*(m-in-1));
                ans += (a[i]*(in+1));
            }
            //out.println(val+" "+in+" "+ans);
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
