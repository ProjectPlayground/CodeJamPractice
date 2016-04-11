
public class RevengeOfPancakes {
	public static void main(String[] args){
		
		In in = new In(args[0]);      // input file
		int T = in.readInt();
		Out out = new Out("Pancakes.txt");
		for (int i=0;i<T;i++){
			String s = in.readString();
			int counter=0;
			for(int j=s.length()-1;j>=0;j--){
				if (s.charAt(j) =='-'){
					//start with beginning and check for '+' 
					int k=0;
					while(true){
						if (s.charAt(k) =='+')
							k++;
						else
							break;
					}
					
					//flip partial stack to convert + into -
					if(k>0){
						s = flip(s,k-1);
						counter++;
					}
					
					//entire flip
					s = flip(s,j);
					counter++;
				}
				
			}		
			out.println("Case #"+(i+1)+": "+counter);
		}
		out.close();
	}
	
	public static String flip(String s, int n){
		StringBuilder sb = new StringBuilder();
		for (int i=n; i>=0;i--){
			char c = s.charAt(i);
			if (c=='+')
				sb.append('-');
			else
				sb.append('+');
		}
		
		
		for(int j=n+1;j<s.length();j++){
			sb.append(s.charAt(j));
		}
		return sb.toString();
		
	}
}
