/*
Question : https://www.codechef.com/START23B/problems/MAXVAC
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution{
	static FastScanner fs  = new FastScanner();
	static PrintWriter out = new PrintWriter(System.out);
	static void output(){
       int n = fs.nextInt(),k = fs.nextInt();
       char[] a = fs.next().toCharArray();
       List<Integer> l = new ArrayList<>();
       char prev = '0';
       int c = 0;
       for(char i:a){
           if(prev == i){
               c++;
           }else{
               l.add(c);
               c = 1;
               prev = i;
           }
       }
       l.add(c);
       if(a[n-1] == '1')l.add(0);
       int size = l.size();
       int ans =0;
       for(int i=0;i<size;i+=2){
           ans += (l.get(i)/k);
       }
       //out.println(l+" "+ans);
       int max = ans;
       for(int i=1;i<size;i+=2){
           int p1 = l.get(i-1),p2 = l.get(i+1);
            if(l.get(i) == 1){
           int d = (p1/k) + (p2/k);
           max = Math.max(max,ans-(d)+((p1+p2+1)/k));
       }else{
           if(p1%k == k-1 || p2%k == k-1)max = Math.max(max,ans+1);
       }
       }
       out.println(max);
        
       
	}
	public static void main(String[] args) {
		
		int T = 1;
	    T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			output();
			out.flush();
		}
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
		String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
	}
}

