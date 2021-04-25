public class Main {
    public static void main(String[] args) {
        FixedStack FStack = new FixedStack(3);
        GrowableStack GStack = new GrowableStack(3);

        try{
            FStack.push(11.0);
            FStack.push(1.0);
            System.out.println(FStack);

            System.out.println(FStack.pop());
            System.out.println(FStack.pop());
            
            System.out.println("- GSTACK -\n");
            GStack.push(11.0);
            GStack.push(12.0);
            GStack.push(13.0);
            GStack.push(14.0);
            GStack.push(15.0);
            GStack.push(16.0);
            GStack.push(17.0);
            System.out.println(GStack);

            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.pop());
            System.out.println(GStack.peek());
            
            
        } catch (NullPointerException exception){
            System.out.println("TRY AGAIN!");
        }
    }
}
