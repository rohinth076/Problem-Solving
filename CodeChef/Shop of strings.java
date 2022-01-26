/*
Quetion Link : https://www.codechef.com/CTS32022/problems/CTSL35
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
	static boolean isVowel(char a){
	    return a == 'a' || a == 'e' || 
	    a == 'i' || a == 'o' || a == 'u';
	}
	static boolean isBeautiful(char[] a){
	    int n = a.length;
	    Map<Character,Integer> m = new HashMap<>();
	    boolean f = isVowel(a[n-1]);
	    
	    if(n%2 == 0 && !f)return false;
	    if(n%2 != 0 && f)return false;
	    for(char i:a)
	        m.merge(i,1,Integer::sum);
	    int odd = 0;
	    for(Map.Entry<Character,Integer> i:m.entrySet()){
	        int v = i.getValue();
	        if(v > 2)return false;
	        if(v%2 != 0)odd++;
	    }
	    return odd <= 1;
	}
	static boolean isSuperBeautiful(String a){
	    return a.indexOf("a") < 0 && a.indexOf("b") < 0 
	    && a.indexOf("c") < 0 && a.indexOf("x") < 0 && a.indexOf("y") < 0 
	    && a.indexOf("z") < 0;
	}
	static void output(){
       int n = fs.nextInt();
       Map<String,Boolean> m = new HashMap<>();
       String[] a = new String[n];
       for(int i=0;i<n;i++){
           a[i] = fs.next();
           m.put(a[i],true);
       }
       for(int i=0;i<n;i++)
          if(m.get(a[i]) && isBeautiful(a[i].toCharArray())){
              out.print(i);
              if(isSuperBeautiful(a[i]))out.print("*");
              out.print(" ");
              m.put(a[i],false);
          }
        
       
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
