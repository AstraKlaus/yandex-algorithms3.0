import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MinRightFind {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] massive = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] indices = new int[count];
        Arrays.fill(indices, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++){
            if (stack.empty()) stack.push(i);
            else {
                for (int j = stack.size()-1; j >= 0; j--){
                    if (massive[stack.peek()] > massive[i]){
                        indices[stack.pop()] = i;
                    }
                    else break;
                }
                stack.push(i);
            }
        }
        for (int i = 0; i < count; i++)
            System.out.print(indices[i] + (i != count-1 ? " " : ""));
    }
}
