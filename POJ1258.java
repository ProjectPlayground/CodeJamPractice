import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class POJ1258 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String s = scanner.next();
			if (s.equals("")) break;
			int n = Integer.parseInt(s);
			ArrayList<Edge> e =new ArrayList<Edge>();
			for(int i=1;i<=n;i++){
				for(int j=1; j<=n;j++){
					int d = scanner.nextInt();
					if (j>i){
						Edge e1 = new Edge(i,j,d);
						e.add(e1);
					}
				}	
			}
			Collections.sort(e);
			UnionFind uf = new UnionFind(n);
			int count=0;
			for(int i=0;i<e.size();i++){
				if (!uf.isConnected(e.get(i).x-1, e.get(i).y-1)){
					uf.union(e.get(i).x-1, e.get(i).y-1);
					count = count + e.get(i).dist;
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}
	
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int dist;
		public Edge(int x, int y, int d){
			this.x= x;
			this.y=y;
			this.dist = d;
		}
		public int compareTo(Edge o) {
			if (this.dist < o.dist) return -1;
			else if (this.dist > o.dist) return 1;
			return 0;
		}
	}
	public static class UnionFind{
		int[] L;
		public UnionFind(int n){
			L = new int[n];
			for(int i=0;i<n;i++){
				L[i] =i;
			}
		}
		public void union(int x, int y){
			L[find(x)] = find(y);
		}
		
		public int find(int x){
			if(x == L[x]) return x;
			int root = find(L[x]);
			L[x] = root;
			return root;
		}
		
		public boolean isConnected(int x, int y){
			if (find(x) ==find(y)) return true;
			else return false;
		}
	}
}
