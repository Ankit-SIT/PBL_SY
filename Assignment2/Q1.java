import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1{
    private static void display(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args){
        int[] odd = new int[5];
        int[] even = new int[5];

        int oddCount = 0;
        int evenCount = 0;

	System.out.println("ENTER VALUES: ");
        while(true){
        Scanner input = new Scanner(System.in);

        try{
            int value = input.nextInt();
            if(value % 2 == 0){
                even[evenCount] = value;
                evenCount++;
            }

            else{
                odd[oddCount] = value;
                oddCount++;
            }

        } catch(InputMismatchException e){
	    System.out.println("ODD: ");
            display(odd);
	    System.out.println("EVEN: ");
            display(even);
            System.out.println("EXITING!");
	    return;
        }
        }    
    }
}
