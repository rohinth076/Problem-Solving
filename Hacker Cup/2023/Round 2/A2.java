

import HackerCup.Round2.A1.A1;

import java.io.*;
import java.util.*;

public class A2 {
    static A1.QuickReader fs = new A1.QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Answer{
        List<int[]> l;
        Answer(){
            l = new ArrayList<>();
        }
        void add(int i,int j){
            l.add(new int[]{i,j});
        }
        int size(){
            return l.size();
        }
        int[] getFirst(){
            return l.get(0);
        }
    }
    static int dir[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int dfs(char[][] a,int i,int j,int r,int c,boolean[][] visited,Answer ans){
        if(i < 0 || j < 0 || i>=r || j>=c)return 0;
        if(a[i][j] != 'W'){
            if(a[i][j] == '.' && !visited[i][j]){
                ans.add(i,j);
            }
            visited[i][j] = true;
            return 0;
        }
        visited[i][j] = true;
        a[i][j] = 'R';
        int count = 1;
        for(int[] k:dir){
            count += dfs(a,i+k[0],j+k[1],r,c,visited,ans);
        }
        return count;
    }
    static void output() {
        int r = fs.nextInt(),c = fs.nextInt();
        char[][] a = new char[r][c];
        for(int i=0;i<r;i++){
            a[i] = fs.next().toCharArray();
        }
        int zero = 0;
        int[][] ans = new int[r][c];
        int max = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == 'W'){
                    Answer ansObj = new Answer();
                    int count = dfs(a,i,j,r,c,new boolean[r][c],ansObj);
                    int size = ansObj.size();
                    if(size == 0){
                        zero += count;
                    }else if(size == 1){
                        int[] x = ansObj.getFirst();
                        ans[x[0]][x[1]] += count;
                        max = Math.max(max,ans[x[0]][x[1]]);
                    }
                }
            }
        }
        out.println(max+zero);
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

