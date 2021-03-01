import java.util.Arrays;

public class Q7 extends Utility{
	private static int LargestSmallestDifference(Integer[] array){
		Arrays.sort(array);
		return (array[array.length - 1] - array[0]);
	}

	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
		Integer[] array = getArray();

		System.out.println("DIFFERENCE IN LARGEST AND SMALLEST: " + LargestSmallestDifference(array));
	}
}
