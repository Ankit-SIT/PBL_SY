import Stack.*;

public class FixedStack implements StackInterface {
    private Double[] Stack;
    private Integer capacity;
    private Integer size;

    FixedStack(){
        this.size = 0;
        this.capacity = 10;
    
        Stack = new Double[this.capacity];
    }

    FixedStack(Integer capacity){
        this.size = 0;
        this.capacity = capacity;

        Stack = new Double[this.capacity];
    }
    
    public void push(Double value){
        try {
            if(this.size >= this.capacity){
                System.out.println("STACK FULL!");
                return;
            }

            this.size++;
            this.Stack[this.size] = value;
        } catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("STACK TOO SMALL!");
        } catch (Exception exception){
            System.out.println("UNKNOWN EXCEPTION: ");
            System.out.println(exception.getMessage());
            
        } 
    }

    public Double pop() throws NullPointerException {
        try {
            if(this.size <= 0){
                System.out.println("STACK EMPTY!");
                throw new NullPointerException();
            }

            Double temp = this.Stack[size];
            this.size--;
            return temp;

        } catch (NullPointerException exception){
            throw new NullPointerException();
        } catch (Exception exception){
            System.out.println("STACK NOT CREATED!");
            throw new NullPointerException();
        }
    }

    public Double peek() throws NullPointerException{
        try {
           return Stack[size];
        } catch (Exception exception){
            System.out.println("UNKNOWN EXCEPTION: ");
            System.out.println(exception.getMessage());
            throw new NullPointerException();
        }
    }

    public Integer getSize(){
        return this.size;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public String toString(){
        String result = "";
        for (Double value : Stack) {
            result += value + " ";
        }

        result += "\n";

        return result;
    }
}