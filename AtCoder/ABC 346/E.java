import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int row = fs.nextInt(),col = fs.nextInt();
        int m = fs.nextInt();
        int[][] a = new int[m][3];
        for(int i=0;i<m;i++)a[i] = fs.readIntArray(3);
        Map<Long,Long> map = new TreeMap<>();
        long remRow = row,remCol = col;
        boolean[] visitedRow = new boolean[row+1];
        boolean[] visitedCol = new boolean[col+1];
        for(int i=m-1;i>=0;i--){
            if(a[i][0] == 1){
                if(!visitedRow[a[i][1]]){
                    map.merge((long)a[i][2],remCol,Long::sum);
                    visitedRow[a[i][1]] = true;
                    remRow--;
                }
            }else{
                if(!visitedCol[a[i][1]]){
                    map.merge((long)a[i][2],remRow,Long::sum);
                    visitedCol[a[i][1]] = true;
                    remCol--;
                }
            }
        }
        TreeSet<long[]> set = new TreeSet<>((i,j)->{
            return Long.compare(i[0],j[0]);
        });
        long zeroCount = (long)row*col;
        for(Map.Entry<Long,Long> i:map.entrySet()){
            long key = i.getKey();
            long value = i.getValue();
            if(key != 0 && value != 0){
                set.add(new long[]{key,value});
                zeroCount -= value;
            }
        }
        if(zeroCount != 0){
            set.add(new long[]{0l,zeroCount});
        }
        out.println(set.size());
        for(long[] i:set){
            out.println(i[0]+" "+i[1]);
        }
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
