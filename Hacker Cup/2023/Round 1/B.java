

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);
//    static List<Integer> ans,div,tans;
//    static boolean flag;
//    static int size;
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

//    static void fun(int n,int sum,int index){
//        if(sum == 0 && n == 1){
//            ans = tans;
//            flag = true;
//            return;
//        }
//        if(sum <= 0 || index >= size){
//            return;
//        }
//        fun(n,sum,index+1);
//        if(flag){
//            return;
//        }
//        int temp = n,tsum = sum;
//        int val = div.get(index);
//        int tsize = tans.size();
//        while(temp%val == 0 && tsum > 0){
//            tans.add(val);
//            tsum -= val;
//            temp /= val;
//            fun(temp,tsum,index+1);
//            if(flag){
//                break;
//            }
//        }
//        tans = tans.subList(0,tsize);
//    }
    static void output() {
        int n = fs.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<=41;i++){
            if(n%i == 0){
                l.add(i);
            }
        }
//        ans = new ArrayList<>();
//        div = l;
//        size = l.size();
//        tans = new ArrayList<>();
//        flag = false;
//        fun(n,41,0);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),l.stream().mapToInt(j -> j).toArray(),41,0);
        Collections.sort(list,(i,j)->i.size() - j.size());
        for(List<Integer> i:list){
            long p = 1;
            for(Integer j:i){
                p *= j;
            }
            if(p == n){
                out.print(i.size()+" ");
                for(Integer j:i){
                    out.print(j+" ");

                }
                out.println();
                return;
            }
        }
        out.println(-1);
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

