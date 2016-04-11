

public class CountingSheep {
	public static void main(String[] args){
		
		In in = new In(args[0]);      // input file
		int T = in.readInt();
		Out out = new Out("CountingSheep.txt");
		for (int i=0;i<T;i++){
			int N = in.readInt();
			if (N!=0){		
				boolean[] num = new boolean[10];
				for(int k =0;k<10;k++){
					num[k] = false;
				}
				int counter=1;
				int digitCount=0;
				long d = N;
				while(true){
					//update boolean num array
					System.out.println("d:"+d);
					int r = (int)d%10;
					long q = d/10;
					System.out.println("r:"+r);
					System.out.println("q:"+q);
					while (q >0){
						if (!num[r]){
							num[r] = true;
							digitCount++;
						}
						r = (int)q%10;
						q = q/10;
					}
					if (!num[r]){
						num[r] = true;
						digitCount++;
					}
					
					//check if all true then exit
					System.out.println("digitCount:"+digitCount);
					if (digitCount>=10) break;
					
					//otherwise multiply further
					counter++;
					d = counter*N;
					
				}
			
				
				
				out.println("Case #"+(i+1)+": "+d);
			}else{
				out.println("Case #"+(i+1)+": "+"INSOMNIA");
			}
		}
		out.close();
	}
}
