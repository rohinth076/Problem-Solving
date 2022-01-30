/*
Question : https://atcoder.jp/contests/abc237/tasks/abc237_d
*/

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
    static class LList{
        int data;
        LList next;
        LList prev;
        LList(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
    static void output() {

            int n = fs.nextInt();
            LList root = new LList(0);
            char[] a = fs.next().toCharArray();
            LList t = root;
            for(int i=0;i<n;i++){
                LList xx = new LList(i+1);
                if(a[i] == 'L'){
                    if(t == root){
                        t.prev = xx;
                        xx.next = t;
                        root = xx;
                    }else{
                        LList p = t.prev;
                        t.prev = xx;
                        xx.next = t;
                        xx.prev = p;
                        p.next = xx;
                    }
                }else{
                    LList p = t.next;
                    t.next = xx;
                    xx.prev = t;
                    xx.next = p;
                    if(p != null)p.prev = xx;
                }
                t = xx;

            }
            LList temp = root;
            while(temp != null){
                out.print(temp.data+" ");
                temp = temp.next;
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

