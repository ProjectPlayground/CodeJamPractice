import java.util.Scanner;


public class POJ2140 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int counter=1;
		int i=2;
		int c=0;
		while (true){
			
			if (i%2 ==0){ 
				c =i/2;
				if ((n-c)%i ==0){
					if (((n-c)/i)-(c-1)<1)
						break;
					else
						counter++;
				}
			
			}
			else{
				c=0;
				if (n%i ==0){
					if ((n/i)-(i/2)<1)
						break;
					else
						counter++;
				}		
			}		
			i++;	
		}
		System.out.println(counter);
		scanner.close();
	}
}
