
public class SumSquareDifference {

	private long sumOfSquares(long limit){
		limit = limit*(limit+1)*((2*limit)+1);
		final long sum = limit/6;
		return sum;
	}
	
	private long squareOfSum(int limit){
		limit = limit*(limit+1);
		final long sum=limit/2;
		return sum*sum;
	}
	
	public void sumSquareDifference(int limit){
		System.out.println(squareOfSum(limit)-sumOfSquares(limit));
	}
	
	public static void main(String...args){
		SumSquareDifference sumSqDiff = new SumSquareDifference();
		sumSqDiff.sumSquareDifference(10);
	}
}
