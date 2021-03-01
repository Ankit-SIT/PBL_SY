import java.util.Arrays;

public class Q6 extends Utility{
	private static int commonElementIn(Integer[] array1, Integer[] array2, Integer[] array3){
		Arrays.sort(array1);
		Arrays.sort(array2);
		Arrays.sort(array3);

		for(int i = 0; i < array1.length; i++){
			if(Arrays.binarySearch(array2, array1[i]) >= 0){
				if(Arrays.binarySearch(array3, array1[i]) >= 0){
					return array1[i];
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
        Integer[] array1 = getArray();
        Integer[] array2 = getArray();
		Integer[] array3 = getArray();
		
		System.out.println("COMMON ELEMENT: " + commonElementIn(array1,array2,array3));
	}
}
