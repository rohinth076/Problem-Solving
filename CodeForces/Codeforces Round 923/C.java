import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt(),m = fs.nextInt(),k = fs.nextInt();
        int remA = k/2,remB = k/2;
        Set<Integer> a = new HashSet<>(),b = new HashSet<>(),ans = new HashSet<>();
        for(int i=0;i<n;i++)a.add(fs.nextInt());
        for(int i=0;i<m;i++)b.add(fs.nextInt());
        for(int i:a){
            if(remA != 0 && i <= k && !b.contains(i)){
                ans.add(i);
                remA--;
            }
        }
        for(int i:b){
            if(remB != 0 && i <= k && !a.contains(i)){
                ans.add(i);
                remB--;
            }
        }
        for(int i=1;i<=k;i++){
            if(!ans.contains(i)){
                boolean aCon = a.contains(i),bCon = b.contains(i);
                if(aCon && bCon){
                    if(remA > remB){
                        remA--;
                        ans.add(i);
                    }else{
                        remB--;
                        ans.add(i);
                    }
                }else if(aCon){
                    remA--;
                    ans.add(i);
                }else if(bCon){
                    remB--;
                    ans.add(i);
                }
            }
        }
        if(ans.size() == k && remA == 0 &&  remB == 0){
            out.println("Yes");
        }else{
            out.println("No");
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
