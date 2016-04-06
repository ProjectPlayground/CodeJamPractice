import java.math.BigInteger;
import java.util.ArrayList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


public class FairAndSquare {
	static ArrayList<BigInteger> fs ;
	
	public static void main (String[] args){
		
		
		preCompute();
		/*Out out = new Out("FairAndSquareData.txt");
		for (BigInteger x:fs){
			out.println(x.toString());
    	}*/
		
		In in = new In(args[0]);      // input file
        int T = in.readInt();
        Out out = new Out("FairAndSquare.txt");
        for(int i=0;i<T;i++){
        	String a = in.readString();
        	BigInteger a1 = new BigInteger(a);
        	
        	String b = in.readString();
        	BigInteger b1 = new BigInteger(b);
        	int count =0;
        	for (BigInteger x:fs){
        		if ((x.compareTo(a1) >=0) && (x.compareTo(b1)<=0))
        			count++;
        	}
        	out.println("Case #"+(i+1)+": "+count);
        }
        
		
	}
	
	public static void preCompute(){
		fs = new ArrayList<BigInteger>();
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c;
		
		a.add("0");
		getFS("0");
		a.add("1");
		getFS("1");
		a.add("2");
		getFS("2");
		a.add("3");
		getFS("3");
		b.add("00");
		getFS("00");
		b.add("11");
		getFS("11");
		b.add("22");
		getFS("22");
		//b.add("33");
		//getFS("33");
		for(int i=3; i<=50;i++){
			c= new ArrayList<String>();
			for (int k=0;k<=2;k++){
				
				for(int x=0;x<a.size();x++){
					StringBuilder sb1 = new StringBuilder();
					sb1.append(Integer.toString(k));
					sb1.append(a.get(x));
					sb1.append(Integer.toString(k));
					//String t = Integer.toString(k) + a.get(x)+Integer.toString(k);
					//System.out.println(sb1.toString());
					if (!isSumofSquareMoreThanNine(sb1.toString())){
						c.add(sb1.toString());
						getFS(sb1.toString());
					}
				}
				
			}
			
			a =b;
			b =c;
			
		}
		
		
	}
	
	public static void getFS(String s){
		//long x = Long.parseLong(s,10);
		
			
			BigInteger x1 = new BigInteger(s); 
			try{
				int i = x1.intValueExact();
				if (i==0) return;
			}catch(Exception e){
				
			}
			BigInteger y1 = x1.multiply(x1);
			//long y = x*x;
			
				String s1 = y1.toString();
				if (isPalindrome(s1) && !fs.contains(s1))
					fs.add(new BigInteger(s1));
		
		
	}
	
	public static boolean isPalindrome(String s){
		int l = s.length()-1;
		for (int i=0;  i<(s.length()/2) ; i++){
			if (s.charAt(i) != s.charAt(l))
				return false;
			l--;
		}
		return true;
	}
	
	//check if sum of square of each digit is more than 9
	
	public static boolean isSumofSquareMoreThanNine(String s){
		int sum =0; int n=0;
		for (int i=0; i<s.length();i++){
			switch (s.charAt(i)){
			case '0': n=0; break;
			case '1': n=1; break;
			case '2': n=2; break;
			case '3': n=3; break;
				
			}
				
			sum = sum + (n * n);
			if (sum >9) return true;
		}
		
		return false;
	}
}
