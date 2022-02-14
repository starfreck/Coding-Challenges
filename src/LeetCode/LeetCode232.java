package LeetCode;
import java.util.*;

/**
 * 232. Implement Queue using Stacks
 * URL: https://leetcode.com/problems/implement-queue-using-stacks
 */

public class LeetCode232 {
    public static void main(String[] args) {
         // Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        // int param_1 = obj.peek();
        // System.out.println(param_1);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        System.out.println(param_2);
        obj.push(5);
        int param_3 = obj.pop();
        System.out.println(param_3);
        param_3 = obj.pop();
        System.out.println(param_3);
        param_3 = obj.pop();
        System.out.println(param_3);
        param_3 = obj.pop();
        System.out.println(param_3);



    }
}

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {

        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {

        // S1 is empty
        s1.push(x);

    }

    public int pop() {

        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    public int peek() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.peek();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */