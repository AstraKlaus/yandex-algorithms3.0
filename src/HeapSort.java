import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        MyHeap heap = new MyHeap(count);
        heap.heap = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        heap.sorted();
        for (int i = 0; i < count; i++)
            System.out.print(heap.heap[i] + (i != count-1 ? " " : ""));
    }
}

class MyHeap {
    Integer[] heap;
    int front = 0;
    int back = -1;

    MyHeap(int capacity){heap = new Integer[capacity]; back = capacity-1;}

    MyHeap(){heap = new Integer[10];}

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
                if (heap[current*2+1] >= heap[current] && heap[current*2+2] >= heap[current]) { break; }
                else if (heap[current*2+1] < heap[current] && heap[current*2+2] >= heap[current*2+1]){
                    int temp = heap[current*2+1];
                    heap[current*2+1] = heap[current];
                    heap[current] = temp;
                    current = current*2+1;
                } else if (heap[current * 2 + 2] < heap[current]  && heap[current*2+1] >= heap[current*2+2]) {
                    int temp = heap[current*2+2];
                    heap[current*2+2] = heap[current];
                    heap[current] = temp;
                    current = current*2+2;
                }
            } else if (heap[current*2+1] <= heap[current]){
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

    public void sorted(){
        int n = heap.length;
        for(int i = n / 2 - 1; i>=0; i--)
            heapify(i, n);

        for (int i = n - 1; i>=0; i--){
            int temp = heap[i];
            heap[i] = heap[0];
            heap[0] = temp;

            heapify(0, i);
        }
    }

    public void heapify(int i, int n){
        int l = i * 2 + 1;
        int r = i *2 + 2;
        int largest = i;

        if (l<n && heap[l] > heap[largest])
            largest = l;
        if (r<n && heap[r] > heap[largest])
            largest = r;

        if (i!=largest){
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest, n);
        }
    }
}