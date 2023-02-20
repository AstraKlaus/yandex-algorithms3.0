import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        MyQueue queue = new MyQueue();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String current = reader.readLine();
        while (!current.equals("exit")){
            if (current.equals("pop")) {
                System.out.println(queue.pop());
            } else if (current.equals("front")) {
                System.out.println(queue.front());
            } else if (current.equals("size")) {
                System.out.println(queue.size());
            } else if (current.equals("clear")) {
                System.out.println(queue.clear());
            } else if (current.startsWith("push")) {
                System.out.println(queue.push(Integer.parseInt(current.split(" ")[1])));
            }
            current = reader.readLine();
        }
        System.out.println("bye");
    }
}

class MyQueue {
    LinkedList<Integer> queue = new LinkedList<>();


    public String push(int n){
        queue.add(n);
        return "ok";
    }

    public String pop(){
        return queue.peekFirst() == null ? "error" : queue.pollFirst().toString();
    }

    public String front(){
        return queue.peekFirst() == null ? "error" : queue.peekFirst().toString();
    }

    public int size(){
        return queue.size();
    }

    public String clear(){
        queue.clear();
        return "ok";
    }
}