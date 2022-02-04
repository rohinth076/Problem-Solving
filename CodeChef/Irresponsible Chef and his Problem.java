/*
Question : https://www.codechef.com/CBND2022/problems/CHEFERR
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
        int n = fs.nextInt();
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            a[i] = fs.readIntArray(2);
        }
        int[] b = {0,0};
        boolean flag = true;
        for(int[] i:a){
            if(i[0] < b[0]){
                flag = false;
                break;
            }
            int d = i[0] - b[0];
            if(i[1] < b[1] || i[1] > b[1]+d){
                flag = false;
                break;
            }
            b = i;
        }
        if(!flag)out.println("NO");
        else{
            out.print("YES ");
            float s = (float)b[1] / b[0] * 100;
            if(s < 25)out.println("HARD");
            else if(s < 50)out.println("MEDIUM");
            else if(s < 75)out.println("EASY");
            else out.println("CAKEWALK");
        }
    }
    public static void main(String[] args) {

        int T = 1;
        T=fs.nextInt();
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
