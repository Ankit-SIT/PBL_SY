import java.util.InputMismatchException;
import java.util.Scanner;

class Operand {
	private Integer Operand1;
	private Integer Operand2;
	
	Operand(Integer x, Integer y){
		this.Operand1 = x;
		this.Operand2 = y;
	}

	public Integer getX(){
		return this.Operand1;
	}

	public Integer getY(){
		return this.Operand2;
	}
}

class Add extends Operand {
	Add(Integer x, Integer y){
		super(x,y);	
	}

	public String toString(){
		return String.valueOf(super.getX() + super.getY());
	}

	public Double getResult(){
		return (double)(super.getX() + super.getY());
	}
}


class Subtract extends Operand {
	Subtract(Integer x, Integer y){
		super(x,y);	
	}

	public String toString(){
		return String.valueOf(super.getX() - super.getY());
	}

	public Double getResult(){
		return (double)(super.getX() - super.getY());
	}
}

class Multiply extends Operand {
	Multiply(Integer x, Integer y){
		super(x,y);
	}

	public String toString(){
		return String.valueOf(super.getX() * super.getY());
	}

	public Double getResult(){
		return (double)(super.getX() - super.getY());
	}
}


class Divide extends Operand {	
	Divide(Integer x, Integer y){
		super(x,y);	
	}

	public String toString() throws ArithmeticException {
		return String.valueOf(super.getX() / super.getY());
	}

	public Double getResult() throws ArithmeticException {
		return (double)(super.getX() / super.getY());
	}
}

class Compare extends Operand {
	Compare(Integer x, Integer y){
		super(x,y);
	}

	public String toString() {
		if(super.getX() == super.getY()){
			return "NUMBERS ARE THE SAME!";
		}

		return "NUMBERS ARE NOT THE SAME!";
	}
}

class Calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Double result = 0.0;
		Integer x = 0;
		Integer y = 0;
		Integer choice = 0;
		String ResultString = "";
		String operation = "";
		boolean DisplayAsFloat = false;
		
		System.out.println("ENTER X:");
		x = input.nextInt();
		
		while(true){
			try{
				System.out.println("-- MENU --");	
				System.out.println("1. ADD");
				System.out.println("2. SUBTRACT");
				System.out.println("3. MULTIPLY");
				System.out.println("4. DIVIDE");
				System.out.println("5. COMPARE");
				System.out.println("6. TOGGLE FLOATING POINT");
				System.out.println("7. DISPLAY");
				System.out.println("8. EXIT");
				System.out.println("ENTER CHOICE: ");

				choice = input.nextInt();

			} catch(InputMismatchException ex){
				System.out.println("CHOICE MUST BE AN INTEGER!");
			}

			if(choice < 6 && choice >= 1){
				try{	
					System.out.println("ENTER Y:");
					y = input.nextInt();
				} catch(InputMismatchException ex){
					System.out.println("OPERANDS MUST BE INTEGERS!");
				}		
			}

			try{
				switch(choice){
					case 1:
						result = new Add(x,y).getResult();
						operation = " + ";
						break;
					case 2:
						result = new Subtract(x,y).getResult();
						operation = " - ";
						break;
					case 3:
						result = new Multiply(x,y).getResult();
						operation = " x ";
						break;
					case 4:
						result = new Divide(x,y).getResult();
						operation = " / ";
						break;
					case 5:
						System.out.println(new Compare(x,y));
						break;

					case 6:
						DisplayAsFloat = !DisplayAsFloat;
						System.out.println("CONVERSION SUCCESSFULL!");
						break;

					case 7:	
						if(DisplayAsFloat){
							ResultString = String.valueOf(result.doubleValue());
						} else {
							ResultString = String.valueOf(result.intValue());
						}
					
						System.out.println(x + operation + y + " = " + ResultString + "\n");
						x = result.intValue();
						break;

					case 8:
						return;
					
					default:
						System.out.println("INVALID CHOICE! TRY AGAIN!");
						break;
				}

			} catch(NullPointerException exp){
				System.out.println("ERROR OCCURED WHILE OPERATING!");
			} catch(ArithmeticException exp){
				System.out.println("ERROR OCCURED! CANNOT DIVIDE BY ZERO!");
			} catch(Exception exp){
				System.out.println("ERROR OCCURED! UNHANDLED EXCEPTION!");
			}
		}
	}
}



