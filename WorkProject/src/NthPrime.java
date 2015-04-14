import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NthPrime {

	Map<Long,Long>sieve=new HashMap<Long,Long>();
	List<Long> sieveList=new ArrayList<Long>();
	public void findNthPrime(long n){
		long limit = 100*n + 1;
		for(long i=0;i<=limit;i++){
			sieveList.add((int)i, 0L);
		}
		for(long i=2;i<=limit;i++){
			sieveList.add((int)i, i);
		}
		System.out.println("Size of map : "+sieve.size());
		for(long j=2;j<=limit;j++){
			long k=j*2;
			for(;k<=limit;k+=j){
				sieveList.remove(k);
			}
		}
		
		System.out.println("The Nth prime is : "+sieveList.get((int) n));
	}
	public static void main(String...args){
		NthPrime nThPrime = new NthPrime();
		nThPrime.findNthPrime(10001);
	}
}
