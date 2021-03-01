import java.util.ArrayList;

public class Q4 extends Utility {
	private static ArrayList<Integer> toArrayList(Integer[] array){	
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int value:array){
			arrayList.add(value);
		}
		
		return arrayList;
	}

	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
		Integer[] array = getArray();
		
		System.out.println(toArrayList(array));
	}
}
