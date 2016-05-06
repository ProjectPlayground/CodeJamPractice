import java.util.Scanner;


public class PartElf {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i=0;i<t;i++){
			String s = scanner.next();
			String[] sa = s.split("/");
			long p = Long.parseLong(sa[0]);
			long q = Long.parseLong(sa[1]);
			int ans = solve(p,q);
			if (ans!=-1)
				System.out.println("Case #"+(i+1)+": "+ans);
			else
				System.out.println("Case #"+(i+1)+": "+"impossible");
		}
		scanner.close();		
	}
	
	private static int solve(long p,long q){
		int ans=-1;
		long d = GCD (p,q);
		p = p/d ;
		q = q/d;
		if (!isPowerOfTwo(q)) return ans;
		long a =p;
		long c = q;
		int count=0;
		while(a>1){
			c = c/2;
			if (a>c) a = c;
			else a = a-1;
			d = GCD (a,c);	
			a = a/d;
			c = c/d;
			count++;		
		}	
		if (c>1){
			ans = (int) (Math.log10(c)/Math.log10(2));
			ans = ans +count;
		}else{
			ans = count;
		}
		
		return ans;
	}
	
	public static long GCD(long a, long b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	
	public static boolean isPowerOfTwo(long x){
		return (x & (x-1)) ==0;
	}
}
