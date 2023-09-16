import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int search(List<int[]> l,int size,int time){
        int in = -1;
        int left = 0,right = size-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(time <= l.get(mid)[0]){
                in = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return in;
    }
    static long rec(List<int[]> l){
        long ans = 0;
        int size = l.size();
        int time = 0;
        while(size != 0){
            int in = search(l,size,time);
            if(in == -1)break;
            int[] x = l.remove(in);
            ans += x[1];
            time = x[0]+x[2];
            size--;
        }
        return ans;
    }
    static void output() {
        int n = fs.nextInt(),m = fs.nextInt();
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<m;i++){
            l.add(fs.readIntArray(3));
        }
        for(int i=1;i<=n;i++){
            out.println(rec(l));
        }
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
