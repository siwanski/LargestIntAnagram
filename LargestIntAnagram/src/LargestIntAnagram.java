import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 
 */

/**
 * @author Szymon Iwañski
 *
 */
public class LargestIntAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int n = rand.nextInt(999);
		System.out.println("Wygenerowana liczba: " + n + "\n");
		System.out.println("Najwy¿szy mo¿liwy anagram wygenerowanej liczby: " + largestPalindrome(n));
	}

	public static String largestPalindrome(int N) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    do {
	    	arr.add(N%10);
	    	N /= 10;
	    } while (N > 0);
	    
	    String[] strs = new String[arr.size()];
	    
	    for(int i=0; i<arr.size(); i++) strs[i] = String.valueOf(arr.get(i));
	 
	    Arrays.sort(strs, new Comparator<String>(){
	        public int compare(String s1, String s2){
	            String leftRight = s1+s2;
	            String rightLeft = s2+s1;
	            return -leftRight.compareTo(rightLeft);
	 
	        }
	    });
	 
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    for(String s: strs) stringBuilder.append(s);
	    while(stringBuilder.charAt(0)=='0' && stringBuilder.length()>1) stringBuilder.deleteCharAt(0);
	 
	    return stringBuilder.toString();
	}
}
