import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        char[] a = fs.nextLine().toCharArray();
        long[] arr = fs.readLongArray(n);
        long ans = 0;
        long[] prefixZero = new long[n],prefixOne = new long[n];
        long[] sufixZero = new long[n],sufixOne = new long[n];
        for(int i=0;i<n;i++){
            ans += arr[i];
            if(i%2 == 0){
                //zero
                if(a[i] == '1'){
                    prefixZero[i] += arr[i];
                }else{
                    prefixOne[i] += arr[i];
                }
            }else{
                if(a[i] != '1'){
                    prefixZero[i] += arr[i];
                }else{
                    prefixOne[i] += arr[i];
                }
            }
        }
        sufixZero = prefixZero.clone();
        sufixOne = prefixOne.clone();
        for(int i=1;i<n;i++){
            prefixOne[i] += prefixOne[i-1];
            prefixZero[i] += prefixZero[i-1];
        }
        for(int i=n-2;i>=0;i--){
            sufixZero[i] += sufixZero[i+1];
            sufixOne[i] += sufixOne[i+1];
        }
        for(int i=0;i<n-1;i++){
            //one
            {
                long val = 0;
                if(a[i] == '0')val += arr[i];
                if(a[i+1] == '0')val += arr[i+1];
                if(i%2 != 0){
                    if(i != 0){
                        val += prefixZero[i-1];
                    }
                    if(i+2 != n){
                        val += sufixOne[i+2];
                    }
                }else{
                    if(i != 0){
                        val += prefixOne[i-1];
                    }
                    if(i+2 != n){
                        val += sufixZero[i+2];
                    }
                }
                ans = Math.min(ans,val);
            }
            //zero
            {
                long val = 0;
                if(a[i] == '1')val += arr[i];
                if(a[i+1] == '1')val += arr[i+1];
                if(i%2 == 0){
                    if(i != 0){
                        val += prefixZero[i-1];
                    }
                    if(i+2 != n){
                        val += sufixOne[i+2];
                    }
                }else{
                    if(i != 0){
                        val += prefixOne[i-1];
                    }
                    if(i+2 != n){
                        val += sufixZero[i+2];
                    }
                }
                ans = Math.min(ans,val);
            }
        }
        out.println(ans);
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
