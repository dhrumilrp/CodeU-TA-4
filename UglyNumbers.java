import java.util.TreeSet;

public class UglyNumbers {
	static TreeSet<Integer> vals = new TreeSet<Integer>();
	
	
	int kthUlgy(int k) throws IndexOutOfBoundsException{
		addVals(k);
		
		Object[] uglies = vals.toArray();
		
		return (int) uglies[k-1];
	}
	
	void addVals(int k){
		int x = 1;
		while(k > 0){
			vals.add(x * 2);
			vals.add(x * 3);
			vals.add(x * 5);
			k--;
			x++;
			while(!vals.contains(x)) x++; //there are ways to skip numbers
		}
	}
	
	public static void main(String[] args){
		vals.add(1);
		UglyNumbers chart = new UglyNumbers();
		//System.out.println(chart.kthUlgy(3));
		//System.out.println(chart.kthUlgy(4));
		
		for(int i = 1; i< 25; i++){
			System.out.println(chart.kthUlgy(i));
		}
		//correctly prints out the first 24 ugly numbers
	}	
}
