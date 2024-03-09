import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node{
        int val;
        Node prev;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    static class LLinkedList{
        Node head;
        LLinkedList(){
            head = null;
        }
        void add(Node cur,Node newNode){
            Node next = cur.next;
            newNode.prev = cur;
            newNode.next = next;
            cur.next = newNode;
            if(next != null){
                next.prev = newNode;
            }
        }
        void remove(Node r){
            if(r == head){
                head = r.next;
                head.prev = null;
            }else{
                Node prev = r.prev,next = r.next;
                prev.next = next;
                if(next != null){
                    next.prev = prev;
                }
            }
        }
        void print(){
            Node temp = head;
            while(temp != null){
                out.print(temp.val+" ");
                temp = temp.next;
            }
        }
    }

    static void output() {
        int n = fs.nextInt();
        int[] a = fs.readIntArray(n);
        LLinkedList list = new LLinkedList();
        Map<Integer,Node> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(a[i],new Node(a[i]));
        }
        for(int i=0;i<n;i++){
            Node cur = map.get(a[i]);
            if(i != 0){
                cur.prev = map.get(a[i-1]);
            }
            if(i != n-1){
                cur.next = map.get(a[i+1]);
            }
        }
        list.head = map.get(a[0]);
        int q = fs.nextInt();
        for(int i=1;i<=q;i++){
            int type = fs.nextInt();
            if(type == 1){
                int x = fs.nextInt(),y = fs.nextInt();
                Node newNode = new Node(y);
                map.put(y,newNode);
                list.add(map.get(x),newNode);
            }else{
                int x = fs.nextInt();
                Node rem = map.remove(x);
                list.remove(rem);
            }
        }
        list.print();
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
