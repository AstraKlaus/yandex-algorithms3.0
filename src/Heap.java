import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Heap {
    public static void main(String[] args) throws IOException {
        MyHeap heap = new MyHeap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String current;
        for (int i = 1; i <= count; i++){
            current = reader.readLine();
            if (heap.back >= heap.heap.length - 2) { heap.extension();}
            if (current.equals("1")) {
                System.out.println(heap.extract());
            } else if (current.charAt(0) == '0') {
                heap.insert(Integer.parseInt(current.split(" ")[1]));
            }
        }
    }
}


class MyHeap {
    Integer[] heap = new Integer[10];
    int front = 0;
    int back = -1;

    public void insert(int n){
        heap[++back] = n;
        filtration();
    }

    public int extract(){
        int head = heap[0];
        heap[0] = heap[back];
        int current = 0;
        heap[back--] = null;
        while (size() > current*2+1){
            if (current*2+2 < size()){
                if (heap[current*2+1] <= heap[current] && heap[current*2+2] <= heap[current]) { break;}
                else if (heap[current*2+1] > heap[current] && heap[current*2+2] <= heap[current*2+1]){
                    int temp = heap[current*2+1];
                    heap[current*2+1] = heap[current];
                    heap[current] = temp;
                    current = current*2+1;
                } else if (heap[current * 2 + 2] > heap[current]  && heap[current*2+1] <= heap[current*2+2]) {
                    int temp = heap[current*2+2];
                    heap[current*2+2] = heap[current];
                    heap[current] = temp;
                    current = current*2+2;
                }
            } else if (heap[current*2+1] >= heap[current]){
                int temp = heap[current*2+1];
                heap[current*2+1] = heap[current];
                heap[current] = temp;
                current = current*2+1;
            } else {break;}
        }
        return head;
    }

    public int size(){
        return back-front + 1;
    }

    public void extension(){
        Integer[] temp = new Integer[back*2];
        System.arraycopy(heap, 0, temp, 0, back + 1);
        heap = temp;
    }

    public void filtration(){
        int current = back;
        while ((current-1)/2 >= 0 && heap[(current-1)/2] < heap[current]){
            int temp = heap[(current-1)/2];
            heap[(current-1)/2] = heap[current];
            heap[current] = temp;
            current = (current-1)/2;
        }
    }
}