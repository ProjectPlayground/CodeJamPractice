import java.util.Arrays;
import java.util.Scanner;

public class POJ2395 {
	public static void main(String[] args){
		Scanner  scanner = new Scanner (System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		Edge[] e = new Edge[E];
		for(int i=0;i<E;i++){
			e[i] = new Edge(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());			
		}
		Arrays.sort(e);
		UnionFind uf = new UnionFind(V);
		int max =0;
		for(int i=0;i<E;i++){
			if (!uf.isConnected(e[i].x-1, e[i].y-1)){
				uf.union(e[i].x-1, e[i].y-1);
				max = Math.max(max, e[i].dist);
			}
		}
		System.out.println(max);
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
