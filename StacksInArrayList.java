import java.util.ArrayList;

public class StacksInArrayList {
     static class StackClass{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0 ;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if (isEmpty()){
                return -1 ;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top ;
        }

        public static int peek(){
            if (isEmpty()){
                return -1 ;
            }

            return list.get(list.size() - 1) ;
        }

    }

    // pushing the bottom at bottom using the built-in library and pushAtBottom()
    public static void pushAtBottom(int data , StackClass s){
        if (s.isEmpty()){// f ,
            s.push(data); // 4, 3, 2, 1
            return;
        }

        int top = s.pop() ; // 4
        pushAtBottom(data , s);
        s.push(top) ;
    }

    public static void revereStack(StackClass stack){
        if (stack.isEmpty()){ // f
            return;
        }

        int top = stack.pop(); // 4 , 3 , 2, 1
        revereStack(stack);
        pushAtBottom(top, stack);
    }

    public static void main(String[] args) {
        StackClass stack = new StackClass() ;

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        revereStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
