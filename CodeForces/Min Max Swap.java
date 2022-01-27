/*
Question : https://codeforces.com/contest/1631/problem/A
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class A{
    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static int max(int[] a){
        int max = a[0];
        for(int i:a){
            max = Math.max(i,max);
        }
        return max;
    }
    static void fun(int[] a,int[] b,int n){
        for(int i=0;i<n;i++)
            if(a[i] < b[i]){
                int c = a[i];
                a[i] = b[i];
                b[i] = c;
            }
    }
    static void output() {
        int n = fs.nextInt();
        int[] a = fs.readArray(n),b = fs.readArray(n);
        int f1 = max(a),f2 = max(b);
        if(f1 > f2){
            fun(a,b,n);
        }else{
            fun(b,a,n);
        }
        sort(a);sort(b);
        out.println(a[n-1]*b[n-1]);
    }

    public static void main(String[] args) {
        int T = 1;
        T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            output();
            out.flush();
        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
