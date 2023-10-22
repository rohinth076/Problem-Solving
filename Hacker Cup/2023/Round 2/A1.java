package HackerCup.Round2.A1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A1 {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int dir[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int dfs(char[][] a,int i,int j,int r,int c,boolean[][] visited){
        if(i < 0 || j < 0 || i>=r || j>=c)return 0;
        if(a[i][j] != 'W'){
            int val = 0;
            if(a[i][j] == '.' && !visited[i][j])val = 1;
            visited[i][j] = true;
            return val;
        }
        visited[i][j] = true;
        a[i][j] = 'R';
        int count = 0;
        for(int[] k:dir){
            count += dfs(a,i+k[0],j+k[1],r,c,visited);
        }
        return count;
    }
    static void output() {
        int r = fs.nextInt(),c = fs.nextInt();
        char[][] a = new char[r][c];
        for(int i=0;i<r;i++){
            a[i] = fs.next().toCharArray();
        }
        boolean flag = false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == 'W'){
                    int count = dfs(a,i,j,r,c,new boolean[r][c]);
                    if(count <= 1){
                        flag = true;
                        break;
                    }
                }
            }
        }
        out.println(flag?"YES":"NO");
    }

    public static void main(String[] args) {

        int T = 1;
        T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            out.print("Case #"+(tt+1)+": ");
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

