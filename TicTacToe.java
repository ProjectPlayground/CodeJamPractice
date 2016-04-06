import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


public class TicTacToe {
	boolean xWins = false;
	boolean oWins = false;
	boolean empty = false;
	public static void main (String[] args){
		In in = new In(args[0]);      // input file
        int T = in.readInt();
        Out out = new Out("TicTacToe.txt");
        for(int i=0;i<T;i++){
        	//read game board
        	char[][] game = new char[4][4];
        	//read input data
        	for(int row=0;row<4;row++){
        		String s = in.readString();
        		for(int col=0;col<4;col++){
        			char c = s.charAt(col);
        			game[row][col] = c;
        		}
        	}
        	
        	TicTacToe t = new TicTacToe();
        	t.scanRows(game);	
        	if (t.xWins)
        		out.println("Case #"+(i+1)+": "+"X won");
        	else
        		if (t.oWins)
        			out.println("Case #"+(i+1)+": "+"O won");
        		else{
        			t.scanCols(game);
        			if (t.xWins)
                		out.println("Case #"+(i+1)+": "+"X won");
                	else
                		if (t.oWins)
                			out.println("Case #"+(i+1)+": "+"O won");
                		else{
                			t.scanDiag(game);
                			if (t.xWins)
                        		out.println("Case #"+(i+1)+": "+"X won");
                        	else
                        		if (t.oWins)
                        			out.println("Case #"+(i+1)+": "+"O won");
                        		else{
                        			if (t.empty)
                        				out.println("Case #"+(i+1)+": "+"Game has not completed");
                        			else
                        				out.println("Case #"+(i+1)+": "+"Draw");
                        			
                        		}
                		}
        		}      	
        }
	}
	
	public void scanRows(char[][] game){
		int x=0;
		int o=0;
		for (int row=0;row<4;row++){
			x=0;
			o=0;
			for (int col=0;col<4;col++ ){
				if (game[row][col]=='X'){
					x++;
					o=0;
				}
				if (game[row][col]=='O'){
					o++;
					x=0;
				}
				if (game[row][col]=='T'){
					x++;
					o++;
				}
				
				if (game[row][col]=='.'){
					x=0;
					o=0;
					empty = true;
				}
				
				
			}
			//System.out.println("x:"+x);
			if (x==4){
				xWins = true;
				break;
			}
			if(o==4){
				oWins = true;
				break;
			}
		}	
	}
	
	public void scanCols(char[][] game){
		int x=0;
		int o=0;
		for (int col=0;col<4;col++){
			x=0;
			o=0;
			for (int row=0;row<4;row++ ){
				if (game[row][col]=='X'){
					x++;
					o=0;
				}
				if (game[row][col]=='O'){
					o++;
					x=0;
				}
				if (game[row][col]=='T'){
					x++;
					o++;
				}
				if (game[row][col]=='.'){
					x=0;
					o=0;
					empty = true;
				}
				
				
			}
			if (x==4){
				xWins = true;
				break;
			}
			if(o==4){
				oWins = true;
				break;
			}
		}	
	}
	
	public void scanDiag(char[][] game){
		int x=0;
		int o=0;
		for (int col=0;col<4;col++){
			if (game[col][col]=='X'){
				x++;
				o=0;
			}
			if (game[col][col]=='O'){
				o++;
				x=0;
			}
			if (game[col][col]=='T'){
				x++;
				o++;
			}
			if (game[col][col]=='.'){
				x=0;
				o=0;
				empty = true;
			}
			
		}
		if (x==4){
			xWins = true;
			return;
		}
		if(o==4){
			oWins = true;
			return;
		}
		int n=4;
		x=0;
		o=0;
		for (int col=0;col<4;col++){
			
			if (game[col][n-1]=='X'){
				x++;
				o=0;
			}
			if (game[col][n-1]=='O'){
				o++;
				x=0;
			}
			if (game[col][n-1]=='T'){
				x++;
				o++;
			}
			if (game[col][n-1]=='.'){
				x=0;
				o=0;
			}
			
			n--;
		}
		if (x==4)
			xWins = true;
		if(o==4)
			oWins = true;
		
	}	
}
