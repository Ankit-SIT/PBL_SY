import java.util.ArrayList;

public class Q5 extends Utility{
	private static Integer[] toArray(ArrayList<Integer> arrayList){
	Integer[] array = new Integer[arrayList.size()];

		for(int i = 0; i < arrayList.size(); i++){
			array[i] = arrayList.get(i);
		}

		return array;
	}

	public static void main(String[] args){	
		System.out.println("ENTER VALUES: ");
		ArrayList<Integer> arrayList = getArrayList();
		
		Integer[] array = toArray(arrayList);
		for(int value:array){
			System.out.println(value);
		}
	}
}
