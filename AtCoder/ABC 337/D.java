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

    static void output() {
        int r = fs.nextInt(),c = fs.nextInt(),k = fs.nextInt();
        char[][] a = new char[r][];
        for(int i=0;i<r;i++)a[i] = fs.next().toCharArray();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<r;i++){
            for(int j=0,left=0,count = 0;j<c;j++){
                if(a[i][j] == 'x'){
                    count = 0;
                    left = j+1;
                }else{
                    if(a[i][j] == '.')count++;

                    while(j - left >= k){
                        if(a[i][left] == '.')count--;
                        left++;
                    }
                    if(j - left + 1 == k){
                        ans = Math.min(ans,count);
                    }
                }
            }
        }
        for(int j=0;j<c;j++){
            for(int i=0,top=0,count = 0;i<r;i++){
                if(a[i][j] == 'x'){
                    count = 0;
                    top = i+1;
                }else{
                    if(a[i][j] == '.')count++;

                    while(i - top >= k){
                        if(a[top][j] == '.')count--;
                        top++;
                    }
                    if(i - top + 1 == k){
                        ans = Math.min(ans,count);
                    }
                }
            }
        }

        if(ans == Integer.MAX_VALUE)ans = -1;
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
