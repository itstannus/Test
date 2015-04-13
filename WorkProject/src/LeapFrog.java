/*

A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

    class Solution { public int solution(int X, int Y, int D); } 

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30

the function should return 3, because the frog will be positioned as follows:

        after the first jump, at position 10 + 30 = 40
        after the second jump, at position 10 + 30 + 30 = 70
        after the third jump, at position 10 + 30 + 30 + 30 = 100

Assume that:

        X, Y and D are integers within the range [1..1,000,000,000];
        X ≤ Y.

Complexity:

        expected worst-case time complexity is O(1);
        expected worst-case space complexity is O(1).

*/

public class LeapFrog {
	
	public static void main(String...args){
		LeapFrog leapFrog = new LeapFrog();
		System.out.println(leapFrog.solution(10, 85, 30));
	}
	
	/*Assuming the Math. operations take unit time to complete
	 * this is not a perfect solution but is the fastest solution*/
	public int solution(int x, int y, int d){
		int difference = Math.abs(y-x);
		float perfectDifference = Math.abs((difference/d) - Math.round(difference/d));
		float resultDecider = Math.max((float)0.5, perfectDifference);
		if(Math.max((float)0.5,resultDecider)>=0.4999999999999999){
			return (int) Math.ceil((float)(difference/d +(1)));
		}
		return (int)Math.floor((double)(difference/d));
	}

	/*this is the perfect solution from correctness perspective but is the slowest solution from 
	 * time complexity point of view*/
	public int secondSolution(int x, int y, int d){
		int count=1;
		int sum=x;
		while(sum<y){
			sum+=d;
			count++;
		}
		return count;
	}
	
	/*this is the perfect and the best solution*/
	public int thirdSolution(int x, int y, int d){
		int result = (y-x)/d;
		if((y-x)%d > 0){
			return result+1;
		}
		return result;
	}
	
}
