public class LongestPal {

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
					soln[0] = i;
					soln[1] = j-i+1;
					return soln;
				}
			}
		}
		return soln;
	}
	
	public static void main(String[] args){
		String test1 = "newracecar";
		LongestPal pal = new LongestPal();
		int[] ans = pal.palIndex(test1);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		
	}
}