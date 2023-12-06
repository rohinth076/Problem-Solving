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
    static int[] check(int[] a,int[] b){
        int[] ans = new int[]{-1,-1};
        if(a[1] < b[0] || b[1] < a[0]){
            return ans;
        }
        ans[0] = Math.max(a[0],b[0]);
        ans[1] = Math.min(a[1],b[1]);
        return ans;
    }
    static boolean isValid(int[][] a,int val){
        int[] point = new int[]{0,0};
        for(int[] i:a){
            point[0] -= val;
            point[0] = Math.max(0,point[0]);
            point[1] += val;
            int[] b = check(i,point);
            if(b[0] == -1 && b[1] == -1)return false;
            point = b;
        }
        return true;
    }
    static void output() {
        int n = fs.nextInt();
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            a[i] = fs.readIntArray(2);
        }
        int left = 0,right = 1_000_000_000;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isValid(a,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        out.println(ans);
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
