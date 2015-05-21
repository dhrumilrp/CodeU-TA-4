import java.util.TreeSet;


public class BitsPal {
	
	static TreeSet<Integer> vals = new TreeSet<Integer>();
	
	boolean isPal(int x){
		int orig = x;
		int y = 0;
		while(x > 0){
			y <<= 1;
			y |= (x & 1);
			x >>= 1;
		}
		
		if(orig==y) return true;
		return false;
	}
	
	void addPal(int k){ 
		int i = vals.size()+1;
		while(vals.size() < k){
			if(isPal(i)){
				vals.add(i);
			}
			i++;
		}
	}
		
	int kthPal(int k) throws IndexOutOfBoundsException{
		if(k > vals.size()){ 
			addPal(k);
			return vals.last();
		}
		Object[] nums = vals.toArray();
		return (int) nums[k];
	}

	public static void main(String[] args){
		BitsPal pal = new BitsPal();
		System.out.println(pal.kthPal(49));
		System.out.println(pal.kthPal(50));
	}
}