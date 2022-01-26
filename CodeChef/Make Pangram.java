/*
Question : https://www.codechef.com/CCMB2022/problems/MAKEPAN
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
       
       
       char[] a = fs.nextLine().toCharArray();
       boolean[] u = new boolean[26],l = new boolean[26];
       int c = 0;
       for(char i:a)
       if(i != ' '){
           if(Character.isLowerCase(i)){
               if(!l[i-'a'])c++;
               l[i-'a'] = true;
           }else{
               if(!u[i-'A'])c++;
               u[i-'A'] = true;
           }
       }
       if(c == 52){
           out.println("YES");
           return;
       }
       out.println("NO");
       for(int i=0;i<26;i++)
         if(!u[i]){
             out.print((char)(i+'A')+" ");
         }
        
       for(int i=0;i<26;i++)
         if(!l[i]){
             out.print((char)(i+'a')+" ");
         }
        out.println();
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
