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
    static class Trie{
        Trie[] child;
        int count;
        Trie(){
            child = new Trie[26];
            count =0;
        }
    }
    static void output() {
        int n = fs.nextInt();
        char[][] a = new char[n][];
        long ans = 0;

        for(int i=0;i<n;i++){
            a[i] = fs.next().toCharArray();

        }
        Trie root = new Trie();
        for(char[] i:a){
            long len = i.length;
            Trie p = root;
            for(int j=0;j<len;j++){
                int in = i[j] - 'a';
                if(p.child[in] == null){
                    p.child[in] = new Trie();
                }
                p = p.child[in];
                p.count++;
            }
            ans +=  2*len*n;
        }

        for(char[] i:a){
            int len = i.length;
            Trie p = root;
            long cur = 0;
            for(int j=len-1;j>=0;j--){
                int in = i[j] - 'a';
                p = p.child[in];
                if(p == null)break;
                cur += p.count;
                //out.println("inner "+ans);
            }
            ans -= cur*2;
            //out.println("output :"+ans);
        }
        out.println(ans);
    }

    public static void main(String[] args) {
        int T = 1;
       // T = fs.nextInt();
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
