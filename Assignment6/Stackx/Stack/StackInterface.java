package Stack;

public interface StackInterface {
    void push(Double value);
    Double pop();
    Double peek();
    Integer getSize();
    Integer getCapacity();
    String toString();
}