import java.util.Comparator;
import java.util.TreeSet;

public class LongestPal{

	static TreeSet<String> solnArr = new TreeSet<String>(new MyComp());
	
	static class MyComp implements Comparator<String>{
		 
	    @Override
	    public int compare(String str1, String str2) {
	        return str1.length() - str2.length(); 
	    }
	}	
	
	boolean validPal(char[] C, int i, int j){
		for(int k =i, n = j; k < n; k++, --n){
			if(C[k] != C[n]) return false;
		}
		return true;
	}
	
	
	int[] palIndex(String s){
		int[] soln = new int[2];
		char[] C = s.toCharArray();
		
		for(int i = 0; i < C.length-1; i++){
			for(int j = C.length-1; j > i; --j){
				if(validPal(C, i, j)){
					solnArr.add(s.substring(i, j+1));
					//add into an array and then sort by length
				}
			}
		}
		String val = solnArr.last();
		System.out.println(val);
		soln[0] = s.indexOf(val);
		soln[1] = val.length();
		return soln;
	}
	
	public static void main(String[] args){
		String test1 = "newracecar";
		String test2 = "12111122221212121";
		String test3 = "hello";
		LongestPal pal = new LongestPal();
		int[] ans = pal.palIndex(test1);
		System.out.println(ans[0] +" "+ ans[1]);
		solnArr.clear();
		ans = pal.palIndex(test2);
		System.out.println(ans[0] +" "+ ans[1]);
		solnArr.clear();
		ans = pal.palIndex(test3);
		System.out.println(ans[0] +" "+ ans[1]);
	}
}