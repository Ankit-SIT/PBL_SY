import java.util.Scanner;
import java.lang.Math;
import java.lang.NumberFormatException;

public class Calculator{
    public double add(double x, double y){
        return x + y;
    }

    public double subtract(double x, double y){
        return x - y;
    }

    public double multiply(double x, double y){
        return x * y;
    }

    public double divide(double x, double y){
        return x / y;
    }

    public double sqrt(double x){
        return Math.sqrt(x);
    }

    public double pow(double x, double power){
        return Math.pow(x, power);
    }

    public double mean()
        throws NumberFormatException{
        int n = 0;
        double sum = 0;
        double mean = 0;
        
        String value = "";
        Scanner in = new Scanner(System.in);
        
        while(true){
            try{
                value = in.nextLine();
                        
                if(value.equals("end") || value.equals("END")){
                    return mean;
                }

                else{
                    sum += Double.parseDouble(value);
                
                    n++;
                    mean = sum / n;
                }
            }catch(Exception e){
                System.out.println("NumberFormatException: " + e.getMessage());
                return 0;
            }
    }
    }

    public double gcd(double a, double b){
        if(b == 0){
            return a;
        }

        return gcd(b,a%b);
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        double x = 0;
        double y = 0;

        Scanner input = new Scanner(System.in);
        try{
            while(true){
                System.out.println("-- MENU --");
                System.out.println("1. ADD");
                System.out.println("2. SUBTRACT");
                System.out.println("3. MULTIPLY");
                System.out.println("4. DIVIDE");
                System.out.println("5. SQUARE ROOT");
                System.out.println("6. POWER");
                System.out.println("7. MEAN");
                System.out.println("8. GCD");
                System.out.println("9. EXIT\n");
                System.out.println("ENTER CHOICE: ");
                int choice = input.nextInt();

                switch(choice){
                    case 1:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("%.3f + %.3f = %.3f\n",x,y,calculator.add(x,y)));
                        break;

                    case 2:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("%.3f - %.3f = %.3f\n",x,y,calculator.subtract(x,y)));
                        break;

                    case 3:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("%.3f * %.3f = %.3f\n",x,y,calculator.multiply(x,y)));
                        break;

                    case 4:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("%.3f / %.3f = %.3f\n",x,y,calculator.divide(x,y)));
                        break;

                    case 5:
                        x = input.nextDouble();
                        System.out.println(String.format("Sqrt(%.3f) = %.3f\n",x,calculator.sqrt(x)));
                        break;

                    case 6:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("%.3f ^ %.3f = %.3f\n",x,y,calculator.pow(x,y)));
                        break;

                    case 7:
                        System.out.println(String.format("mean: %.3f\n",calculator.mean()));
                        break;

                    case 8:
                        x = input.nextDouble();
                        y = input.nextDouble();
                        System.out.println(String.format("GCD(%.3f,%.3f): %.3f\n",x,y,calculator.gcd(x,y)));
                        break;

                    case 9:
                        return;

                    default:
                        System.out.println("INVALID CHOICE! TRY AGAIN!\n");
                        break;  
                }
            }            
        } catch(Exception e){
            System.out.println("InputMismatchException: " + e.getMessage());
        }
    }
}


