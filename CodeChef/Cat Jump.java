/*
Question : https://www.codechef.com/CDKR2022/problems/CATJUMP
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
       int[] a = fs.readArray(n);
       int[] dp = new int[n];
       dp[n-1] = 0;
       for(int i=n-2;i>=0;i--){
           int min = Integer.MAX_VALUE;
           int size = Math.min(n,i+k+1);
           for(int j=i+1;j<size;j++)
              min = Math.min(min,Math.abs(a[i]-a[j])+dp[j]);
           dp[i] = min;
       }
       //out.println(Arrays.toString(dp));
       out.println(dp[0]);
         
        
       
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
