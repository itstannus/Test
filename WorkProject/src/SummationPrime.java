
public class SummationPrime {

	/*to find the sum of primes under two million
	 * This involves re-using the NthPrime class*/
	public void findSummationOfPrime(int limit){
		long sum=0;
		long counter=1;
		NthPrime nthPrime = new NthPrime();
		while(counter<limit){
			sum+=nthPrime.findNthPrime(counter);
			counter++;
		}
		System.out.println("Summation is : "+sum);
	}
	
	public static void main(String...args){
		SummationPrime sumPrime = new SummationPrime();
		sumPrime.findSummationOfPrime(2000000);
	}
}
