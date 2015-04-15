import java.util.ArrayList;
import java.util.List;

/*This program finds the largest product of n contiguous one digit numbers in a given string of numbers, 
 * However it has a function that can help find the largest product of n contiguous k digit numbers*/
public class LargestContiguousSeriesProduct {
	
	List<Integer>numbers=new ArrayList<Integer>();
	/*This is a utility method that returns the number that corresponds to the string form
	 * This is useful when we need to extract two or more digit numbers from 
	 * a string of contiguous numbers*/
	/*This returns zero if the length of the numberString does not match the numberOfDigits*/
	private long convertToNumber(String numberString){		
		if(numberString==null || numberString.length()==0)
			return 0L;
		if(numberString.length()==1){
			return Long.parseLong(numberString);
		}
		int numberOfDigits = numberString.length();
		long number=0L;
		int counter=0;
		int tempNumberOfDigits=numberOfDigits-1;
		while(tempNumberOfDigits>=0){
			char ch = numberString.charAt(tempNumberOfDigits);
			int tempNumber=(int)ch-48;
			number+=tempNumber*Math.pow(10, counter);
			tempNumberOfDigits--;
			counter++;
		}
		System.out.println("the number is : "+number);
		return number;
	}
	public void findTheLargestProduct(String contiguousSeriesLength){
		char[] numberChar = contiguousSeriesLength.toCharArray();
		for(int asciiNumber:numberChar){
			int number=asciiNumber-48;
			numbers.add(number);
		}
		int front=0;
		int rear=12;
		long product=1;
		long result=Long.MIN_VALUE;
		while(rear<numbers.size()){
			for(int i=front;i<=rear;i++){
				product*=numbers.get(i);
			}
			if(result<product){
				result=product;
			}
			product=1;
			front+=1;
			rear+=1;
		}
		System.out.println("The largest product of 13 contiguous numbers is : "+result);
	}
	
	public static void main(String...args){
		String contiguousSeries="7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		LargestContiguousSeriesProduct largeProduct = new LargestContiguousSeriesProduct();
		largeProduct.findTheLargestProduct(contiguousSeries);
	}
}
