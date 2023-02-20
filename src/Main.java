import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        MyDequeue queue = new MyDequeue();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String current = reader.readLine();
        while (!current.equals("exit")){
            if (queue.back == 199 || queue.front == 0) { queue.extension();}
            if (current.equals("pop_front")) {
                System.out.println(queue.popFront());
            } else if (current.equals("pop_back")) {
                System.out.println(queue.popBack());
            } else if (current.equals("front")) {
                System.out.println(queue.front());
            } else if (current.equals("back")) {
                System.out.println(queue.back());
            } else if (current.equals("size")) {
                System.out.println(queue.size());
            } else if (current.equals("clear")) {
                System.out.println(queue.clear());
            } else if (current.startsWith("push_front")) {
                System.out.println(queue.pushFront(Integer.parseInt(current.split(" ")[1])));
            } else if (current.startsWith("push_back")) {
                System.out.println(queue.pushBack(Integer.parseInt(current.split(" ")[1])));
            }
            current = reader.readLine();
        }
        System.out.println("bye");
    }
}


class MyDequeue {
    Integer[] queue = new Integer[200];
    int front = 100;
    int back = 99;

    public String pushFront(int n){
        front--;
        queue[front] = n;
        return "ok";
    }

    public String pushBack(int n){
        back++;
        queue[back] = n;
        return "ok";
    }

    public String popFront(){
        if (queue[front] == null) { return "error"; }
        else {
            String temp = queue[front].toString();
            queue[front] = null;
            front++;
            return temp;
        }

    }

    public String popBack(){
        if (queue[back] == null) { return "error"; }
        else {
            String temp = queue[back].toString();
            queue[back] = null;
            back--;
            return temp;
        }
    }
    public String front(){
        if (queue[front] == null) { return "error"; }
        return queue[front].toString();
    }

    public String back(){
        if (queue[back] == null) { return "error"; }
        return queue[back].toString();
    }

    public int size(){
        return back-front + 1;
    }

    public String clear(){
        Arrays.fill(queue, null);
        front = 100;
        back = 99;
        return "ok";
    }

    public void extension(){
        Integer[] temp = new Integer[200];
        int offset = (back+front + 1)/2 - 100;
        for (int i= front; i <= back; i++) {
            temp[i-offset] = queue[i];
        }
        int diff = (back-front+1)/2;
        front = 100-diff;
        back = 100+diff -1;
        queue = temp;
    }
}