import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nums = reader.readLine();
        int count = Integer.parseInt(nums.split(" ")[0]);
        int step = Integer.parseInt(nums.split(" ")[1]);
        if (step > count) step = count;
        int[] ans = new int[count+1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i<=step;i++){
            ans[i] = Arrays.stream(ans).sum();
        }
        for (int i = step+1; i<=count;i++){
            ans[i] = Arrays.stream(Arrays.copyOfRange(ans, i-step, i)).sum();
        }
        System.out.println(ans[count]);
    }
}
