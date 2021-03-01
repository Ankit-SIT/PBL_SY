import java.util.ArrayList;

public class Q10 extends Utility{
	private static ArrayList<Integer> getPeaks(Integer[] array){
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++){
			
			if(i == 0){
				if(array[i] > array[i + 1]){
					arrayList.add(array[i]);
				}
			}

			else if(i == array.length - 1){
				if(array[i] > array[i - 1]){
					arrayList.add(array[i]);
				}
			}


			else if(array[i - 1] < array[i] && array[i + 1] < array[i]){
				arrayList.add(array[i]);
			}
		}

		return arrayList;
	}

	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
		Integer[] array = getArray();

		System.out.println("PEAKS: " + getPeaks(array));
	}
}
