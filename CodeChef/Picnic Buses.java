/*
Question : https://www.codechef.com/CCMB2022/problems/PICNICBUS
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
	static void dfs(LinkedList<Integer>[] l,int i,boolean[] visited){
	    if(visited[i])return;
	    visited[i] = true;
	    for(Integer j:l[i])
	        dfs(l,j,visited);
	}
	static void output(){
       int n = fs.nextInt(),m = fs.nextInt();
       LinkedList<Integer>[] l =new LinkedList[n+1];
       for(int i=0;i<n+1;i++)
          l[i] = new LinkedList<>();
       boolean[] visited = new boolean[n+1];
       for(int i=1;i<=m;i++){
           int xx = fs.nextInt(),yy = fs.nextInt();
           l[xx].add(yy);
           l[yy].add(yy);
       }
       int ans = 0;
       for(int i=1;i<=n;i++)
          if(!visited[i]){
              dfs(l,i,visited);
              ans++;
          }
        out.println(ans);
       
	}
	public static void main(String[] args) {
		
		int T = 1;
	    //T=fs.nextInt();
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
