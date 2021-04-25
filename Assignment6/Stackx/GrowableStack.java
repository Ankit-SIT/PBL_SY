import Stack.*;
import java.util.ArrayList;

public class GrowableStack implements StackInterface {
    private ArrayList<Double> Stack;
    Integer capacity;

    GrowableStack(){
        Stack = new ArrayList<Double>();
        this.capacity = 10;
    }

    GrowableStack(Integer capacity){
        this.capacity = capacity;
        Stack = new ArrayList<Double>(this.capacity.intValue());
    }

    public void push(Double value){
        Stack.add(value);
    }

    public Double pop() throws NullPointerException {
        try {
            if(Stack.size() <= 0){
                System.out.println("STACK EMPTY!");
                throw new NullPointerException();
            }

            Double temp = Stack.get(Stack.size() - 1);
            Stack.remove(Stack.size() - 1);

            return temp;
        } catch (NullPointerException exception){
            throw new NullPointerException();
        } catch (Exception exception){
            System.out.println("UNKNOWN EXCEPTION!\n");
            System.out.println(exception.getMessage());
            throw new NullPointerException();
        }
    }

    public Double peek(){
        try{
            if(Stack.size() <= 0){
                System.out.println("STACK EMPTY!");
                throw new NullPointerException();
            }
            return Stack.get(Stack.size());
        } catch (NullPointerException exception){
            throw new NullPointerException();
        } catch (Exception exception){
            System.out.println("UNKNOWN EXCEPTION!\n");
            System.out.println(exception.getMessage());
            throw new NullPointerException();
        }
    }
    
    public Integer getSize(){
        return Stack.size();
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
