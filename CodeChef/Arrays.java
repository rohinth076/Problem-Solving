/*
Question : https://www.codechef.com/KCKS2022/problems/KICKST_01
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution{
    static QuickReader fs  = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static void output(){
        int n = fs.nextInt(),k = fs.nextInt();
        int[] a = fs.readIntArray(n);
        int ans = 1,j = 1;
        for(int i=0,l=1;j<=k && i<n;){
            if(a[i] != l){
                ans = l;
                j++;
            }else{
                i++;
            }
            l++;
        }
        if(j <= k){
            ans = (a[n-1]+ k - j);
        }
        out.println(ans);
    }
    public static void main(String[] args) {

        int T = 1;
       // T=fs.nextInt();
        for (int tt=0; tt<T; tt++) {
            output();
            out.flush();
        }
    }

    /* The template starts here */
    static void printArray(int[] a){
        for(int i:a)out.print(i+" ");
        out.println();
    }

    static void printlnArray(int[] a){
        for(int i:a)out.println(i);
    }

    static void printMatrix(int[][] a){
        for(int[] i:a)
            printArray(i);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class QuickReader {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readIntArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long[] readLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
