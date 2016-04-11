import java.math.BigInteger;
import java.util.ArrayList;


public class Prime {
	static ArrayList<Integer> primes;
	
	final static String TEST_LARGE = 		"10000000000000000000000000000001";
	final static String TEST_LARGE_LIMIT = 	"11111111111111111111111111111111";
	
	public static void main(String[] args){

		long L = Long.parseLong(TEST_LARGE, 2);
		long U = Long.parseLong(TEST_LARGE_LIMIT, 2);
		Out out = new Out("PrimeLarge.txt");
		out.println("Case #1:");

		int count=0;
		for (long i=L;i<=U ;i++ ){
		    //discard if the last digit is 0
			if ((i&1) ==1){
				String s = Long.toBinaryString(i);
				boolean primeFlag = false;
				for (int radix =2; radix<=10;radix++){
					BigInteger n = new BigInteger(s,radix);
					if (n.isProbablePrime(1)){
						primeFlag = true;
						break;
					}
				}
				if (!primeFlag){
					boolean zeroDiv = false;
					BigInteger b0 = new BigInteger("0");
					BigInteger[] div = new BigInteger[9];
					for (int radix =2; radix<=10;radix++){
							BigInteger n = new BigInteger(s,radix);
							div[radix-2] = isPrime(n);
							if (div[radix-2].equals(b0)){
								zeroDiv = true;
								break;
							}
							
					}
					if (!zeroDiv){
						count++;
						out.println(s+" "+div[0].toString()+" "+div[1].toString()+" "+div[2].toString()+" "+div[3].toString()+" "+div[4].toString()+" "+div[5].toString()+" "+div[6].toString()+" "+div[7].toString()+" "+div[8].toString());	
					}
					if (count>=500) break;		
				}			
			}		
		}

		out.close();
		
	}
		
	public static BigInteger isPrime(BigInteger n){
		
		BigInteger b2 = new BigInteger("2");
		BigInteger b0 = new BigInteger("0");
		
	    if ((n.remainder(b2)).equals(b0))
	        return b2;
	    BigInteger b3 = new BigInteger("3");
	    if ((n.remainder(b3)).equals(b0))
	        return b3;

	    BigInteger b5 = new BigInteger("5");
	    BigInteger bw = new BigInteger("2");
	    BigInteger b6 = new BigInteger("6");
	    
	    BigInteger blimit = new BigInteger("1000000");
	    while (( (b5.multiply(b5)).compareTo(n))<= 0){
	        if (n.remainder(b5).equals(b0))
	            return b5;

	        b5 = b5.add(bw);
	        bw = b6.subtract(bw);
	        
	        if (b5.compareTo(blimit) >=0) break;
	    }	
		return b0;
	}
	
}