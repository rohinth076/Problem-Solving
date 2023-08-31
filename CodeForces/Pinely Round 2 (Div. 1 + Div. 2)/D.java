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
        int n = fs.nextInt(),m = fs.nextInt();
        char[][] a = new char[n][m];
        int[][] row = new int[n][2],col = new int[m][2];
        for(int i=0;i<n;i++){
            a[i] = fs.next().toCharArray();
        }
        for(int i=0;i<n;i++){
            int count = 0,l=0;
            for(int j=0;j<m;j++){
                if(a[i][j] != '.'){
                    count++;
                    if(a[i][j] == 'U'){
                        l++;
                    }
                }

            }
            if(count%2 != 0){
                out.println(-1);
                return;
            }
            row[i][0] = row[i][1]= l/2;
        }
        for(int j=0;j<m;j++){
            int count = 0,U=0;
            for(int i=0;i<n;i++){
                if(a[i][j] != '.'){
                    count++;
                    if(a[i][j] == 'L'){
                        U++;
                    }
                }
            }
            if(count%2 != 0){
                out.println(-1);
                return;
            }
            col[j][0] = col[j][1]= U/2;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] == 'U'){
                    if(row[i][0] != 0){
                        a[i][j] = 'W';
                        a[i+1][j] = 'B';
                        row[i][0]--;
                        //row[i+1][1]--;
                    }else{
                        a[i][j] = 'B';
                        a[i+1][j] = 'W';
                        row[i][1]--;
                        //row[i+1][0]--;
                    }
                }
            }
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(a[i][j] == 'L'){
                    if(col[j][0] != 0){
                        a[i][j] = 'W';
                        a[i][j+1] = 'B';
                        col[j][0]--;
                        //col[j+1][1]--;
                    }else {
                        a[i][j] = 'B';
                        a[i][j + 1] = 'W';
                        col[j][1]--;
                        //col[j+1][0]--;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            out.println(new String(a[i]));
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