import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LargestPrimeFactor {

	public BigDecimal primeFactor(BigDecimal number){
		List<BigDecimal>primeFactorList=new ArrayList<BigDecimal>();
		BigDecimal divisor=new BigDecimal(2);
		while (number.compareTo(BigDecimal.ONE)==1){
			while(number.remainder(divisor)==BigDecimal.ZERO){
				primeFactorList.add(divisor);
				number=number.divide(divisor);
			} 
			divisor=divisor.add(BigDecimal.ONE);
			if (divisor.multiply(divisor).compareTo(number)==1){
				if (number.compareTo(BigDecimal.ONE)==1){
					primeFactorList.add(number);
					break;
				}
			}	            
		}
		Collections.sort(primeFactorList);
		return primeFactorList.get(primeFactorList.size()-1);
	}
	
	public static void main(String...args){
		LargestPrimeFactor largePF = new LargestPrimeFactor();
		System.out.println(largePF.primeFactor(new BigDecimal("600851475143")).toPlainString());
	}
}
