// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {
    Stack<Integer> s1;
    Stack<Integer> s2;

// time complexity = O(1)
// space complexity = constant 
    public Queue() {
        s1 = new Stack();
        s2 = new Stack();

    }

    // Push element x to the back of queue.
    // Time complexity O(1)
    // Space complexity constant
    public void enqueue(int x) {
        s1.push(x);

    }

    // Removes the element from in front of queue.
    // Time complexity O(n)
    // Space complexity O(n)
    public int dequeue() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();

    }
    
    // Get the front element.
    // Time complexity O(n)
    // Space complexity O(n)
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();

    }
    
    // Return whether the queue is empty.
    // Time complexity O(1)
    // Space complexity constant
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();

    }

    // Return the number of elements in queue.
    // Time complexity O(1)
    // Space complexity constant
    public int size() {
        return s1.size()+ s2.size();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
    }
}
