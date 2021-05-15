class MyExcep extends Exception {
	private String Message;

	MyExcep(){
		this.Message = "OUT OF LIMITS!";
	}

	MyExcep(String Term){
		this.Message = Term + " IS OUT OF BOUNDS FOR THE SPECIFIED LIMITS!";
	}

	public String toString(){
		return this.Message;
	}
}

class Utils {
	public Integer factorial(Integer n){
		if(n == 1){
			return 1;
		}
			
		return n * factorial(n - 1);
	}	

}

class Factorial {
	public static void main(String[] args){
		Integer limit1 = 0;
		Integer limit2 = 0;
		Integer n = 0;
		Utils util = new Utils();

		if(args.length < 3){
			System.out.println("USAGE: Factorial Limit1 Limit2 n\n");
			return;
		}	

		if(args.length >= 3){
			try{	
				limit1 = Integer.valueOf(args[0]);
				limit2 = Integer.valueOf(args[1]);
				
				if(limit1 > limit2){
					Integer temp = limit1;
					limit1 = limit2;
					limit2 = temp;
				}

				for(int i = 2; i < args.length; ++i){
					n = Integer.valueOf(args[i]);

					if(n < limit2 && n > limit1){
						System.out.println("FACTORIAL OF " + n + " IS: " + util.factorial(n));
					}	

					else {
						throw new MyExcep(args[i]);
					}
				}
				

			} catch (NumberFormatException exp){
				System.out.println("INVALID INPUT!");
			} catch (MyExcep exp){
				System.out.println(exp);
			}
		}
	}
}
