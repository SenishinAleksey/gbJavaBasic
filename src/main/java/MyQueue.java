import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {
    Stack<Integer> stackForPop;
    Stack<Integer> stackForPush;

    public MyQueue() {
        stackForPop = new Stack<>();
        stackForPush = new Stack<>();
    }

    public void push(int x) {
        stackForPush.push(x);
    }

    public int pop() {
        checkStackForPop();
        return stackForPop.pop();
    }

    public int peek() {
        checkStackForPop();
        return stackForPop.peek();
    }

    public boolean empty() {
        return stackForPop.isEmpty() && stackForPush.isEmpty();
    }

    private void checkStackForPop() {
        if (stackForPop.isEmpty()) {
            while (!stackForPush.isEmpty()) {
                stackForPop.push(stackForPush.pop());
            }
        }
    }
}
