import java.util.ArrayList;
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
			k-=3;
			x++;
		}
	}
	
	public static void main(String[] args){
		vals.add(1);
		UglyNumbers chart = new UglyNumbers();
		System.out.println(chart.kthUlgy(5));
		System.out.println(chart.kthUlgy(10));
		//correctly prints out the 5th and 10th ulgy
		//number
		
	}	
}
