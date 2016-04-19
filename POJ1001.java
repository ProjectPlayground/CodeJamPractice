import java.math.BigDecimal;
import java.util.Scanner;


public class POJ1001 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext() ){
			String s = scanner.next();
			if (s.equals("")) break;
			//String[] sa = s.split(" ");
			//double r = 
			//System.out.println(r);
			
			BigDecimal bd = new BigDecimal(s);
			int	n = scanner.nextInt();
			
			//System.out.println(n);
			
			//System.out.println(bd.pow(n).toPlainString());
			String s1 = bd.pow(n).stripTrailingZeros().toPlainString();
			if (s1.charAt(0) =='0')
				s1 = s1.substring(1);
			
			System.out.println(s1);
		}
		scanner.close();
	}
}
