import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void print(String s){
        out.println(s);
        out.flush();
    }
    static void output() {
        int n = fs.nextInt();
        int min = 1;
        while(Math.pow(2,min) <= n)min++;
        if(Math.pow(2,min-1) == n)min--;

        print(min+"");
        List<Integer> l[] = new List[min+1];
        for(int i=0;i<min+1;i++)l[i] = new ArrayList<>();
        for(int i=1;i<=n;i++){
           char[] a = Integer.toBinaryString(i).toCharArray();
           int len = a.length;
           for(int j=1;j<=len;j++){
               if(a[len-j] == '1'){
                   l[j-1].add(i);
               }
           }
        }
        for(int i=1;i<=min;i++){
            String ans = l[i-1].size()+" ";
            for(Integer j:l[i-1]){
                ans += j+" ";
            }
            print(ans);
        }
        String a = (new StringBuffer(fs.next()).reverse()).toString();
        if(a.indexOf('1') == -1){
            print(n+"");
        }else{
            print(Integer.parseInt(a,2)+"");
        }
    }
    /*
    * 1 3 5 7
    * 2 3 6 7
    * 4 5 6 7
    * */
    // 3 -> 1 2, 2 3 | 4 -> 1 2 , 2 3

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
