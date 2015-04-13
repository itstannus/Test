import java.util.Arrays;


public class Solution {

	public static void main(String...args){
		Solution sol = new Solution();
		//System.out.println(sol.solution(new int[]{1,3,5,3,7}));
		System.out.println(sol.findMaxPair(new int[]{1,1,0,1,0,0,1,1}));
	}
	public boolean solution(int[] array){
		return calculate(array);/*calculate(array, 0, array.length-1);*/
	}
	private boolean calculate(int[] array, int firstIndex, int lastIndex){
		for(int i=0;i<array.length;i++){
			
		}
		int midIndex = (firstIndex+lastIndex)/2;
		for(;firstIndex<lastIndex;){
			if(array[firstIndex]<array[lastIndex])
			{	firstIndex++;
				lastIndex--;
			}else 
				lastIndex--;
			/*if(array[lastIndex] > array[midIndex])*/
				
		}
		if(firstIndex==array.length)
			firstIndex-=1;
		if(array[lastIndex]<array[firstIndex] & lastIndex>firstIndex)
			return true;
		return false;
	}
	
	public boolean calculate(int[] A1){
		int[] A2 = new int[A1.length];
		for(int i=0;i<A1.length;i++){
			A2[i]=A1[i];
		}
		Arrays.sort(A2);
		int j=0, swap=0;
		for(int i=0; i<A1.length; i++){
			if(A1[i]==A2[j]) //if equal increment j
				j++;
			else
				swap++; //else increment swap 
		}
		swap-=1;
		return swap==1;
	}
	
	int findPair(int arr[])
	{
	    // Initialize positions of two elements
	    int i = 0;  
	    int j = 1;
	    int count=0;
	    // Search for a pair
	    while (i<arr.length && j<arr.length)
	    {
	        if (i != j && (arr[j]-arr[i] < 0 || arr[j]-arr[i] > 0) /*&& i+1==j*/)
	        {
	        	if(arr[j]-arr[i]<0)
	        		arr[j] = arr[i];
	        	else if(arr[j]-arr[i]>0)
	        		arr[i]=arr[j];
	        	break;
	        }
	        else if (arr[j]-arr[i] < 0)
	            j++;
	        else
	            i++;
	    }
	    
	    return count;
	}
	
	int findMaxPair(int[] arr){
		int i=0;
		int j=1;
		int count=0;
		boolean changed=false;
		for(;j<arr.length;){
			if(arr[i]==arr[j]){
				i+=2;
				j+=2;
				count++;
				continue;
			}else if(arr[i]!=arr[j] & !changed){
				arr[i]=arr[j];
				count++;
				changed=true;
				continue;
			}
			i++;
			j++;
		}
		return count;
	}
	
	
}
