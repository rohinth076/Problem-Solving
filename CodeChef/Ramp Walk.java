/*
Question : https://www.codechef.com/CDKR2022/problems/RAMPUP
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
       int n = fs.nextInt();
       int[] a = fs.readArray(n);
       int ans = 0;
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               int c = 2,prev = a[i],cur = a[j],dif = cur-prev;
               while(Arrays.binarySearch(a,cur+dif) >= 0){
                   int t = cur+dif;
                   prev = cur;
                   cur = t;
                   c++;
               }
               ans = Math.max(c,ans);
           }
       }
       if(n <= 2)
          ans = n;
       out.println(ans);
        
       
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
