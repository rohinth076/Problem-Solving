import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int h = fs.nextInt();
        int w = fs.nextInt();
        int xa = fs.nextInt(),ya = fs.nextInt();
        int xb = fs.nextInt(),yb = fs.nextInt();
        if(xa >= xb){
            out.println("Draw");
        }else{
            int dif = xb - xa;
            int mid = dif/2;
            if(dif%2 != 0){
                if(ya < yb || (ya == yb && w-yb > yb)){
                    int remW = Math.min(mid,w-yb);
                    int difY = mid+1;
                    if(yb+remW <= ya+difY){
                        out.println("Alice");
                    }else{
                        out.println("Draw");
                    }
                }else{
                    int remW = Math.min(mid,yb-1);
                    int difY = mid+1;
                    if(yb-remW >= ya-difY){
                        out.println("Alice");
                    }else{
                        out.println("Draw");
                    }
                }
            }else{
                if(ya > yb || (ya == yb && w-ya > ya)){
                    int remW = Math.min(mid,w-ya);
                    int difY = mid;
                    if(ya+remW <= yb+difY){
                        out.println("Bob");
                    }else{
                        out.println("Draw");
                    }
                }else{
                    int remW = Math.min(mid,ya-1);
                    int difY = mid;
                    if(ya-remW >= yb-difY){
                        out.println("Bob");
                    }else{
                        out.println("Draw");
                    }
                }
            }
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
