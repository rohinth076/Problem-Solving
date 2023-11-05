import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    /*
    * 5
    * 12345
    * 0 -> 15
    * 1 -> 13
    * 2 -> 9
    * 3 -> 3
    * a[5][0][15]++;
    * a[5][1][sum]
    * */
    static void output() {
        int[][][] a = new int[7][7][100];
        int n = fs.nextInt();
        char[][] b = new char[n][];
        for(int i=0;i<n;i++){
            b[i] = fs.next().toCharArray();
        }
        for(char[] i:b){
            int len = i.length;
            int rsum = 0,lsum = 0;
            for(char j:i){
                rsum += (j-'0');
            }
            a[len][0][rsum]++;
            for(int j=0;j<len;j++){
                rsum -= (i[j] - '0');
                lsum += (i[j] - '0');
                if(rsum >= lsum){
                    a[len][j+1][rsum - lsum]++;
                }
            }
        }
        long ans = 0;

        for(char[] i:b){
            int len = i.length;
            int[] c = new int[len],d = new int[len];
            int sum = 0;
            for(int j=0;j<len;j++){
                sum += (i[j] - '0');
                c[j] = sum;
            }
            sum = 0;
            for(int j=len-1;j>=0;j--){
                sum += (i[j] - '0');
                d[j] = sum;
            }
            if(len%2 == 0){
                switch (len){
                    case 2:
                        ans += a[2][0][c[1]];
                        ans += a[4][1][c[1]];
                        break;
                    case 4:
                        if(c[2] >= d[3]){
                            ans += a[2][0][c[2] - d[3]];
                        }
                        ans += a[4][0][c[3]];
                        break;
                }
            }else{
                switch (len){
                    case 1:
                        ans += a[1][0][c[0]];
                        //out.println("one::"+ans);
                        ans += a[3][1][c[0]];
                        //out.println("three::"+ans);
                        ans += a[5][2][c[0]];
                        //out.println("five::"+ans);
                        break;
                    case 3:
                        if(c[1] >= d[2]){
                            ans += a[1][0][c[1] - d[2]];
                        }
                        ans += a[3][0][c[2]];
                        ans += a[5][1][c[2]];
                        break;
                    case 5:
                        if(c[2] >= d[3]){
                            ans += a[1][0][c[2] - d[3]];
                        }
                        if(c[3] >= d[4]){
                            ans += a[3][0][c[3] - d[4]];
                        }
                        ans += a[5][0][c[4]];
                        break;
                }
            }
            //out.println(ans);
        }
        out.println(ans);
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
