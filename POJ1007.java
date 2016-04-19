import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class POJ1007{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int l = scanner.nextInt();
		int n = scanner.nextInt();
		ArrayList<StringInversion> siList = new ArrayList<StringInversion>();
		
		for(int i=0;i<n;i++){
			StringInversion si = new StringInversion();
			si.s = scanner.next();
			//System.out.println(si.s + ":"+si.s.length());
			char[] ch = si.s.toCharArray();
			si.l = count(ch);
			siList.add(si);
		}
		Collections.sort(siList, new StringInversion());
		for(int i=0;i<n;i++){
			System.out.println(siList.get(i).s);
		}
		
		
		
		scanner.close();
	}
	
	public static class StringInversion implements Comparator<StringInversion>{
		String s;
		Long l;
		@Override
		public int compare(StringInversion o1, StringInversion o2) {
			// TODO Auto-generated method stub
			return o1.l.compareTo(o2.l);
		}
		
	}
	
	// merge and count (Comparable version)
    private static long merge(char[] a, char[] aux, int lo, int mid, int hi) {
        long inversions = 0;

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                a[k] = aux[j++];
            else if (j > hi)                 a[k] = aux[i++];
            else if (aux[j] <aux[i]) { a[k] = aux[j++]; inversions += (mid - i + 1); }
            else                             a[k] = aux[i++];
        }
        return inversions;
    }

    // return the number of inversions in the subarray b[lo..hi]
    // side effect b[lo..hi] is rearranged in ascending order
    private static long count(char[] b, char[] aux, int lo, int hi) {
        long inversions = 0;
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        inversions += count(b, aux, lo, mid);  
        inversions += count(b, aux, mid+1, hi);
        inversions += merge(b, aux, lo, mid, hi);
        return inversions;
    }


    /**
     * Returns the number of inversions in the comparable array.
     * The argument array is not modified.
     * @param  a the array
     * @return the number of inversions in the array. An inversion is a pair of 
     *         indicies <tt>i</tt> and <tt>j</tt> such that <tt>i &lt; j</tt>
     *         and <tt>a[i].compareTo(a[j]) &gt; 0</tt>.
     */
    public static long count(char[] a) {
        char[] b   = new char[a.length];
        char[] aux = new char[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        long inversions = count(b, aux, 0, a.length - 1);
        return inversions;
    }
    
 
}
