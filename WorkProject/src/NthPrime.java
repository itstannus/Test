import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class NthPrime {

	Map<Long,Long>sieve=new LinkedHashMap<Long,Long>();
	List<Long> sieveList=new ArrayList<Long>();
	public void findNthPrime(long n){
		long limit = 50*n + 1;
		for(long i=2;i<=limit;i++){
			sieve.put(i,i);
		}
		
		for(long j=2;j<=limit;j++){
			long k=j*2;
			for(;k<=limit;k+=j){
				sieve.remove(k);
			}
		}
		sieveList.addAll(sieve.keySet());
		System.out.println("The Nth prime is : "+sieveList.get((int) n-1));
	}
	public static void main(String...args){
		NthPrime nThPrime = new NthPrime();
		nThPrime.findNthPrime(10001);
	}
}
