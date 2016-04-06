import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


public class LawnMower {
	public static void main (String[] args){
		In in = new In(args[0]);      // input file
        int T = in.readInt();
        Out out = new Out("LawnMower.txt");
        for(int i=0;i<T;i++){
        	int n= in.readInt();
        	int m= in.readInt();   
        	//read board
        	int[][] targetLawn = new int[n][m];
        	int[][]	beginLawn = new int[n][m];
        	//read input data
        	for(int row=0;row<n;row++){ 		
        		for(int col=0;col<m;col++){		
        			targetLawn[row][col] = in.readInt();
        			beginLawn[row][col] = 100;
        		}
        	}
        	
        	
        	
        	//cut all rows first
        	for(int row=0;row<n;row++){
        		//find max 
        		int max=0;
        		for(int col=0;col<m;col++){
        			if (targetLawn[row][col]>max) max = targetLawn[row][col];
        		}
        		for(int col=0;col<m;col++)
        			beginLawn[row][col] = max;	
        	}
        	
       	
        	//cut all columns 
        	for(int col=0;col<m;col++){
        		//find max 
        		int max=0;
        		for(int row=0;row<n;row++){
        			if (targetLawn[row][col]>max) max = targetLawn[row][col];
        		}
        		for(int row=0;row<n;row++)
        			if (beginLawn[row][col]>max)
        				beginLawn[row][col] = max;	
        	}
        	
        	//compare lawns
        	boolean flag = true;
        	for(int row=0;row<n;row++)
        		for(int col=0;col<m;col++){
        			if (beginLawn[row][col]!=targetLawn[row][col]){
        				
        				flag = false;
        			}
        				
        		}
        	if (flag)
        		out.println("Case #"+(i+1)+": "+"YES");
        	else
        		out.println("Case #"+(i+1)+": "+"NO");
        	
        	
        }
        
	}
}
