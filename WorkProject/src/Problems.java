import java.util.LinkedList;
import java.util.List;


public class Problems {
	int K = 2;
	static long counter=2;
	static long sum=0;
	public void sum3OR5(){ 
		int _multipleOF3=0; 
		int _multipleOF5=0; 
		int _multipleOF15=0;
		for(int i=0;i<1000;i+=15){
			_multipleOF15+=i;
		}
		for(int i=0;i<1000;i+=5){
			_multipleOF5+=i;
		}
		for(int i=0;i<1000;i+=3){
			_multipleOF3+=i;
		}
		System.out.println(_multipleOF3+_multipleOF5-_multipleOF15);
	}
	public void sumEvenFibonacciTerms(long number){
		long sum=0,N=0, counter=0;
		do{
			N = fibonacciUsingRecurrenceRelation(counter);
			if(counter>2&&counter%2==0){
				sum+=N;
			}
			counter++;
		}while(N<4000000);
		System.out.println(sum);
	}
	/*Using the usual recursion*/
	private long fibonacci(long number){
		if(number==1 || number == 0){
			return 1;
		}
		return fibonacci(number-1)+fibonacci(number-2);
	}
	
	// computes A * B
	private long[][] mul(long[][] A, long[][] B)
	{
		long[][] C= new long[K+1][K+1];
	    for(int i=1;i<=K;i++){
	    	for(int j=1;j<=K;j++){
	    		for(int k=1;k<=K;k++){
	    			C[i][j] = (C[i][j] + A[i][k] * B[k][j]);
	    		}
	    	}
	    }   
	    return C;
	}

	// computes A ^ p
	private long[][] pow(long[][] A, long p)
	{
		if (p == 0)
			return new long[][]{{1,0,0}, {0,1,0},{0,0,1}};
	    if (p == 1)
	        return A;
	    if (p % 2 == 1)
	        return mul(A, pow(A, p-1));
	    long[][] X = pow(A, p/2);
	    return mul(X, X);
	}

	// returns the N-th term of Fibonacci sequence
	private long fibonacciUsingRecurrenceRelation(long N)
	{
	    // create vector F1
	    long[] F1=new long[K+1];
	    F1[1] = 1;
	    F1[2] = 2;

	    // create matrix T
	    long[][] T=new long[K+1][K+1];
	    T[1][1] = 0;
	    T[1][2] = 1;
	    T[2][1] = 1;
	    T[2][2] = 2;

	    // raise T to the (N-1)th power
	    if (N == 1)
	        return 1;
	    T = pow(T, N-1);

	    // the answer is the first row of T . F1
	    long res = 0;
	    for(int i=1;i<=K;i++)
	        res = (res + T[1][i] * F1[i]);
	    return res;
	}
	
	public static void main(String...args){
		Problems problem = new Problems();
		problem.sum3OR5();
		
		problem.sumEvenFibonacciTerms(4000000);
	}
}
