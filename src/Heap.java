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


