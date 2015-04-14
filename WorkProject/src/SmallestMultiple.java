
public class SmallestMultiple {
	
	public void smallestMultiple(){
		int smallestMultiple=Integer.MAX_VALUE;
		outer:
			for(int j=21;;j++){
				inner:
					for(int i=2;i<=20;i+=1){
						if(j%i!=0){
							break inner;
						}
						if(i==20){
							if(smallestMultiple>j)
								smallestMultiple=j;
							break outer;
						}
					}
			}
		System.out.println("The smallest multiple is : "+smallestMultiple);
	}
	public static void main(String...args){
		SmallestMultiple smallMultiple = new SmallestMultiple();
		smallMultiple.smallestMultiple();
	}
}
