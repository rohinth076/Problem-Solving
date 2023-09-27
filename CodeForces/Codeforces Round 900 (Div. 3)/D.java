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
    static int search(int[][] a,int len,int target){
        int l = 0,r = len-1;
        int ans = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(a[mid][0] <= target && target <= a[mid][1]){
                return mid;
            }
            if(a[mid][0] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    static void output() {
        int n = fs.nextInt(),rlen = fs.nextInt();
        char[] a = fs.next().toCharArray();
        int[][] b = new int[rlen][2];
        for(int i=0;i<rlen;i++){
            b[i][0] = fs.nextInt()-1;
        }
        for(int i=0;i<rlen;i++){
            b[i][1] = fs.nextInt()-1;
        }
        int[] pre = new int[n+1];
        int q = fs.nextInt();
        for(int i=1;i<=q;i++){
            int x = fs.nextInt()-1;
            int in = search(b,rlen,x);
            int min = Math.min(x,b[in][0]+b[in][1]-x),max = Math.max(x,b[in][0]+b[in][1]-x);
            pre[min] += 1;
            pre[max+1] -= 1;
        }
        for(int i=1;i<n;i++){
            pre[i] += pre[i-1];
        }
        for(int[] i:b){
            for(int l=i[0],r = i[1];l<=r;l++,r--){
                if((pre[l]&1) == 1){
                    char ch = a[l];
                    a[l] = a[r];
                    a[r] = ch;
                }
            }
        }
        out.println(new String(a));
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
