import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        long[] a = fs.readLongArray(n);
        int bitLen = 60;
        int[] bit = new int[bitLen];
        for(long i:a){
            for(int j=0;j<bitLen;j++){
                if((i&(1l<<j)) != 0){
                    bit[j]++;
                }
            }
        }
        long ans = 0;
        for(int i=0;i<bitLen;i++){
            if(bit[i]%2 == 1){
                ans |= (1l<<i);
            }
        }
       // out.println(Arrays.toString(bit));
        for(long val:a){
            int[] bitClone = bit.clone();
            for(int j=0;j<bitLen;j++){
                if((val&(1l<<j)) != 0){
                    bitClone[j]--;
                }
            }
            long x = val;
            for(int j=bitLen-1;j>=0;j--){
                long curVal = 1l<<j;
                if(bitClone[j]%2 == 0 && curVal <= x){
                    x -= curVal;
                    bitClone[j]++;
                }
            }
            bitClone[0] += x;
            long cur = 0;
            for(int i=0;i<bitLen;i++){
                if(bitClone[i]%2 == 1){
                    cur |= (1l<<i);
                }
            }
            //out.println(cur);
            ans = Math.max(ans,cur);
        }
        //out.println("Test");
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
