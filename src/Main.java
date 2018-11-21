import dynamic_ds.Stack;

public class Main
{

    public static void main(String args[])
    {
        Stack stack = new Stack();

        stack.optimisedPush(5);
        stack.optimisedPush(3);
        stack.optimisedPush(2);
        stack.optimisedPush(1);
        stack.optimisedPush(8);

        //System.out.println(stack.stackLength());

        //System.out.println(stack.isEmpty());
        stack.print();
    }

}
