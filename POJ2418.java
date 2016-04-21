import java.util.Scanner;
import java.util.TreeMap;

public class POJ2418 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		TreeMap<String,Integer> trees = new TreeMap<String,Integer>();
		int total =0;
		while(scanner.hasNextLine()){
			String s = scanner.nextLine();
			total++;
			if(trees.containsKey(s)){
				int n = trees.get(s);
				trees.put(s, n+1);
			}else{
				trees.put(s, 1);
			}
		}
		for(String s1:trees.keySet()){
			System.out.println(s1+" "+String.format("%.4f", ((double)trees.get(s1)*100/total)));
		}
		
		scanner.close();
	}
}
