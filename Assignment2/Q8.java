import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Q8 extends Utility{
	private static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList){return arrayList;}
	private static ArrayList<Integer> quickSort(ArrayList<Integer> arrayList){return arrayList;}
	
	public static void main(String[] args){
		System.out.println("ENTER VALUES: ");
		ArrayList<Integer> arrayList = getArrayList();
		Scanner input = new Scanner(System.in);

		System.out.println("1. BUBBLE SORT");
		System.out.println("2. QUICK SORT");
		int choice = input.nextInt();

		switch(choice){
			case 1:
				System.out.println(bubbleSort(arrayList));
				break;

			case 2:
				System.out.println(quickSort(arrayList));
				break;

			case 3:
				return;

			default:
				System.out.println("INVALID CHOICE!");
				return;
		}
	}	
}
