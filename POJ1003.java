import java.util.Scanner;


public class POJ1003 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		float f = scanner.nextFloat();
		
		while(f!=0.00){
			int i =2;
			float f1 = (float)1/i;
			int counter=1;
			while(f>f1){
				i++;
				f1 = f1 + (float)1/i;
				counter++;	
			}
			System.out.println(counter +" card(s)");
			f = scanner.nextFloat();
			
		}
		scanner.close();
	}

}
