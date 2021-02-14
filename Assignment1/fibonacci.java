import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class Fibonacci{

    private static void printFibonacci(double n){
        int first = 1;
        int second = 1;
        int third = 0;

        System.out.println("\n" + first + " ");
        System.out.println(second + " ");
        n = n - 2;
        while(n-- != 0){
            third = first + second;
            System.out.println(third + " ");
            first = second;
            second = third;
        }
    }

    public static void main(String[] args)
        throws IOException, NumberFormatException{
        try{
        if(!(args.length == 0)){
            printFibonacci(Integer.parseInt(args[0]));
        }
        
        else{
                double n = 0;
                Scanner input = new Scanner(System.in);
                while(true){
                        System.out.println("-- MENU --");
                        System.out.println("1. Scanner");
                        System.out.println("2. BufferedReader");
                        System.out.println("3. Exit\n");
                        System.out.println("ENTER CHOICE: ");
                        int choice = input.nextInt();

                        switch(choice){
                            case 1:
                                n = input.nextDouble();
                                break;

                            case 2:
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                                String InputLine = bufferedReader.readLine();
                                n = Double.parseDouble(InputLine);
                                break;

                            case 3:
                                return;

                            default:
                                System.out.println("INVALID CHOICE! TRY AGAIN!");
                                break;
                        }

                        printFibonacci(n);
                }
        }
    } catch(Exception e){
        System.out.println("Exception: " + e.getMessage());
    }
}
}