import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int bitLen = 32;
    static boolean valid(int[] a,int[] b,int len,int k){
        long sum = 0;
        //out.println(Arrays.toString(a)+" "+Arrays.toString(b)+" "+len);
        for(int i=0;i<bitLen;i++){
            if(a[i] - b[i] == len){
                sum += (1<<i);
            }
        }
        //out.println(sum);
        return sum >= k;
    }
    static int search(int[][] a,int l,int r,int[] bit,int k){
        int ans = -2;
        int left = l;
        while(l <= r){
            int mid = l+(r-l)/2;
            //out.println(mid+" "+l);
            if(valid(a[mid],bit,mid-left+1,k)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans+1;
    }
    static void output() {
        int n = fs.nextInt();
        int[] a = fs.readIntArray(n);

        int[][] b = new int[n][bitLen];
        for(int i=0;i<n;i++){
//            char[] t = Integer.toBinaryString(a[i]).toCharArray();
//            int len = t.length;
//            for(int j=0,jj = len-1;j<len;j++,jj--){
//                b[i][j] = (t[jj]-'0');
//            }
            for(int j=0;j<bitLen;j++){
                if(((a[i]>>j)&1) == 1){
                    b[i][j] = 1;
                }
            }
           //out.println(a[i]+" "+Arrays.toString(b[i]));
        }// 1 0
        for(int i=1;i<n;i++){
            for(int j=0;j<bitLen;j++){
                b[i][j] += b[i-1][j];
            }
        }
        int q = fs.nextInt();
        for(int i=1;i<=q;i++){
            int r = fs.nextInt()-1,k = fs.nextInt();
            int[] bit = new int[bitLen];
            if(r != 0){
                bit = b[r-1];
            }
            int in = search(b,r,n-1,bit,k);
            out.print(in+" ");
        }
    }

    public static void main(String[] args) {
        int T = 1;
        T = fs.nextInt();
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
