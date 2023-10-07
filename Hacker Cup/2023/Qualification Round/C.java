package HackerCup.Qualification.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static boolean valid(int[] a,long val,int left,int right){
        while(left <= right){
            if((long)a[left]+a[right] != val){
                return false;
            }
            left++;right--;
        }
        return true;
    }
    static long fun(int[] a,int n,long val){
        int m = n*2-1;
        //out.println(val);
        for(int i=0,j=m-1;i<j;i++,j--){
            if((long)a[i]+a[j] != val){
                boolean f = valid(a,val,i,j-1);
                if(f){
                    return val - a[j];
                }
                boolean s = valid(a,val,i+1,j);
                if(s){
                    return val - a[i];
                }
                return -1;
            }
        }
        return val - a[n-1];
    }
    // 2 3 4 5 6
    static void output() {
        int n = fs.nextInt();
        int[] a = fs.readIntArray(n*2 - 1);
        sortA(a);
        if(n == 1){
            out.println(1);
            return;
        }
        long first = fun(a,n,a[0]+a[n*2-2]);
        long second = fun(a,n,a[1]+a[n*2-2]);
        long third = fun(a,n,a[0]+a[n*2-3]);
        List<Long> l = new ArrayList<>();
        if(first > 0)l.add(first);
        if(second > 0)l.add(second);
        if(third > 0)l.add(third);
       // out.println(l);
        Collections.sort(l);
        if(l.isEmpty()){
            out.println(-1);
        }else{
            out.println(l.get(0));
        }
    }

    public static void main(String[] args) {

        int T = 1;
        T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            out.print("Case #"+(tt+1)+": ");
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

