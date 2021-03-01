import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Utility{
	public static Integer[] getArray(){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		while(true){
			try{
				arrayList.add(in.nextInt());
			} catch (InputMismatchException e){
				Integer[] array = new Integer[arrayList.size()];
				array = arrayList.toArray(array);
				return array;
				}
		}
	}

	public static ArrayList<Integer> getArrayList(){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		while(true){
			try{
				arrayList.add(in.nextInt());			
			
			} catch(InputMismatchException e){
				break;
			}
		}

		return arrayList;
	}
}
