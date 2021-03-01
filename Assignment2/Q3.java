
public class Q3 extends Utility{
	private static int getSecondSmallest(Integer[] array){
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		
		if(array.length < 2){
			System.out.println("ARRAY TOO SMALL!");
			return 0;
		}
		
		for(int i = 0; i < array.length; i++){
			if(array[i] < smallest){
				secondSmallest = smallest;
				smallest = array[i];
			}

			else if(array[i] < secondSmallest && array[i] != smallest){
				secondSmallest = array[i];
			}
		}

		return secondSmallest;
	}


	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
		Integer[] array = getArray();
		System.out.println("SECOND SMALLEST: " + getSecondSmallest(array));
	}
}
