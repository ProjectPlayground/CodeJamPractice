import java.util.Scanner;


public class POJ1988 {
	public static void main(String[] args){
		Scanner scanner  = new Scanner (System.in);
		int p = scanner.nextInt();
		int n2, n1;
		int[] size =  new int[30001];
		int[] a1 = new int[30001];
		int[] a2 = new int[30001];
		int[] a = new int[30001];
		
		for(int i=0;i<30001;i++){
			a1[i] = i;
			a2[i] = i;
			a[i] = i;
			size[i] = 1;
		}
		
		for(int i=0;i<p;i++){
			String s = scanner.next();
			n1 = scanner.nextInt();
			if (s.charAt(0) =='M'){
				n2 = scanner.nextInt();
				//find root of n1 in a1
				while(a1[n1]!=n1){ 
					a1[n1] = a1[a1[n1]];
					n1 = a1[n1];
				}
				//find root of n2 in a2
				while(a2[n2]!=n2){
					a2[n2] = a2[a2[n2]]; 
					n2 = a2[n2];
				}
				
				a1[n1] = n2;
				a2[n2] = n1;
				a[n2]=n1;
				//update sizes
				while(a[n1]!=n1){
					size[n1] = size[n1]+size[n2];
					n1 = a[n1];
				}
				size[n1] = size[n1]+size[n2];
				
				
				
			}else if ((s.charAt(0) =='C')){				
				
				System.out.println(size[n1]-1 );			
			}		
		}
		scanner.close();
	}
}
