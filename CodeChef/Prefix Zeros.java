

/*
* Question : https://www.codechef.com/LTIME104B/problems/PREZ
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
        char[] a = fs.next().toCharArray();
        int[] aa = new int[n];
        for(int i=0;i<n;i++)
            aa[i] = (a[i] -'0');
        int ans = 0;
        int l = 0,r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int c = 0;
            int[] b = aa.clone();
            for(int i=mid;i>=0;i--){
                if((b[i]+c)%10 == 0  || (i ==mid && b[i] == 0))continue;
                b[i] += c;
                b[i] = b[i]%10;
                c += (10-b[i]);
                if(c > k)break;
            }
            if(c <= k){
                ans = mid+1;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        out.println(ans);
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
