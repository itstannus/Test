import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LargestPalindromeProduct {
	private List<Long> palindromeList=new ArrayList<Long>();
	public void largestPalindromeProduct(){
		for(long i=999;i>100;i--){
			for(long j=i;j>100;j--){
				if(isPalindrome(i*j)){
					palindromeList.add(i*j);
				}
			}
		}
		Collections.sort(palindromeList);
		System.out.println("Largest Palindrome : "+palindromeList.get(palindromeList.size()-1));
	}
	
	private boolean isPalindrome(long number){
		StringBuilder reverseNumber = new StringBuilder(Long.toString(number)).reverse();
		return reverseNumber.toString().equals(Long.toString(number));
	}
	
	public static void main(String...args){
		LargestPalindromeProduct largePP=new LargestPalindromeProduct();
		largePP.largestPalindromeProduct();
	}
}
